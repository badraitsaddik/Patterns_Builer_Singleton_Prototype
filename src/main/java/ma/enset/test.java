package ma.enset;

import ma.enset.Entities.BankAccount;
import ma.enset.Entities.Customer;
import ma.enset.Enums.AccountStatus;
import ma.enset.Enums.AccountType;

public class test {
    public static void main(String[] args) throws CloneNotSupportedException {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountId(1L);
        bankAccount.setBalance(9000);
        bankAccount.setCurrency("MAD");
        bankAccount.setType(AccountType.SAVINGS);
        bankAccount.setStatus(AccountStatus.ACTIVATED);
        bankAccount.setCustomer(new Customer(1L,"mohamed"));

        BankAccount bankAccount1 = bankAccount.clone();

        System.out.println("ACC1"+bankAccount);
        System.out.println("ACC2"+bankAccount1);

        bankAccount.getCustomer().setName("badr");
        System.out.println("----------------------");
        System.out.println("ACC1"+bankAccount);
        System.out.println("ACC2"+bankAccount1);
    }


}
