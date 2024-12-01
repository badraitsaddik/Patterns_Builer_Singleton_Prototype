package ma.enset.Directors;

import ma.enset.Entities.BankAccount;

public class BankDirector {
    public static BankAccount.AccountBuilder accountBuilder() {
        return new BankAccount.AccountBuilder();
    }
}
