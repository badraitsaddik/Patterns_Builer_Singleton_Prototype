package ma.enset.Entities;

import ma.enset.Enums.AccountStatus;
import ma.enset.Enums.AccountType;

public class BankAccount implements Cloneable {
    private Long accountId;
    private double balance;
    private AccountType type;
    private AccountStatus status;
    private String currency;
    private Customer customer;

    public BankAccount() {
    }


    public BankAccount(Long accountId, double balance, AccountType type, AccountStatus status, String currency, Customer customer) {
        this.accountId = accountId;
        this.balance = balance;
        this.type = type;
        this.status = status;
        this.currency = currency;
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountId=" + accountId +
                ", balance=" + balance +
                ", type=" + type +
                ", status=" + status +
                ", currency='" + currency + '\'' +
                ", customer=" + customer +
                '}';
    }

    public static class AccountBuilder {
        private BankAccount bankAccount = new BankAccount();

        public AccountBuilder withAccountId(Long accountId) {
            bankAccount.setAccountId(accountId);
            return this;
        }

        public AccountBuilder withBalance(double balance) {
            bankAccount.setBalance(balance);
            return this;
        }

        public AccountBuilder withType(AccountType type) {
            bankAccount.setType(type);
            return this;
        }

        public AccountBuilder withStatus(AccountStatus status) {
            bankAccount.setStatus(status);
            return this;
        }

        public AccountBuilder withCurrency(String currency) {
            bankAccount.setCurrency(currency);
            return this;
        }

        public BankAccount build() {
            return bankAccount;
        }
    }

    @Override
    public BankAccount clone() throws CloneNotSupportedException {
        BankAccount bankAccount = (BankAccount) super.clone();
        bankAccount.setCustomer(this.customer.clone());
        return bankAccount;
    }
}
