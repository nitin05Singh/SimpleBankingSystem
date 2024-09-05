package net.javaguides.banking_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.javaguides.banking_app.entity.Account;

/**
 * AccountRepository interface for performing CRUD operations on the Account entity.
 * This repository provides methods to interact with the 'accounts' table in the database.
 * It extends JpaRepository, which provides built-in methods like save, findAll, findById, delete, etc.
 * 
 * JpaRepository<Account, Long>:
 * - Account: The entity type that this repository will manage.
 * - Long: The type of the primary key (id) for the Account entity.
 */

public interface AccountRepository extends JpaRepository<Account, Long> {
    // You can define custom query methods here if needed
}
