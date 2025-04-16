package org.example.exercises.nestedDataprocessing;

import java.time.LocalDate;
import java.util.Optional;

public class Employee {

    private String name;
    private  double salary;
    private  Optional<LocalDate> endDate;


    public Employee(String name, double salary, Optional<LocalDate> endDate) {
        this.name = name;
        this.salary = salary;
        this.endDate = endDate;
    }

    public String getName() { return name; }

    public double getSalary() { return salary; }

    public Optional<LocalDate> getEndDate() { return endDate; }
}
