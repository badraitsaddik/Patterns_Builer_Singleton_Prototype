package ma.enset.Repositories;

import ma.enset.Entities.BankAccount;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface BankAccountRepository {
    Optional<BankAccount> findById(Long accountId);
    List<BankAccount> findAll();
    BankAccount save(BankAccount bankAccount);
    BankAccount update(BankAccount bankAccount);
    void delete(Long accountId);
    List<BankAccount> searchAccounts(Predicate<BankAccount> predicate);
}
