package edu.xfoleks.algorithms.bitmanipulation;

import java.util.Scanner;

/**
 * This class contains the algorithm for converting any octal number to a binary number.
 */

public class ReverseBits {
    public static int reverseBits(int number) {
        int result = 0;
        int bitCount = 32;

        for (int i = 0; i < bitCount; i++) {

            // Left shift the result to make space for the next bit
            result <<= 1;

            // OR operation to set the least significant bit of result with current bit of n
            result |= (number & 1);

            number >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Enter any octal number: ");

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        int reversedNumber = reverseBits(number);

        System.out.printf("The entered number - %d\nThe reversed value - %s", number, Integer.toBinaryString(reversedNumber));

    }
}
