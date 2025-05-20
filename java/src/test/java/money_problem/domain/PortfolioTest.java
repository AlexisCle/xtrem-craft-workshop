package money_problem.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PortfolioTest {

    @Test
    @DisplayName("This should evaluate an empty portfolio")
    public void emptyPortfolio() throws MissingExchangeRateException{
        
        // ARRANGE
        Portfolio portfolio = new Portfolio();
        Bank bank = Bank.withExchangeRate(Currency.EUR, Currency.USD, 1.2);
        
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
        Bank bank = Bank.withExchangeRate(Currency.EUR, Currency.USD, 1.2);
        
        // ACT
        portfolio.add(5, Currency.USD);
        portfolio.add(10, Currency.EUR);
        double res = portfolio.evaluate(bank, Currency.USD);
        
        // ASSERT
        assertEquals(res, 17);
        
    }
    
    @Test
    @DisplayName("This should evaluate an multi currency portfolio")
    public void multiCurrencyPortfolioEUR() throws MissingExchangeRateException{
        
        // ARRANGE
        Portfolio portfolio = new Portfolio();
        Bank bank = Bank.withExchangeRate(Currency.USD, Currency.EUR, 0.8);
        
        // ACT
        portfolio.add(5, Currency.USD);
        portfolio.add(10, Currency.EUR);
        double res = portfolio.evaluate(bank, Currency.EUR);
        
        // ASSERT
        assertEquals(res, 14.1);
        
    }
    
    @Test
    @DisplayName("This should add in portfolio")
    public void addPortfolio() throws MissingExchangeRateException{
        
        // ARRANGE
        Portfolio portfolio = new Portfolio();
        Bank bank = Bank.withExchangeRate(Currency.EUR, Currency.USD, 1.2);
        double value = 5;
        
        // ACT
        portfolio.add(value,Currency.USD);
        
        // ASSERT
        assertEquals(portfolio.evaluate(bank, Currency.USD), 5);
        
    }
    
}