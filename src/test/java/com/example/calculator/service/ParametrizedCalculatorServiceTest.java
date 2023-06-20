package com.example.calculator.service;

import com.example.calculator.service.impl.CalculatorServiceImpl;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParametrizedCalculatorServiceTest {
    CalculatorService calc = new CalculatorServiceImpl();

    static Stream<Arguments> data(){
        return Stream.of(
                Arguments.of(1, 2),
                Arguments.of(31, 6),
                Arguments.of(-123, 482),
                Arguments.of(23, 2929),
                Arguments.of(1223,-101)
        );
    }
    @ParameterizedTest
    @MethodSource("data")
    void plus(int num1, int num2){
        int expected = num1 + num2;
        int actual = calc.plus(num1,num2);
        assertEquals(expected, actual);
    }
    @ParameterizedTest
    @MethodSource("data")
    void minus(int num1, int num2){
        int expected = num1 - num2;
        int actual = calc.minus(num1,num2);
        assertEquals(expected, actual);
    }
    @ParameterizedTest
    @MethodSource("data")
    void multiply(int num1, int num2){
        int expected = num1 * num2;
        int actual = calc.multiply(num1,num2);
        assertEquals(expected, actual);
    }
    @ParameterizedTest
    @MethodSource("data")
    void divide(int num1, int num2){
        int expected = num1 / num2;
        int actual = calc.divide(num1,num2);
        assertEquals(expected, actual);
    }
}