package org.example.exercises;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FindSecondLargestNumber {

    public static Optional<Integer> theSecondLargest(List<Integer> l){
        return l.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();
    }
}
