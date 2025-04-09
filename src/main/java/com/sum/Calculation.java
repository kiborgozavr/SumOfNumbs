package com.sum;

import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 * This class provides logic to scan an upper limit from the user
 * and calculate the sum of natural numbers divisible by a set of dividers.
 */
public class Calculation {

    private final Scanner scanner;

    /**
     * Constructs a Calculation instance with a given Scanner for user input.
     */
    public Calculation(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Prompts the user to input the upper limit of natural numbers.
     * Ensures the limit is greater than zero.
     *
     * @return a positive integer representing the exclusive upper limit.
     */
    public int scanUpLimit() {
        int upLimit = 0;

        while (upLimit <= 0) {
            System.out.println("The upper limit must be greater than zero");
            System.out.print("Type the upper limit: ");
            upLimit = scanner.nextInt();
        }
        return upLimit;
    }

    /**
     * Calculates the sum of all natural numbers less than the given upper limit
     * that are divisible by at least one of the provided dividers.
     *
     * @return the sum of numbers divisible by any of the dividers.
     */
    public int calcSum(int upLimit, int[] divs) {
        return IntStream.range(1, upLimit)
                .filter(divPredicate(divs))
                .distinct()
                .sum();
    }

    /**
     * Creates a predicate that checks if a number is divisible
     * by any value in the provided dividers array.
     *
     * @return a predicate that tests divisibility.
     */
    private IntPredicate divPredicate(int[] divs) {
        return n -> {
            for (int m : divs) {
                if (n % m == 0) {
                    return true;
                }
            }
            return false;
        };
    }
}