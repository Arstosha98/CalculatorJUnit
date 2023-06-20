package com.example.calculator.service;

import com.example.calculator.exceptions.DivisionByZeroException;
import com.example.calculator.service.impl.CalculatorServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceTest {

    CalculatorService calc = new CalculatorServiceImpl();

    @Test
    void sumPositive(){
        assertEquals(10, calc.plus(3,7));
    }
    @Test
    void sumNegative(){
        assertEquals(-10, calc.plus(-3,-7));
    }
    @Test
    void sumSymmetry(){
        assertEquals(calc.plus(11,6), calc.plus(6,11));
    }
    @Test
    void minusPositive(){
        assertEquals(4, calc.minus(7,3));
    }
    @Test
    void minusNegative(){
        assertEquals(-4, calc.minus(-7,-3));
    }
    @Test
    void minusNotSymmetry(){
        assertNotEquals(calc.minus(11,6), calc.minus(6,11));
    }
    @Test
    void multiplyPositive(){
        assertEquals(21, calc.multiply(7,3));
    }
    @Test
    void multiplyNegative(){
        assertEquals(21, calc.multiply(-7,-3));
    }
    @Test
    void multiplySymmetry(){
        assertEquals(calc.multiply(11,6), calc.multiply(6,11));
    }
    @Test
    void dividePositive() throws Exception{
        assertEquals(7, calc.divide(21,3));
    }
    @Test
    void divideNegative() throws Exception{
        assertEquals(5, calc.divide(-10,-2));
    }
    @Test
    void divisionByZero(){
        assertThrows(DivisionByZeroException.class, ()-> {calc.divide(10,0);});
    }
}