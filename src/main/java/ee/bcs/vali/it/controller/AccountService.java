package ee.bcs.vali.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public void transferMoney(String fromAccount,
                              String toAccount,
                              BigDecimal amount) {
        BigDecimal fromAccountBalance = accountRepository.getBalance(fromAccount);
        if (fromAccountBalance.compareTo(amount) >= 0) {
            BigDecimal toAccountBalance = accountRepository.getBalance(toAccount);
            fromAccountBalance = fromAccountBalance.subtract(amount);
            toAccountBalance = toAccountBalance.add(amount);
            accountRepository.updateBalance(fromAccount, fromAccountBalance);
            accountRepository.updateBalance(toAccount, toAccountBalance);
        }
    }
    public void withrawMoney(String fromAccount,
                             BigDecimal amount) {
        BigDecimal fromAccountBalance = accountRepository.getBalance(fromAccount);
        if (fromAccountBalance.compareTo(amount) >= 0) {
            fromAccountBalance = fromAccountBalance.subtract(amount);
            accountRepository.updateBalance(fromAccount, fromAccountBalance);
        }

    }
    public void depositMoney(String fromAccount,
                             BigDecimal amount,
                             BigDecimal depo, BigDecimal account, BigDecimal withraw, BigDecimal transferIn, BigDecimal transferOut) {
        BigDecimal fromAccountBalance = accountRepository.getBalance(fromAccount);
        fromAccountBalance = fromAccountBalance.add(amount);
        accountRepository.updateBalance(fromAccount, fromAccountBalance);
        accountRepository.updateHistory(depo, account, withraw, transferIn, transferOut);
    }
    public BigDecimal getAccountMoney(String fromAccount) {
        return accountRepository.getBalance(fromAccount);
    }

    public void addAccount(String fromAccount, BigDecimal balance, BigInteger clientId) {
        accountRepository.addAccount(fromAccount, balance, clientId);
    }
    public BigInteger addClient(String firstName, String lastName, BigInteger clientId) {
        return accountRepository.addClient(firstName, lastName, clientId);
    }

}
