package org.example.exercises.NestedValidation;

import java.util.Optional;

public class Email {

    private String address;

    public Email(String address) {
        this.address = address;
    }

    public Optional<String> getAddress() {
        return Optional.ofNullable(address);
    }

    public boolean isValid() {
        return address != null && address.contains("@");
    }
}
