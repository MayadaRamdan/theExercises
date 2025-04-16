package org.example.exercises;

import java.util.Arrays;

public class SumOfEvenNumbers {

    public static int sum(int[] myArray) {
        return Arrays.stream(myArray).filter(n -> n % 2 == 0).sum();
    }
}
