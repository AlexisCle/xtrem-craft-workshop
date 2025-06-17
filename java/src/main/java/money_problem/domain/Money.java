package money_problem.domain;

public class Money {

    private final double amount;
    private final Currency currency;

    public Money(double amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public double MultiplyBy(Double double1) {
        if (double1 == null) {
            throw new IllegalArgumentException("Multiplier cannot be null");
        }
        return amount * double1;
    }

}
