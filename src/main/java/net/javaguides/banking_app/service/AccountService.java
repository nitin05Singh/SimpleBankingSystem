package net.javaguides.banking_app.service;

import java.util.List;
import net.javaguides.banking_app.entity.Account;

/**
 * AccountService interface defines the service layer for the Account entity.
 * It contains methods for creating, retrieving, updating, and deleting accounts, 
 * along with deposit and withdrawal functionality.
 */

public interface AccountService {

    /**
     * Creates a new account.
     * 
     * @param account The account entity to be created.
     * @return The created account.
     */
    Account createAccount(Account account);
    
    /**
     * Retrieves an account by its ID.
     * 
     * @param id The ID of the account to retrieve.
     * @return The account with the given ID, or null if not found.
     */
    Account getAccountById(Long id);
    
    /**
     * Deposits a specified amount into the account with the given ID.
     * 
     * @param id The ID of the account to deposit into.
     * @param amount The amount to be deposited.
     * @return The updated account with the new balance.
     */
    Account deposit(Long id, Double amount);
    
    /**
     * Withdraws a specified amount from the account with the given ID.
     * 
     * @param id The ID of the account to withdraw from.
     * @param amount The amount to be withdrawn.
     * @return The updated account with the new balance.
     */
    Account withdraw(Long id, Double amount);
    
    /**
     * Retrieves a list of all accounts.
     * 
     * @return A list of all account entities.
     */
    List<Account> getAllAccounts();
    
    /**
     * Deletes the account with the given ID.
     * 
     * @param id The ID of the account to be deleted.
     */
    void deleteAccount(Long id);
}
