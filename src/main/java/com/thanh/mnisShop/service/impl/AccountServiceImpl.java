package com.thanh.mnisShop.service.impl;

import com.thanh.mnisShop.model.Account;
import com.thanh.mnisShop.model.Authority;
import com.thanh.mnisShop.model.Role;
import com.thanh.mnisShop.repository.AccountRepository;
import com.thanh.mnisShop.repository.AuthorityRepository;
import com.thanh.mnisShop.service.AccountService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public Account findById(String username) {
        return accountRepository.findById(username).get();
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account create(Account account, Role role) {
        String password = passwordEncoder.encode(account.getPassword());
        account.setPassword(password);
        Account savedAccount = accountRepository.save(account);

        Authority authority = new Authority();
        authority.setAccount(savedAccount);
        authority.setRole(role);
        authorityRepository.save(authority);

        return savedAccount;
    }

    @Override
    public Account update(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public void delete(String id) {
        Optional<Account> account = accountRepository.findById(id);
        if (account.isPresent()) {
            accountRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Category not found with id: " + id);
        }
    }
}
