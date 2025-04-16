package org.example.exercises.chainOfMethods;

import java.util.Optional;

public class Person {

    private Address address;

    public Person(Address address) {
        this.address = address;
    }

    public Optional<Address> getAddress() {
        return Optional.ofNullable(address);
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    public String getCityName() {
        return getAddress().flatMap(Address::getCity).map(City::getName).orElse("UnKnown");
    }
}
