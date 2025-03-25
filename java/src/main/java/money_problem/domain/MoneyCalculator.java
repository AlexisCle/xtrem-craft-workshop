package money_problem.domain;

public class MoneyCalculator {
    public static double add(double amount, Currency source, double amount2) {
        return amount + amount2;
    }

    public static double times(double amount, Currency source, int value) {
        return amount * value;
    }

    public static double divide(double amount, Currency source, int value) {
        return amount / value;
    }
}