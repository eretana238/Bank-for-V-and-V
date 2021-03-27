package models.accounts;

public class Savings extends Account {
    private int transactionLimit;
    private double interestRate;

    public Savings() {
    }

    public Savings(int transactionLimit, double interestRate) {
        this.transactionLimit = transactionLimit;
        this.interestRate = interestRate;
    }

    public Savings(int accountNumber, double accountBalance, int transactionLimit, double interestRate) {
        super(accountNumber, accountBalance);
        this.transactionLimit = transactionLimit;
        this.interestRate = interestRate;
    }

    @Override
    public boolean deposit(double amount) {
        if (super.deposit(amount)) {
            this.transactionLimit--;
            return true;
        }
        if (this.transactionLimit <= 0) {
            chargeTransactionFee();
        }
        return false;
    }

    @Override
    public boolean withdraw(double amount) {
        if (super.withdraw(amount)) {
            this.transactionLimit--;
            return true;
        }
        if (this.transactionLimit <= 0) {
            chargeTransactionFee();
        }
        return false;
    }

    @Override
    public boolean transfer(Account destination, double amount) {
        if (super.transfer(destination, amount)) {
            this.transactionLimit--;
            return true;
        }
        if (this.transactionLimit <= 0) {
            chargeTransactionFee();
        }

        return false;
    }

    public void calculateInterest() {
        double principle = super.getAccountBalance();

        double amount = principle * Math.pow(1 + (this.interestRate / 365), 365 * 1);
        this.setAccountBalance(amount);
    }

    public void chargeTransactionFee() {
        this.setAccountBalance(this.getAccountBalance() - 50);
    }

}
