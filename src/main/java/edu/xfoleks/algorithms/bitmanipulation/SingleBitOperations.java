package edu.xfoleks.algorithms.bitmanipulation;

import java.util.Scanner;

/**
 * This class contains the basic operations with bits.
 */

public class SingleBitOperations {
    public static int flipBit(final int number, final int bit) {
        return number ^ (1 << bit);
    }

    public static int setBit(final int number, final int bit) {
        return number | (1 << bit);
    }

    public static int clearBit(final int number, final int bit) {
        return number & ~(1 << bit);
    }

    public static int getBit(final int number, final int bit) {
        return ((number >> bit) & 1);
    }

    public static void main(String[] args) {
        System.out.println("Enter any number: ");

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int bitNumber = 2;
        int setBitNumber = 3;
        int flippedValue = flipBit(number, bitNumber);
        int setUpValue = setBit(number, setBitNumber);
        int clearedValue = clearBit(number, bitNumber);
        int bitValue = getBit(number, bitNumber);

        System.out.printf(
                "The entered number - %d\nThe number as bit sequence - %s\nAfter flip - %s\n",
                number,
                Integer.toBinaryString(number),
                Integer.toBinaryString(flippedValue)
        );
        System.out.printf(
                "The entered number - %d\nThe number as bit sequence - %s\nAfter setting - %s\n",
                number,
                Integer.toBinaryString(number),
                Integer.toBinaryString(setUpValue)
        );
        System.out.printf(
                "The entered number - %d\nThe number as bit sequence - %s\nAfter clearing - %s\n",
                number,
                Integer.toBinaryString(number),
                Integer.toBinaryString(clearedValue)
        );
        System.out.printf(
                "The entered number - %d\nThe number as bit sequence - %s\nValue of getting bit - %s\n",
                number,
                Integer.toBinaryString(number),
                Integer.toBinaryString(bitValue)
        );
    }
}
