package money_problem.domain;

import java.util.HashSet;

/**
 *
 * @author depinfo
 */
class Portfolio {

    private HashSet<Money> total;

    Portfolio() {
        this.total = new HashSet<>();
    }

    double evaluate(Bank bank, Currency currency) throws MissingExchangeRateException {
        double total = 0;
        for (Money money : this.total) {
            total += bank.convert(money.getAmount(), money.getCurrency(), currency);
        }
        return total;
    }

    void add(Money money) {
        this.total.add(money);
    }

}
