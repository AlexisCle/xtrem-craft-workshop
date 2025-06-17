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

    public double Add(Money money) {
        if (money == null) {
            throw new IllegalArgumentException("Money to add cannot be null");
        }
        if (!this.currency.equals(money.getCurrency())) {
            throw new IllegalArgumentException("Cannot add money with different currencies");
        }
        return amount + money.getAmount();
    }

    public double MultiplyBy(Double double1) {
        if (double1 == null) {
            throw new IllegalArgumentException("Multiplier cannot be null");
        }
        return amount * double1;
    }

    public double DivideBy(Double double1) {
        if (double1 == null || double1 == 0) {
            throw new IllegalArgumentException("Divider cannot be null or zero");
        }
        return amount / double1;
    }

}
