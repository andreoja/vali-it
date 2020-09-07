package ee.bcs.vali.it;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Account2 {
    private String fromAccount;
    private String toAccount;
    private BigDecimal amount;
    private BigInteger clientId;
    private String firstName;
    private String lastName;
    private BigDecimal depo;
    private BigDecimal withraw;
    private BigDecimal transferIn;
    private BigDecimal transferOut;
    private BigInteger accountId;

    public BigInteger getAccountId() {
        return accountId;
    }

    public void setAccountId(BigInteger accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getDepo() {
        return depo;
    }

    public void setDepo(BigDecimal depo) {
        this.depo = depo;
    }

    public BigDecimal getWithraw() {
        return withraw;
    }

    public void setWithraw(BigDecimal withraw) {
        this.withraw = withraw;
    }

    public BigDecimal getTransferIn() {
        return transferIn;
    }

    public void setTransferIn(BigDecimal transferIn) {
        this.transferIn = transferIn;
    }

    public BigDecimal getTransferOut() {
        return transferOut;
    }

    public void setTransferOut(BigDecimal transferOut) {
        this.transferOut = transferOut;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
