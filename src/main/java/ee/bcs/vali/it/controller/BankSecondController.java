package ee.bcs.vali.it.controller;

import ee.bcs.vali.it.Account;
import ee.bcs.vali.it.Account2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class BankSecondController {

    @Autowired
    private AccountService accountService;

    @GetMapping("transfer")
    public void transfer(@RequestBody Account2 request) {
        accountService.transferMoney(request.getFromAccount(),
                request.getToAccount(),
                request.getAmount());
    }
    @GetMapping("withraw")
    public void withrawAccount(@RequestBody Account2 request){
        accountService.withrawMoney(request.getFromAccount(),
                request.getAmount());
    }
    @GetMapping("depoaccount")
    public void depositAccount(@RequestBody Account2 request){
        accountService.depositMoney(request.getFromAccount(),
                request.getAmount());
    }
    @GetMapping("getaccount")
    public BigDecimal getAccount(@RequestBody Account2 request){
        return accountService.getAccountMoney(request.getFromAccount());
    }
    @PostMapping("addaccount")
    public void addaccount(@RequestBody Account2 request){
        accountService.addAccount(request.getFromAccount(),
                request.getAmount());
    }
}
