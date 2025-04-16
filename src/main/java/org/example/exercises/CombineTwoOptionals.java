package org.example.exercises;

import java.util.Optional;

public class CombineTwoOptionals {

    public static Optional<Integer> sumOptionals(Optional<Integer> a, Optional<Integer> b) {

        if (a.isPresent() && b.isPresent()) {
            return Optional.of(a.get() + b.get());
        } else {
            return Optional.empty();
        }    }
}
