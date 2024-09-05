package net.javaguides.banking_app.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.banking_app.entity.Account;
import net.javaguides.banking_app.repository.AccountRepository;
import net.javaguides.banking_app.service.AccountService;

/**
 * AccountServiceImpl implements the AccountService interface.
 * It provides the business logic for creating, retrieving, updating, 
 * and deleting accounts, as well as deposit and withdrawal functionality.
 */

@Service
public class AccountServiceImpl implements AccountService {

    // The repository to interact with the database for Account entity operations
    private AccountRepository accountRepository;

    /**
     * Constructor-based dependency injection for AccountRepository.
     * 
     * @param accountRepository The AccountRepository to interact with the database.
     */
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /**
     * Creates a new account by saving it to the database.
     * 
     * @param account The account entity to be created.
     * @return The saved account entity.
     */
    @Override
    public Account createAccount(Account account) {
        Account savedAccount = accountRepository.save(account);
        return savedAccount;
    }

    /**
     * Retrieves an account by its ID. Throws an exception if the account is not found.
     * 
     * @param id The ID of the account to retrieve.
     * @return The account entity with the given ID.
     */
    @Override
    public Account getAccountById(Long id) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account Does Not Exist"));
        return account;
    }

    /**
     * Deposits a specified amount into an account.
     * 
     * @param id The ID of the account.
     * @param amount The amount to deposit.
     * @return The updated account with the new balance.
     */
    @Override
    public Account deposit(Long id, Double amount) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account Does Not Exist"));

        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return savedAccount;
    }

    /**
     * Withdraws a specified amount from an account. Throws an exception if 
     * the balance is insufficient.
     * 
     * @param id The ID of the account.
     * @param amount The amount to withdraw.
     * @return The updated account with the new balance.
     */
    @Override
    public Account withdraw(Long id, Double amount) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account Does Not Exist"));

        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient Balance.");
        }

        double total = account.getBalance() - amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return savedAccount;
    }

    /**
     * Retrieves a list of all accounts from the database.
     * 
     * @return A list of account entities.
     */
    @Override
    public List<Account> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts;
    }

    /**
     * Deletes an account by its ID. Throws an exception if the account is not found.
     * 
     * @param id The ID of the account to delete.
     */
    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account Does Not Exist"));

        accountRepository.deleteById(id);
    }
}
