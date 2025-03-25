package money_problem.domain;

import org.junit.jupiter.api.Test;

import static money_problem.domain.Currency.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BankTest {

    @Test
    void convertEurToUsdReturnsDouble() throws MissingExchangeRateException {
        assertThat(Bank.withExchangeRate(EUR, USD, 1.2).convert(10, EUR, USD))
                .isEqualTo(12);
    }

    @Test
    void convertEurToEurReturnsSameValue() throws MissingExchangeRateException {
        assertThat(Bank.withExchangeRate(EUR, USD, 1.2).convert(10, EUR, EUR))
                .isEqualTo(10);
    }

    @Test
    void convertThrowsExceptionOnMissingExchangeRate() {
        assertThatThrownBy(() -> Bank.withExchangeRate(EUR, USD, 1.2).convert(10, EUR, KRW))
                .isInstanceOf(MissingExchangeRateException.class)
                .hasMessage("EUR->KRW");
    }

    @Test
    void convertWithDifferentExchangeRatesReturnsDifferentFloats() throws MissingExchangeRateException {
        assertThat(Bank.withExchangeRate(EUR, USD, 1.2).convert(10, EUR, USD))
                .isEqualTo(12);

        assertThat(Bank.withExchangeRate(EUR, USD, 1.3).convert(10, EUR, USD))
                .isEqualTo(13);
    }
}