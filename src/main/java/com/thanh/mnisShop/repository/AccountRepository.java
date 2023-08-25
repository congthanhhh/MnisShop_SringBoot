package com.thanh.mnisShop.repository;

import com.thanh.mnisShop.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, String> {

    @Query("SELECT DISTINCT a.account FROM Authority a WHERE a.role.id IN ('DIRE', 'STAF')")
    List<Account> getAdministrators();

    @Query("SELECT a FROM Account a WHERE a.username = ?1")
    Account findByUsername(String username);
}
