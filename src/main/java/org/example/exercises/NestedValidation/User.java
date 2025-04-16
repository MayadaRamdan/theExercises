package org.example.exercises.NestedValidation;

import java.util.Optional;

public class User {
    private Profile profile;

    public User(Profile profile) {
        this.profile = profile;
    }

    public Optional<Profile> getProfile() {
        return Optional.ofNullable(profile);
    }

    public Email getEmailOrThrow() throws EmailNotValidException {

        return getProfile()
                .flatMap(Profile::getEmail)
                .filter(email -> email.getAddress().get().contains("@"))
                .orElseThrow(() -> new EmailNotValidException("Invalid Email: Missing '@'"));


    }

}
