package edu.xfoleks.algorithms.bitmanipulation;

import java.util.Scanner;

/**
 * This class contain the algorithm of checking than given number is power of two or not.
 */

public class PowerOfTwoChecker {
    public static boolean isPowerOfTwo(int number) {
        if (number <= 0) {
            return false;
        }
        int answer = number & (number - 1);
        return answer == 0;
    }

    public static void main(String[] args) {

        System.out.println("Enter any integer number: ");

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        if (!isPowerOfTwo(number)) {
            System.out.println("The given number isn't the power of two");
        } else {
            System.out.println("The given number is the power of two");
        }
    }
}
