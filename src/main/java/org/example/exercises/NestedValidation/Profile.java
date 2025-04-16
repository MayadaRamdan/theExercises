package org.example.exercises.NestedValidation;

import java.util.Optional;

public class Profile {
    private Email email;

    public Profile(Email email) {
        this.email = email;
    }

    public Optional<Email> getEmail() {
        return Optional.ofNullable(email);
    }
}
