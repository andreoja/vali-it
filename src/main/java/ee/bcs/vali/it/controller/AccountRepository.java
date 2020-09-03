package ee.bcs.vali.it.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AccountRepository {

    @Autowired
    private NamedParameterJdbcTemplate bankDatabase;

    public BigDecimal getBalance(String fromAccount) {
        String sql = "SELECT balance FROM account WHERE account_nr = :accountNumber";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("accountNumber", fromAccount);
        return bankDatabase.queryForObject(sql, paramMap, BigDecimal.class);
    }
    public void updateBalance(String account, BigDecimal balance) {
        String sql = "UPDATE account SET balance = :balance WHERE account_nr = :accountNumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("balance", balance);
        paramMap.put("accountNumber", account);
        bankDatabase.update(sql, paramMap);
    }
    public void addAccount(String fromAccount, BigDecimal balance){
        String sql = "INSERT INTO account (account_nr,balance) VALUES ( :accountNumber, :balance)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNumber", fromAccount);
        paramMap.put("balance", balance);
        bankDatabase.update(sql, paramMap);
    }
}
