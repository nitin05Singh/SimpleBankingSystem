package net.javaguides.banking_app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.banking_app.entity.Account;
import net.javaguides.banking_app.service.AccountService;

/**
 * AccountController handles HTTP requests for the Account entity.
 * It provides endpoints for creating, retrieving, updating, and deleting accounts,
 * along with deposit and withdrawal operations.
 */

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    // The service that contains business logic for Account operations
    private AccountService accountService;

    /**
     * Constructor-based dependency injection for AccountService.
     * 
     * @param accountService The service layer used to perform account operations.
     */
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * Endpoint to create a new account.
     * 
     * @param account The account details in the request body.
     * @return ResponseEntity containing the created account and HTTP status 201 (CREATED).
     */
    @PostMapping
    public ResponseEntity<Account> addAccount(@RequestBody Account account) {
        return new ResponseEntity<>(accountService.createAccount(account), HttpStatus.CREATED);
    }

    /**
     * Endpoint to retrieve an account by ID.
     * 
     * @param id The ID of the account to retrieve.
     * @return ResponseEntity containing the account and HTTP status 200 (OK).
     */
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        Account account = accountService.getAccountById(id);
        return ResponseEntity.ok(account);
    }

    /**
     * Endpoint to deposit money into an account.
     * 
     * @param id The ID of the account.
     * @param request A map containing the deposit amount.
     * @return ResponseEntity containing the updated account and HTTP status 200 (OK).
     */
    @PutMapping("/{id}/deposit")
    public ResponseEntity<Account> depositAccount(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        Account account = accountService.deposit(id, amount);
        return ResponseEntity.ok(account);
    }

    /**
     * Endpoint to withdraw money from an account.
     * 
     * @param id The ID of the account.
     * @param request A map containing the withdrawal amount.
     * @return ResponseEntity containing the updated account and HTTP status 200 (OK).
     */
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<Account> withdrawAccount(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        Account account = accountService.withdraw(id, amount);
        return ResponseEntity.ok(account);
    }

    /**
     * Endpoint to retrieve all accounts.
     * 
     * @return ResponseEntity containing a list of all accounts and HTTP status 200 (OK).
     */
    @GetMapping
    public ResponseEntity<List<Account>> getAllAccount() {
        List<Account> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    /**
     * Endpoint to delete an account by ID.
     * 
     * @param id The ID of the account to delete.
     * @return ResponseEntity with a message confirming account deletion and HTTP status 200 (OK).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account Deleted");
    }
}
