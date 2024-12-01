package ma.enset.Repositories;

import ma.enset.Enums.AccountStatus;
import ma.enset.Enums.AccountType;
import ma.enset.Entities.BankAccount;
import ma.enset.Directors.BankDirector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

public class BankAccountRepositoryImpl implements BankAccountRepository {

    private static final BankAccountRepositoryImpl accountRepository;

    
    static {
        System.out.println("Singleton instantiation");
        accountRepository = new BankAccountRepositoryImpl();

    }


    private BankAccountRepositoryImpl(){

    }
    private Map<Long, BankAccount> accounts = new HashMap<>();
    private long accountCount=0;
    @Override
    public Optional<BankAccount> findById(Long accountId) {
        BankAccount bankAccount = accounts.get(accountId);
        if(bankAccount!=null)
            return Optional.of(bankAccount);
        else return Optional.empty();
    }

    @Override
    public List<BankAccount> findAll() {
        return accounts.values().stream().toList();
    }

    @Override
    public BankAccount save(BankAccount bankAccount) {
        Long accountId ;
        synchronized (this) {
            accountId = ++accountCount;

        }

        bankAccount.setAccountId(accountId);
        synchronized (this) {
            accounts.put(accountId,bankAccount);
        }
        return bankAccount;
    }

    @Override
    public BankAccount update(BankAccount bankAccount) {
        accounts.put(bankAccount.getAccountId(),bankAccount);
        return bankAccount;
    }

    @Override
    public void delete(Long accountId) {
        accounts.remove(accountId);
    }

    @Override
    public List<BankAccount> searchAccounts(Predicate<BankAccount> predicate) {
        return accounts.values().stream().filter(predicate).toList();
    }
    public void populateData(){
        for (int i = 0; i < 10; i++) {
            BankAccount bankAccount = BankDirector.accountBuilder()
                    .withBalance(Math.random()*10000)
                    .withCurrency(Math.random()>0.5?"MAD":"USD")
                    .withStatus(Math.random()>0.5? AccountStatus.CREATED:AccountStatus.ACTIVATED)
                    .withType(Math.random()>0.5? AccountType.CURRENT:AccountType.SAVINGS)
                    .build();
            save(bankAccount);
        }
        System.out.println("-------------------------");
        System.out.println(Thread.currentThread().getName());
        System.out.println("Account count = "+accountCount);
        System.out.println("Size =" + accounts.values().size());
        System.out.println("-------------------------");
    }

    public synchronized static BankAccountRepositoryImpl getInstance(){
        /*if(accountRepository==null)
            System.out.println("Singleton instantiation");
            accountRepository=new BankAccountRepositoryImpl();*/
        return accountRepository;
    }
}
