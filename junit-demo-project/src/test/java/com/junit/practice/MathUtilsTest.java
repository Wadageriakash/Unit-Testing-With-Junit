package com.junit.practice;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    private final MathUtils mathUtils = new MathUtils();

    @Test
    void testSafeAdd() {
        assertEquals(15, mathUtils.safeAdd(7, 8));
    }

    @Test
    void testSafeMultiply() {
        assertEquals(20, mathUtils.safeMultiply(4, 5));
    }
}
