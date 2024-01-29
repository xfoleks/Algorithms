package edu.xfoleks.algorithms.bitmanipulation;

import java.util.Scanner;

/**
 * This class contains the algorithm for finding the index of rightmost set bit
 */
public class IndexOfRightMostSetBit {
    private static int getIndexOfRightMostSetBit(int number) {
        if (number == 0) {
            return -1;
        }

        // Handle negative numbers by finding the two's complement

        if (number < 0) {
            number = -number;

            // Get the rightmost set bit in positive form
            number = number & (~number + 1);
        }

        int index = 0;
        while ((number & 1) == 0) {
            number = number >> 1;
            index++;
        }

        return index;
    }

    public static void main(String[] args) {
        System.out.println("Enter any number: ");

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        int indexOfRightmostSetBit = getIndexOfRightMostSetBit(number);

        System.out.printf("The entered number in binary code: %s\n", Integer.toBinaryString(number));
        System.out.printf("The rightmost bit is: %d", indexOfRightmostSetBit);
    }
}
