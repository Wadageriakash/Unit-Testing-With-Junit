package com.junit.practice;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegrationTest {

    @Test
    void testCalculatorIntegration() {
        MathUtils mathUtils = new MathUtils();
        CalculatorService calculator = new CalculatorService(mathUtils);

        int sum = calculator.add(5, 5);
        int product = calculator.multiply(3, 4);
        int difference = calculator.subtract(10, 3);
        int quotient = calculator.divide(20, 5);

        assertAll(
                () -> assertEquals(10, sum),
                () -> assertEquals(12, product),
                () -> assertEquals(7, difference),
                () -> assertEquals(4, quotient)
        );
    }
}
