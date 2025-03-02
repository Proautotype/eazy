package com.eazybytes.accounts.respository;

import com.eazybytes.accounts.entity.Accounts;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Accounts, String> {
    Optional<Accounts> findByCustomerId(String customerId);

    @Transactional @Modifying
    void deleteByCustomerId(String customerId);
}
