package ee.bcs.vali.it.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;
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
    public void addAccount(String fromAccount, BigDecimal balance, BigInteger clientId){
        String sql = "INSERT INTO account (account_nr,balance, client_id) " +
                "VALUES ( :accountNumber, :balance, :clientId)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNumber", fromAccount);
        paramMap.put("balance", balance);
        paramMap.put("clientId", clientId);
        bankDatabase.update(sql, paramMap);
    }
    public BigInteger addClient(String firstName, String lastName, BigInteger clientId) {
        String sql = "INSERT INTO client (first_name, last_name) " +
                "VALUES (:firstName, :lastName)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("firstName", firstName);
        paramMap.put("lastName", lastName);
        bankDatabase.update(sql, paramMap);
        sql = "SELECT MAX(id) FROM client";
        Map<String, Object> paramMap1 = new HashMap<>();
        paramMap1.put("clientId", clientId);
        return bankDatabase.queryForObject(sql, paramMap1, BigInteger.class);
    }

    public BigInteger getAccountId (String fromAccount){
        String sql = "SELECT id FROM account WHERE account_nr = :accountNumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNumber", fromAccount);
        return bankDatabase.queryForObject(sql, paramMap, BigInteger.class);
    }

    public void updateHistoryWithraw(BigInteger accountId, BigDecimal withraw){
        String sql = "INSERT INTO history (account_id,withraw) VALUES (:accountId, :withraw)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountId", accountId);
        paramMap.put("withraw", withraw);
        bankDatabase.update(sql, paramMap);
    }
    public void updateHistoryDepo(BigInteger accountId, BigDecimal depo) {
        String sql = "INSERT INTO history (account_id, depo) VALUES (:accountId, :depo)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountId", accountId);
        paramMap.put("depo", depo);
        bankDatabase.update(sql, paramMap);
    }
}
