package org.example.exercises;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MovingAverage {

    public static List<Double> movingAverage(List<Integer> numbers, int windowSize) {

        if (numbers.size() < windowSize || windowSize <= 0) {
            throw new IllegalArgumentException("Invalid window size");
        }

       return IntStream.range(0, numbers.size() - windowSize + 1)
               .mapToObj(i -> numbers.subList(i, i + windowSize))
               .map(subList -> subList.stream().mapToInt(Integer::intValue).average())
               .filter(OptionalDouble::isPresent)
               .map(OptionalDouble::getAsDouble)
               .collect(Collectors.toList());


    }


}
