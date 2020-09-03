package ee.bcs.vali.it.controller;

import ee.bcs.vali.it.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@RestController
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
        String sql = "SELECT balance FROM account WHERE account_nr=:accountNr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNr", accountNumber);
        BigDecimal vastus = bankDatabase.queryForObject(sql, paramMap, BigDecimal.class);
        return vastus;
    }
    @GetMapping("depoaccount")
    public void depositAccount(@RequestParam() String accountNumber,
                               @RequestParam() BigDecimal depositAmount) {
        String sql = "UPDATE account SET balance=balance + :addmoney WHERE account_nr=:accountNr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNr", accountNumber);
        paramMap.put("addmoney", depositAmount);
        bankDatabase.update(sql, paramMap);
    }
    @GetMapping("withraw")
    public void withrawAccount(@RequestParam() String accountNumber,
                                @RequestParam() BigDecimal amountToTransfer){
        String sql = "SELECT balance FROM account WHERE account_nr = :accountNr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNr", accountNumber);
        BigDecimal amountFromAccount = bankDatabase.queryForObject(sql, paramMap, BigDecimal.class);
        if (amountFromAccount.compareTo(amountToTransfer)>=0){
            sql = "UPDATE account SET balance = balance - :amount WHERE account_nr = :accountNr";
            Map<String, Object> paramMap1 = new HashMap<>();
            paramMap1.put("accountNr", accountNumber);
            paramMap1.put("amount", amountToTransfer);
            bankDatabase.update(sql, paramMap1);
        }
    }


    @GetMapping("transfer")
    public void transferMoneyFirst(@RequestParam()String accountFrom,
                                @RequestParam()String accountTo,
                                @RequestParam()BigDecimal amountToTransfer){
        String sql = "SELECT balance FROM account WHERE account_nr = :accountNr";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("accountNr", accountFrom);
        BigDecimal amountFromAccount = bankDatabase.queryForObject(sql, paramMap, BigDecimal.class);

        if (amountFromAccount.compareTo(amountToTransfer)>=0){
            sql = "UPDATE account SET balance = balance + :amount WHERE account_nr = :accountNr";
            Map<String, Object> paramMap1 = new HashMap<>();
            paramMap1.put("accountNr", accountTo);
            paramMap1.put("amount", amountToTransfer);
            bankDatabase.update(sql, paramMap1);
            sql = "UPDATE account SET balance = balance - :amount WHERE account_nr = :accountNrFrom";
            Map<String, Object> paramMap2 = new HashMap<>();
            paramMap2.put("accountNrFrom", accountFrom);
            paramMap2.put("amount", amountToTransfer);
            bankDatabase.update(sql, paramMap2);
        }

    }
    @GetMapping("clientlist")
    public List<Account> clientList (){
        String sql = "SELECT * FROM account";
        Map<String, Object> paramMap = new HashMap<>();
        List<Account> resultList = bankDatabase.query(sql, paramMap, new ObjectRowMapper());
        return resultList;
    }
}
