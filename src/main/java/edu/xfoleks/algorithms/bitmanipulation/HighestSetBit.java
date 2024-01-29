package edu.xfoleks.algorithms.bitmanipulation;

import java.util.Optional;
import java.util.Scanner;

/**
 * This class contains an algorithm for the calculation of the position (or index)
 * of the most significant bit being set to 1 in a given integer.
 */
public class HighestSetBit {

    private HighestSetBit() {

    }

    public static Optional<Integer> findHighestSetBit(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Input can't be a negative value!");
        }

        if (number == 0) {
            return Optional.empty();
        }

        int position = 0;
        while (number > 0) {
            number >>= 1;
            position++;
        }

        return Optional.of(position - 1);
    }

    public static void main(String[] args) {
        System.out.println("Enter any number: ");

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        Optional<Integer> result = findHighestSetBit(number);
        int value = 0;
        if (result.isPresent()) {
            value = result.get();
        }
        System.out.println(Integer.toBinaryString(number));
        System.out.printf("The highest set bit is: %d", value);
    }
}
