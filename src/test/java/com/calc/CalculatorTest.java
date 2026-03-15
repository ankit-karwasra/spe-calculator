package com.calc;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testFactorial() {
        assertEquals(120, ScientificCalculator.factorial(5));
    }

    @Test
    public void testSqrt() {
        assertEquals(5.0, Math.sqrt(25), 0.001);
    }

    @Test
    public void testLn() {
        assertEquals(2.302, Math.log(10), 0.001);
    }

    @Test
    public void testPower() {
        assertEquals(8.0, Math.pow(2, 3), 0.001);
    }
}