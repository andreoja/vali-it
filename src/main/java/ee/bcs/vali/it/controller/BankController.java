package ee.bcs.vali.it.controller;

import ee.bcs.vali.it.Account;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class BankController {
    private static final Map<String, Double> bankAccount = new HashMap<>();

    @PostMapping("account")
    public Double createAccount(@RequestBody Account accountNumber){
        bankAccount.put(accountNumber.getAccountNr(), accountNumber.getBalance());
        return bankAccount.get(accountNumber.getAccountNr());
    }
    @GetMapping("account/{id}")
    public Double getAccount(@PathVariable("id")String accountNumber){
        return bankAccount.get(accountNumber);
    }

    @PutMapping("accountdepo")
    public Double depositMoney(@RequestBody Account accountNumber){
        bankAccount.put(accountNumber.getAccountNr(),
                bankAccount.get(accountNumber.getAccountNr()) + accountNumber.getBalance());
        return bankAccount.get(accountNumber.getAccountNr());
    }
    @PutMapping("accountwithraw")
    public Double withrawMoney(@RequestBody Account accountNumber){
        if (BigDecimal.valueOf(bankAccount.get(accountNumber.getAccountNr())).compareTo(
                BigDecimal.valueOf(accountNumber.getBalance()))>0){
                bankAccount.put(accountNumber.getAccountNr(),
                    bankAccount.get(accountNumber.getAccountNr()) - accountNumber.getBalance());
            return bankAccount.get(accountNumber.getAccountNr());
        }
        return null;
    }
    @PutMapping("accounttransfer")
    public Double transferMoney(@RequestParam("account1") String accountNumber1,
                                @RequestParam("account2") String accountNumber2,
                                @RequestParam("amount") Double amount){
        if (BigDecimal.valueOf(bankAccount.get(accountNumber1)).compareTo(
                BigDecimal.valueOf(amount))>0){
            bankAccount.put(accountNumber1,
                    bankAccount.get(accountNumber1) + amount);
            bankAccount.put(accountNumber2,
                    bankAccount.get(accountNumber2) - amount);
            return bankAccount.get(accountNumber1);
        }

        return null;
    }
}
