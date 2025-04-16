package org.example.exercises;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FibonacciStream {
    public static List<Integer> generateFibonacci(int n) {
        return Stream.iterate(new int[]{0, 1}, pair -> new int[]{pair[1], pair[0] + pair[1]})
                .limit(n)
                .map(pair -> pair[0])
                .collect(Collectors.toList());
    }
}
