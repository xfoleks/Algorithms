package edu.xfoleks.algorithms.bitmanipulation;

/**
 * This class is showing how to check the difference of signs of two numbers
 */
public class NumberSignsChecker {

    public static boolean isDifferentSigns(int firstNumber, int secondNumber) {
        return (firstNumber ^ secondNumber) < 0;
    }

    public static void main(String[] args) {
        System.out.printf("The signs is different - %s\n", isDifferentSigns(1, -2));
        System.out.printf("The signs is different - %s", isDifferentSigns(2, 3));
    }
}
