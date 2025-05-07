import java.util.Objects;

public class BankAccount {
    // Attributes
    private int accountNumber;
    private int bankCode;
    private String accountHolder;
    private String accountType;
    private double interestRate;
    private double balance;

    // Constructor
    public BankAccount(int accountNumber, int bankCode, String accountHolder, String accountType, double interestRate, double balance) {
        this.accountNumber = accountNumber;
        this.bankCode = bankCode;
        this.accountHolder = accountHolder;
        this.accountType = accountType;
        this.interestRate = interestRate;
        this.balance = balance;
    }

    // Getter Setter
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBankCode() {
        return bankCode;
    }

    public void setBankCode(int bankCode) {
        this.bankCode = bankCode;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Methods
    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber=" + accountNumber +
                ", bankCode=" + bankCode +
                ", accountHolder='" + accountHolder + '\'' +
                ", accountType='" + accountType + '\'' +
                ", interestRate=" + interestRate +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return accountNumber == that.accountNumber && bankCode == that.bankCode && Double.compare(interestRate, that.interestRate) == 0 && Double.compare(balance, that.balance) == 0 && Objects.equals(accountHolder, that.accountHolder) && Objects.equals(accountType, that.accountType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, bankCode, accountHolder, accountType, interestRate, balance);
    }
}
