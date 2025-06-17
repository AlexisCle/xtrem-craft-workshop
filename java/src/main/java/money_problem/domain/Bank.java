package money_problem.domain;

import java.util.HashMap;
import java.util.Map;

public final class Bank {
    private final Map<String, Double> exchangeRates;

    private Bank(Map<String, Double> exchangeRates) {
        this.exchangeRates = exchangeRates;
    }

    public static Bank withExchangeRate(Currency source, Currency target, double rate) {
        var bank = new Bank(new HashMap<>());
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
        return money.getAmount() == targetMoney.getAmount()
                ? money.getAmount()
                : money.getAmount() * exchangeRates.get(source + "->" + target);
    }

}