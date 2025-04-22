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
    @DisplayName("This should convert euros to dollars with different exchange rates")
    void convertWithDifferentExchangeRatesReturnsDifferentFloats() throws MissingExchangeRateException {
        Bank bank = Bank.withExchangeRate(EUR, USD, 1.2);
        double result = bank.convert(10, EUR, USD);
        assertThat(result).isEqualTo(12);

        bank = Bank.withExchangeRate(EUR, USD, 1.3);
        result = bank.convert(10, EUR, USD);
        assertThat(result).isEqualTo(13);
    }
}