package ma.enset;


import ma.enset.Entities.BankAccount;
import ma.enset.Enums.AccountType;
import ma.enset.Repositories.BankAccountRepositoryImpl;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        JsonSerializer<BankAccount> bankAccountJsonSerializer = new JsonSerializer<>();
        BankAccountRepositoryImpl bankAccountRepository = BankAccountRepositoryImpl.getInstance();
        for (int i = 0 ; i < 10 ; i++){
            new Thread(()->{
                bankAccountRepository.populateData();
            }).start();
        }
        System.out.println("taper une touche de clavier");
        System.in.read();


        //List<BankAccount> bankAccounts = bankAccountRepository.searchAccounts(account -> account.getType().equals(AccountType.CURRENT));

        List<BankAccount> bankAccounts = bankAccountRepository.findAll();
        bankAccounts.stream().map(
            bankAccountJsonSerializer::toJson).forEach(System.out::println);

      /*




        System.out.println("---------------------");
        BankAccount account = bankAccountRepository.findById(1L).orElse(null);
        if(account!=null){
            System.out.println(bankAccountJsonSerializer.toJson(account));
        }
        System.out.println("---------------------");
       */
    }
}