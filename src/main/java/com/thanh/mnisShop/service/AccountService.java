package com.thanh.mnisShop.service;

import com.thanh.mnisShop.model.Account;
import com.thanh.mnisShop.model.Role;

import java.util.List;

public interface AccountService {

    Account findById(String username);

    List<Account> findAll();

    Account create(Account account, Role role);

    Account update(Account account);

    void delete(String id);
}
