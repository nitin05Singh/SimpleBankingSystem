package net.javaguides.banking_app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Account Entity representing the 'accounts' table in the database.
 * It holds information about a bank account, including account holder's name and balance.
 */

// Lombok annotations to generate getter and setter methods automatically
@Getter
@Setter
// Lombok annotation to generate a no-argument constructor
@NoArgsConstructor
// Lombok annotation to generate a constructor with all fields
@AllArgsConstructor
// Specifies the table this entity is mapped to
@Table(name = "accounts")
// Marks this class as a JPA entity
@Entity
public class Account {

    // The primary key of the account table, automatically generated
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // Specifies the account holder name column in the 'accounts' table
    @Column(name = "account_holder_name")
    private String accountHolderName;

    // The balance field to store the account balance in the database
    private double balance;
}
