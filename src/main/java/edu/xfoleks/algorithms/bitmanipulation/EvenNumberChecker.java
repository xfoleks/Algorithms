package edu.xfoleks.algorithms.bitmanipulation;

import java.util.Scanner;

/**
 * This class contains the algorithm of checking a number if it even or not.
 */

public class EvenNumberChecker {
    public static boolean isEvenNumber(int number) {
        return (number & 1) == 0;
    }

    public static void main(String[] args) {
        System.out.println("Enter any integer number: ");

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        if (!isEvenNumber(number)) {
            System.out.println("The given number isn't the even");
        } else {
            System.out.println("The given number is the even");
        }
    }
}
