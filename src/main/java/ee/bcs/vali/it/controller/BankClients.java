package ee.bcs.vali.it.controller;

import ee.bcs.vali.it.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class BankClients {

    @Autowired
    private NamedParameterJdbcTemplate bankDatabase;

    @PostMapping("createaccount")
    public void createNewAccount(@RequestBody Account accountNumber){
        String sql = "INSERT INTO account (account_nr,balance) " +
                "VALUES ( :accountNr, :balance)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNr", accountNumber.getAccountNr());
        paramMap.put("balance", accountNumber.getBalance());
        bankDatabase.update(sql, paramMap);
    }
    @GetMapping("getaccount")
    public BigDecimal getAccount(@RequestParam() String accountNumber){
        String sql = "SELECT*FROM account WHERE account_nr=:accountNr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNr", accountNumber);
        BigDecimal vastus = bankDatabase.queryForObject(sql, paramMap, BigDecimal.class);
        return vastus;
    }
    @PutMapping("depoaccount")
    public void depositAccount(@RequestBody Account accountNumber) {
        String sql = "UPDATE account SET balance=balance + :addmoney WHERE account_nr=:accountNr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNr", accountNumber.getAccountNr());
        paramMap.put("addmoney", accountNumber.getBalance());
        bankDatabase.update(sql, paramMap);
    }
}
