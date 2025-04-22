package money_problem.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static money_problem.domain.Currency.*;
import static org.assertj.core.api.Assertions.assertThat;

class MoneyCalculatorTest {
    @Test
    @DisplayName("Should add in dollars")
    void shouldAddInUsd() {
        double res = MoneyCalculator.add(5, USD, 10);
        assertThat(res).isEqualTo(15);
    }

    @Test
    @DisplayName("Should multiply in euros")
    void shouldMultiplyInEuros() {
        double res = MoneyCalculator.times(10, EUR, 2);
        assertThat(res).isEqualTo(20);
    }

    @Test
    @DisplayName("Should divide in korean wons")
    void shouldDivideInKoreanWons() {
        double res = MoneyCalculator.divide(4002, KRW, 4);
        assertThat(res).isEqualTo(1000.5);
    }
}