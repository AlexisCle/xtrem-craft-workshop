package money_problem.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {
    @Test
    @DisplayName("This should test adding two money objects with the same currency")
    void testAddWithSameCurrency() {
        // Given
        Money money1 = new Money(10, Currency.EUR);
        Money money2 = new Money(5, Currency.EUR);

        // When
        double result = money1.Add(money2);

        // Then
        assert result == 15 : "Expected 15 but got " + result;
    }

    @Test
    @DisplayName("This should test dividing money by a number")
    void testDivideBy() {
        // Given
        Money money = new Money(10, Currency.EUR);

        // When
        double result = money.DivideBy(2.0);

        // Then
        assert result == 5 : "Expected 5 but got " + result;
    }

    @Test
    @DisplayName("This should test multiplying money by a number")
    void testMultiplyBy() {
        // Given
        Money money = new Money(10, Currency.EUR);

        // When
        double result = money.MultiplyBy(2.0);

        // Then
        assert result == 20 : "Expected 20 but got " + result;
    }

    @Test
    @DisplayName("This should test adding money with different currencies throws an exception")
    void testAddWithDifferentCurrenciesThrowsException() {
        // Given
        Money money1 = new Money(10, Currency.EUR);
        Money money2 = new Money(5, Currency.USD);

        // When & Then
        try {
            money1.Add(money2);
            assert false : "Expected IllegalArgumentException but none was thrown";
        } catch (IllegalArgumentException e) {
            assert e.getMessage().equals("Cannot add money with different currencies") : "Unexpected exception message: " + e.getMessage();
        }
    }

    @Test
    @DisplayName("This should test multiplying money with different currencies throws an exception")
    void testMultiplyByWithNullThrowsException() {
        // Given
        Money money = new Money(10, Currency.EUR);

        // When & Then
        try {
            money.MultiplyBy(null);
            assert false : "Expected IllegalArgumentException but none was thrown";
        } catch (IllegalArgumentException e) {
            assert e.getMessage().equals("Multiplier cannot be null") : "Unexpected exception message: " + e.getMessage();
        }
    }

    @Test
    @DisplayName("This should test dividing money by zero throws an exception")
    void testDivideByZeroThrowsException() {
        // Given
        Money money = new Money(10, Currency.EUR);

        // When & Then
        try {
            money.DivideBy(0.0);
            assert false : "Expected IllegalArgumentException but none was thrown";
        } catch (IllegalArgumentException e) {
            assert e.getMessage().equals("Divider cannot be null or zero") : "Unexpected exception message: " + e.getMessage();
        }
    }
}
