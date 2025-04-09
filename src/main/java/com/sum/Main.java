package com.sum;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("It's app for calculation the sum of natural numbers divisible by a user-defined set of dividers.");
        System.out.println("Type the upper limit of natural numbers");

        Calculation calculation = new Calculation(scanner);
        int upLimit = calculation.scanUpLimit();

        System.out.println("How many numbers do you want to divide by?");
        ArrDividersCreator creator = new ArrDividersCreator(scanner);
        int[] divs = creator.createArr();

        int result = calculation.calcSum(upLimit, divs);

        System.out.printf("The sum of numbers is %d \n", result);

        System.out.println("Type Enter for exit...");
        new java.util.Scanner(System.in).nextLine();
    }
}