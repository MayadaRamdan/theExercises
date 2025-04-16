package org.example.exercises.nestedDataprocessing;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DepartmentProcess {

    public static Map<String, Double> getAverageSalaryByDepartment(List<Department> departments) {
        return departments.stream()
                .flatMap(dept -> dept.getEmployees().stream()
                        .filter(emp -> !emp.getEndDate().isPresent())
                        .map(emp -> new AbstractMap.SimpleEntry<>(dept.getName(), emp.getSalary())))
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.averagingDouble(Map.Entry::getValue)
                ));
    }


    }
