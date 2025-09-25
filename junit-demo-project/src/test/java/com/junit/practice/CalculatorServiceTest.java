package com.junit.practice;



import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CalculatorServiceTest {

    private CalculatorService calculator;
    private MathUtils mathUtils;

    @BeforeAll
    static void setupAll() {
        System.out.println("=== Starting CalculatorService Tests ===");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("=== Finished CalculatorService Tests ===");
    }

    @BeforeEach
    void init() {
        mathUtils = Mockito.mock(MathUtils.class);
        calculator = new CalculatorService(mathUtils);
    }

    @AfterEach
    void cleanup() {
        System.out.println("Test completed");
    }

    @Test
    @DisplayName("Addition should work using mocked MathUtils")
    void testAddition() {
        when(mathUtils.safeAdd(10, 20)).thenReturn(30);

        int result = calculator.add(10, 20);

        assertEquals(30, result);
        verify(mathUtils).safeAdd(10, 20);
    }

    @Test
    @DisplayName("Division by zero should throw CustomException")
    void testDivisionByZero() {
        assertThrows(CustomException.class, () -> calculator.divide(10, 0));
    }

    @Test
    @Disabled("Feature not ready yet")
    void testDisabledFeature() {
        fail("This test is disabled");
    }

    @Test
    @DisplayName("Test multiple conditions with assertAll")
    void testMultipleAssertions() {
        when(mathUtils.safeAdd(5, 5)).thenReturn(10);
        when(mathUtils.safeMultiply(2, 3)).thenReturn(6);

        assertAll(
                () -> assertEquals(10, calculator.add(5, 5)),
                () -> assertEquals(6, calculator.multiply(2, 3)),
                () -> assertNotEquals(0, calculator.subtract(7, 3))
        );
    }
}
