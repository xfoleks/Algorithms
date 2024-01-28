package edu.xfoleks.algorithms.bitmanipulation;

import java.util.Scanner;

/**
 * This class is an implementation of the bit swap operation.
 * The main idea of it - swapping the bits at the one position and another from data
 */

public class BitSwapOperation {

    private BitSwapOperation(){}

    public static int bitSwap(int data, final int positionOne, int positionTwo) {
        if (SingleBitOperations.getBit(data, positionOne) != SingleBitOperations.getBit(data, positionTwo)) {
            data ^= (1 << positionOne) ^ (1 << positionTwo);
        }
        return data;
    }

    public static void main(String[] args) {
        System.out.println("Enter any number: ");

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int positionOne = 1;
        int positionTwo = 3;

        System.out.printf("Before swap - %s\n", Integer.toBinaryString(number));
        System.out.printf("After swap - %s\n", Integer.toBinaryString(bitSwap(number, positionOne, positionTwo)));
    }
}
