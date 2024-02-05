package edu.xfoleks.algorithms.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class BufferedReaderApp {

    public static void main(String[] args) throws IOException {
        String text = "Hello World!";
        int lengthOfString = text.length();
        byte[] bytes = text.getBytes(StandardCharsets.UTF_8);

        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        BufferedReader bufferedReader = new BufferedReader(inputStream);

        System.out.printf("First symbol is - %s\n", bufferedReader.read());
        lengthOfString--;
        System.out.printf("Count of the available bytes is: %d and length of string is %d\n",
                bufferedReader.getNumberOfAvailableBytes(), lengthOfString);
        System.out.printf("Second symbol is - %s\n", bufferedReader.peek(1));
        System.out.printf("Fourth symbol is - %s\n", bufferedReader.peek(3));

        System.out.printf("The block: %s", Arrays.toString(bufferedReader.readBlock()));

        bufferedReader.close();
    }
}
