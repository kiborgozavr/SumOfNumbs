package com.sum;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ArrDividersCreatorTest {

    @Test
    void testCreateArrValidInput() {
        Scanner mockScanner = mock(Scanner.class);

        when(mockScanner.nextInt())
                .thenReturn(3)   // array size
                .thenReturn(2)  // first divider
                .thenReturn(3)  // second
                .thenReturn(5); // third

        ArrDividersCreator creator = new ArrDividersCreator(mockScanner);
        int[] expected = {2, 3, 5};

        assertArrayEquals(expected, creator.createArr());
    }

    @Test
    void testZeroDividerIsRejected() {
        Scanner mockScanner = mock(Scanner.class);

        when(mockScanner.nextInt())
                .thenReturn(2)   // array size
                .thenReturn(0)   // invalid divider
                .thenReturn(3)   // retry
                .thenReturn(4);  // second valid divider

        ArrDividersCreator creator = new ArrDividersCreator(mockScanner);
        int[] expected = {3, 4};

        assertArrayEquals(expected, creator.createArr());
    }

    @Test
    void testZeroArrSizeIsRejected() {
        Scanner mockScanner = mock(Scanner.class);

        when(mockScanner.nextInt())
                .thenReturn(0)  // invalid size
                .thenReturn(0)  // invalid size
                .thenReturn(2)   // retry - first valid divider
                .thenReturn(3)   // first valid divider
                .thenReturn(4);  // second valid divider

        ArrDividersCreator creator = new ArrDividersCreator(mockScanner);
        int[] expected = {3, 4};

        assertArrayEquals(expected, creator.createArr());
    }

    @Test
    void testZeroArrSizeAndZeroDividerIsRejected() {
        Scanner mockScanner = mock(Scanner.class);

        when(mockScanner.nextInt())
                .thenReturn(0)  // invalid size
                .thenReturn(2)   // valid size
                .thenReturn(3)   // first valid divider
                .thenReturn(0)  // second invalid divider
                .thenReturn(0) // second invalid divider
                .thenReturn(4);  // second valid divider


        ArrDividersCreator creator = new ArrDividersCreator(mockScanner);
        int[] expected = {3, 4};

        assertArrayEquals(expected, creator.createArr());
    }
}
