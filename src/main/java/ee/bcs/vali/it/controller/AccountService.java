package ee.bcs.vali.it.controller;

import org.apache.tomcat.jni.BIOCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BandCombineOp;
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
            BigInteger accountNrFrom = accountRepository.getAccountId(fromAccount);
            BigInteger accountNrTo = accountRepository.getAccountId(toAccount);
            accountRepository.updateBalance(fromAccount, fromAccountBalance);
            accountRepository.updateBalance(toAccount, toAccountBalance);
            accountRepository.updateHistoryWithraw(accountNrFrom, amount);
            accountRepository.updateHistoryDepo(accountNrTo, amount);
        }
    }
    public void withrawMoney(String fromAccount,
                             BigDecimal amount, BigInteger accountId) {
        BigDecimal fromAccountBalance = accountRepository.getBalance(fromAccount);
        if (fromAccountBalance.compareTo(amount) >= 0) {
            fromAccountBalance = fromAccountBalance.subtract(amount);
            BigInteger accountNr = accountRepository.getAccountId(fromAccount);
            accountRepository.updateBalance(fromAccount, fromAccountBalance);
            accountRepository.updateHistoryWithraw(accountNr, amount);
        }
    }
    public void depositMoney(String fromAccount,
                             BigDecimal amount, BigInteger accountId) {
        BigDecimal fromAccountBalance = accountRepository.getBalance(fromAccount);
        fromAccountBalance = fromAccountBalance.add(amount);
        accountRepository.updateBalance(fromAccount, fromAccountBalance);
        BigInteger accountNr = accountRepository.getAccountId(fromAccount);
        accountRepository.updateHistoryDepo(accountNr, amount);
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
