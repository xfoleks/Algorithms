package edu.xfoleks.algorithms.bitmanipulation;

/**
 * This class contains the algorithm of finding non-repeating number
 */
public class NonRepeatingNumberFinder {

    public static int findNonRepeatingNumber(int[] arr) {
        int result = 0;
        for (int number : arr) {
            result ^= number;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 1, 1, 2, 2, 3};

        System.out.printf("The non-repeating number is: %d", findNonRepeatingNumber(array));
    }
}
