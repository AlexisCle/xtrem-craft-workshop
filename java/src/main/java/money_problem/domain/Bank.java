package money_problem.domain;

import java.util.HashMap;
import java.util.Map;

public final class Bank {
    private final Map<String, Double> exchangeRates;
    private final Currency pivotCurrency;

    private Bank(Map<String, Double> exchangeRates, Currency pivotCurrency) {
        this.exchangeRates = exchangeRates;
        this.pivotCurrency = pivotCurrency;
    }

    public static Bank withExchangeRate(Currency source, Currency target, double rate, Currency pivotCurrency) {
        var bank = new Bank(new HashMap<>(), pivotCurrency);
        bank.addExchangeRate(source, target, rate);

        return bank;
    }

    public static Bank withExchangeRate(Currency source, Currency target, double rate) {
        var bank = new Bank(new HashMap<>(), source);
        bank.addExchangeRate(source, target, rate);
        return bank;
    }

    public void addExchangeRate(Currency source, Currency target, double rate) {
        exchangeRates.put(source + "->" + target, rate);
    }
    
    public boolean canConvert(Currency source, Currency target){
        if(source == target || exchangeRates.containsKey(source + "->" + target)){
            return true;
        }
        return false;
    }

    public double convert(double amount, Currency source, Currency target) throws MissingExchangeRateException {
        Money money = new Money(amount, source);
        Money targetMoney = new Money(0, target);
        if (!canConvert(money.getCurrency(), targetMoney.getCurrency())) {
            throw new MissingExchangeRateException(money.getCurrency(), targetMoney.getCurrency());
        }
        return money.getCurrency() == targetMoney.getCurrency()
                ? money.getAmount()
                : money.MultiplyBy(exchangeRates.get(money.getCurrency() + "->" + target));
    }

}