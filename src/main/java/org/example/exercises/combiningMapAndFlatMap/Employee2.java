package org.example.exercises.combiningMapAndFlatMap;

import java.util.Optional;

public class Employee2 {
    
    private final Optional<String> phoneNumber;

    public Employee2(Optional<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Optional<String> getPhoneNumber() {
        return phoneNumber;
    }
}
