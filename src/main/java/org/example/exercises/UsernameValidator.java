package org.example.exercises;

import java.util.Optional;

public class UsernameValidator {

    public static class ValidationException extends RuntimeException {
        public ValidationException(String message) {
            super(message);
        }
    }

    public static String validateAndTransformUsername(Optional<String> username) {

        return username.filter(name -> name.length() >= 5)
                .filter(name -> name.matches("[a-zA-Z0-9]+"))
                .map(String::toLowerCase)
                .orElseThrow(() -> new ValidationException("Username is invalid"));

    }

}
