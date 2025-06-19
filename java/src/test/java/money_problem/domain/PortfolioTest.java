package money_problem.domain;

import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BankBuilder{
    
    private HashMap<Currency, Double> exchangeRates = new HashMap<Currency, Double>();
    private Currency currency;
    
    BankBuilder(Currency currency){
        this.currency = currency;
    }
    
    static BankBuilder aBank(){
        return new BankBuilder(Currency.EUR);
    }
    
    public BankBuilder withPivotCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }
    
    public BankBuilder withExchangeRate(Double rate,Currency currency){
        this.exchangeRates.put(currency,rate);
        return this;
    }
    
    public Bank build(){
        return Bank.withExchangeRate(this.currency, (Currency) this.exchangeRates.keySet().toArray()[0], 0);
    }
}

class PortfolioTest {

    BankBuilder bankBuilder = BankBuilder.aBank();

    @Test
    @DisplayName("This should evaluate an empty portfolio")
    public void emptyPortfolio() throws MissingExchangeRateException{
        
        // ARRANGE
        Portfolio portfolio = new Portfolio();
        Bank bank = bankBuilder.withPivotCurrency(Currency.EUR)
                .withExchangeRate(1.2, Currency.USD)
                .build();
        
        // ACT
        double res = portfolio.evaluate(bank, Currency.USD);
        
        // ASSERT
        assertEquals(res, 0);
        
    }
    
    @Test
    @DisplayName("This should evaluate an multi currency portfolio")
    public void multiCurrencyPortfolioUSD() throws MissingExchangeRateException{
        
        // ARRANGE
        Portfolio portfolio = new Portfolio();
        Bank bank = bankBuilder.withPivotCurrency(Currency.USD)
                .withExchangeRate(1.2, Currency.EUR)
                .build();
        Money moneyUSD = new Money(5, Currency.USD);
        Money moneyEUR = new Money(10, Currency.EUR);
        
        // ACT
        portfolio.add(moneyUSD);
        portfolio.add(moneyEUR);
        double res = portfolio.evaluate(bank, Currency.USD);
        
        // ASSERT
        assertEquals(res, 17);
        
    }
    
    @Test
    @DisplayName("This should evaluate an multi currency portfolio")
    public void multiCurrencyPortfolioEUR() throws MissingExchangeRateException{
        
        // ARRANGE
        Portfolio portfolio = new Portfolio();
        Bank bank = bankBuilder.withPivotCurrency(Currency.EUR)
                .withExchangeRate(0.8, Currency.USD)
                .build();
        Money moneyUSD = new Money(5, Currency.USD);
        Money moneyEUR = new Money(10, Currency.EUR);
        
        // ACT
        portfolio.add(moneyUSD);
        portfolio.add(moneyEUR);
        double res = portfolio.evaluate(bank, Currency.EUR);
        
        // ASSERT
        assertEquals(res, 14);
        
    }
    
    @Test
    @DisplayName("This should add in portfolio")
    public void addPortfolio() throws MissingExchangeRateException{
        
        // ARRANGE
        Portfolio portfolio = new Portfolio();
        Bank bank = bankBuilder.withPivotCurrency(Currency.EUR)
                .withExchangeRate(1.2, Currency.USD)
                .build();
        double value = 5;
        Money monaie = new Money(value, Currency.USD);
        
        // ACT
        portfolio.add(monaie);
        
        // ASSERT
        assertEquals(portfolio.evaluate(bank, Currency.USD), 5);
        
    }
    
}