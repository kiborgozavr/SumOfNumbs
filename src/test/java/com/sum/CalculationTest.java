package com.sum;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Scanner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculationTest {

    @Test
    void testScanUpLimitValid() {
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextInt())
                .thenReturn(-5) // invalid upLimit
                .thenReturn(0) // invalid upLimit
                .thenReturn(10); // valid upLimit

        Calculation calc = new Calculation(mockScanner);
        int result = calc.scanUpLimit();

        assertEquals(10, result);
    }

    @ParameterizedTest
    @MethodSource("provideCalcSumCases")
    void testCalcSumWithVariousDivs(int upLimit, int[] divs, int expectedSum) {
        Calculation calc = new Calculation(null); // Scanner not used here
        int result = calc.calcSum(upLimit, divs);
        assertEquals(expectedSum, result);
    }

    private static Stream<org.junit.jupiter.params.provider.Arguments> provideCalcSumCases() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(10, new int[]{2, 3}, 32),  // 2,3,4,6,8,9
                org.junit.jupiter.params.provider.Arguments.of(15, new int[]{5}, 15),     // 5,10
                org.junit.jupiter.params.provider.Arguments.of(20, new int[]{4, 6}, 64),  // 4,6,8,12,16,18
                org.junit.jupiter.params.provider.Arguments.of(5, new int[]{7}, 0),       // no matches
                org.junit.jupiter.params.provider.Arguments.of(1, new int[]{1}, 0)        // 1 is not in range(1, 1)
        );
    }

    @Test
    void testCalcSumWithNoDivsMatch() {
        Calculation calc = new Calculation(null);

        int result = calc.calcSum(10, new int[]{11, 12}); // No numbers match
        assertEquals(0, result);
    }
}
