package com.sum;

import java.util.Scanner;
/**
 * This class is responsible for creating an array of integers (dividers)
 * provided by the user via console input.
 */
public class ArrDividersCreator {

    private final Scanner scanner;
    /**
     * Constructs an ArrDividersCreator with a given Scanner for user input.
     */
    public ArrDividersCreator(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Prompts the user to input the number of dividers and then collects them to array.
     * Ensures the number of dividers is greater than 0 and no divider is zero.
     *
     * @return an array of valid, non-zero integers to be used as dividers.
     */
    public int[] createArr() {

        int divNums = 0;
        while (divNums <= 0) {
            System.out.println("The number of dividers must be greater than zero");
            System.out.print("The number of dividers: ");
            divNums = scanner.nextInt();
        }

        int[] resultArr = new int[divNums];
        fillArray(resultArr);

        return resultArr;
    }
    /**
     * Fills the provided array with user-input values.
     * Ensures that none of the entered dividers is zero.
     */
    private void fillArray(int[] divs) {

        for (int i = 0; i < divs.length; i++) {
            System.out.print("Type the " + (i + 1) + " divider: ");

            int numb = scanner.nextInt();

            if (numb == 0) {
                System.out.println("¡ERROR!");
                System.out.println("You can't divide by zero");
                System.out.println("Please, type not zero number");
                i--;
                continue;
            }
            divs[i] = numb;
        }
    }
}