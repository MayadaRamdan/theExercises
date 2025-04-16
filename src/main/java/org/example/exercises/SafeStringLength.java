package org.example.exercises;

import java.util.Optional;

public class SafeStringLength {


    public static int getLength(String word) {
        return Optional.ofNullable(word)
                .map(String::length).orElse(0);
    }
}
