package money_problem.domain;

public class MissingExchangeRateException extends Exception {
    public MissingExchangeRateException(Currency source, Currency target) {
        super(String.format("%s->%s", source, target));
    }
}
