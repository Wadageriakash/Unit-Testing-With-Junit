package com.junit.practice;



public class CalculatorService {

    private final MathUtils mathUtils;

    public CalculatorService(MathUtils mathUtils) {
        this.mathUtils = mathUtils;
    }

    public int add(int a, int b) {
        return mathUtils.safeAdd(a, b);
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return mathUtils.safeMultiply(a, b);
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new CustomException("Division by zero is not allowed!");
        }
        return a / b;
    }
}
