package org.example;

import org.example.exercises.*;
import org.example.exercises.NestedValidation.Email;
import org.example.exercises.NestedValidation.EmailNotValidException;
import org.example.exercises.NestedValidation.Profile;
import org.example.exercises.NestedValidation.User;

import static org.example.exercises.SumOfEvenNumbers.sum;

import org.example.exercises.chainOfMethods.Address;
import org.example.exercises.chainOfMethods.City;
import org.example.exercises.chainOfMethods.Person;
import org.example.exercises.combiningMapAndFlatMap.Department2;
import org.example.exercises.combiningMapAndFlatMap.Employee2;
import org.example.exercises.nestedDataprocessing.Department;
import org.example.exercises.nestedDataprocessing.DepartmentProcess;
import org.example.exercises.nestedDataprocessing.Employee;
import org.example.exercises.primesandnonprimes.PrimeNonPrimeCollector;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        //1. Streams: Sum of Even Numbers
        int[] myArray = {5, 20, 3, 4, 5};
        System.out.println(sum(myArray));


        // 2. Optional: Safe String Length
        System.out.println(SafeStringLength.getLength(null)); //print 0
        System.out.println(SafeStringLength.getLength("amazon")); //print 6


        // 3. Streams: Group Words by Length
        List<String> words = Arrays.asList("apple", "deda", "non", "banana", "hat", "cup", "abcd");
        System.out.println(GroupWordsByLength.getTheMap(words));


        //4. Optional: Chain of Methods
        Person person = new Person(new Address(new City("cairo")));
        System.out.println(person.getCityName());
        Person secondPerson = new Person(new Address(new City(null)));
        System.out.println(secondPerson.getCityName());


        //5. Streams:
        List<Integer> nums = Arrays.asList(2);
        System.out.println(FindSecondLargestNumber.theSecondLargest(nums).orElse(null));


        // 6. Optional: Nested Validation
        try {
            User user = new User(new Profile(new Email("mayadaexample.com")));
            user.getEmailOrThrow();
        } catch (EmailNotValidException e) {
            System.out.println("Error: " + e.getMessage());
        }


        //7. Streams: Generate the Fibonacci Sequence
        List<Integer> fib = FibonacciStream.generateFibonacci(10);
        System.out.println("numbers: " + fib);


        //8. Optional: Combine Two Optionals
        Optional<Integer> a = Optional.of(3);
        Optional<Integer> b = Optional.of(7);
        System.out.println(CombineTwoOptionals.sumOptionals(a, b).get());

        Optional<Integer> c = Optional.empty();
        System.out.println(CombineTwoOptionals.sumOptionals(a, c));


        //9. Streams: Nested Data Processing
        Employee e1 = new Employee("Ali", 5000, Optional.empty());
        Employee e2 = new Employee("Sara", 4500, Optional.empty());
        Employee e3 = new Employee("Tariq", 6000, Optional.of(LocalDate.of(2023, 12, 31)));
        Employee e4 = new Employee("Mona", 7000, Optional.empty());

        Department dept1 = new Department("HR", Arrays.asList(e1, e2));
        Department dept2 = new Department("IT", Arrays.asList(e3, e4));

        List<Department> departments = Arrays.asList(dept1, dept2);

        //averageSalary
        Map<String, Double> avgSalaries = DepartmentProcess.getAverageSalaryByDepartment(departments);
        avgSalaries.forEach((department, avgSalary) ->
                System.out.println(department + ": " + avgSalary));


        //10. Streams: Custom Collector for Primes and NonPrimes
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Boolean, Integer> result = numbers.stream()
                .collect(new PrimeNonPrimeCollector());

        System.out.println("Sum of primes: " + result.get(true));
        System.out.println("Product of non-primes: " + result.get(false));


        //11. Optional: Validate and Transform Username
        try {
            Optional<String> validUsername = Optional.of("V23");
            System.out.println("Valid Username: " + UsernameValidator.validateAndTransformUsername(validUsername));
        } catch (UsernameValidator.ValidationException e) {
            System.out.println(e.getMessage());
        }


        // Streams: Moving Average of Window Size K
        System.out.println("Moving averages: " + MovingAverage.movingAverage(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), 3));


        //13. map Exercise
        List<String> names = Arrays.asList("John", "Jane", "Jack", "Doe");
        List<String> uppercaseNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Uppercase List: " + uppercaseNames);


        //14. fl atMap Exercise
        List<String> sentences = Arrays.asList("Hello world", "Java streams", "flatMap example");
        List<String> theWords = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .collect(Collectors.toList());

        System.out.println("Words List: " + theWords);


        //15.map vs. fl atMap
        List<org.example.exercises.User> users = Arrays.asList(
                new org.example.exercises.User("john.doe@example.com"),
                new org.example.exercises.User("jane.smith@example.com"),
                new org.example.exercises.User("admin@example.com")
        );
        List<String> emails = users.stream()  // تحويل القائمة إلى Stream
                .map(org.example.exercises.User::getEmail)  // استخراج البريد الإلكتروني لكل مستخدم
                .toList();
        System.out.println("Emails: " + emails);


        //16. fl atMap with Nested Collections
        List<Order> orders = Arrays.asList(
                new Order(List.of(new Item("item1"), new Item("item2"))),
                new Order(List.of(new Item("item3")))
        );
        List<String> allItems = orders.stream().flatMap(o -> o.getItems().stream().map(Item::getName)).toList();
        System.out.println("allItems  : " + allItems);


        //17. Combining map and fl atMap
        Employee2 emp1 = new Employee2(Optional.of("01012345678"));
        Employee2 emp2 = new Employee2(Optional.empty());
        Employee2 emp3 = new Employee2(Optional.of("01198765432"));

        Department2 department1 = new Department2(List.of(emp1, emp2));
        Department2 department2 = new Department2(List.of(emp3));

        List<Department2> department = List.of(department1, department2);
        List<String> phoneNumbers =department.stream()
                .flatMap(d-> d.getEmployees().stream())
                .map(Employee2::getPhoneNumber)
                .flatMap(Optional::stream)
                .toList();
        System.out.println("Phone Numbers: " + phoneNumbers);
    }
}