package org.example.exercises.chainOfMethods;

import java.util.Optional;

public class Address {

    private final City city;

    public Address(City city) {
        this.city = city;
    }

    public Optional<City> getCity() {
        return Optional.ofNullable(city);
    }

}
