package money_problem.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static money_problem.domain.Currency.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BankTest {

    @Test
    @DisplayName("This should convert euros to dollars")
    void convertEurToUsdReturnsDouble() throws MissingExchangeRateException {
        Bank bank = Bank.withExchangeRate(EUR, USD, 1.2);
        double result = bank.convert(10, EUR, USD);
        assertThat(result).isEqualTo(12);
    }

    @Test
    @DisplayName("This should convert euros to euros and return the same value that is entered")
    void convertEurToEurReturnsSameValue() throws MissingExchangeRateException {
        Bank bank = Bank.withExchangeRate(EUR, USD, 1.2);
        double result = bank.convert(10, EUR, EUR);
        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("This should throw an missing exchange rate exception")
    void convertThrowsExceptionOnMissingExchangeRate() {
        Bank bank = Bank.withExchangeRate(EUR, USD, 1.2);
        assertThatThrownBy(() -> bank.convert(10, EUR, KRW))
                .isInstanceOf(MissingExchangeRateException.class)
                .hasMessage("EUR->KRW");
    }

    @Test
    @DisplayName("should convert to different result when exchange rate changes")
    void convertWithDifferentExchangeRatesReturnsDifferentFloats() throws MissingExchangeRateException {
        Bank bank1 = Bank.withExchangeRate(EUR, USD, 1.2);
        bank1.addExchangeRate(EUR, USD, 1.3);
        
        double result = bank1.convert(10, EUR, USD);
        assertThat(result).isEqualTo(13);
    }
}