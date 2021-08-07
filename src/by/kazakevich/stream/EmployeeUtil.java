package by.kazakevich.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeUtil {

    public static Map<String, List<Employee>> groupByJobTitle(List<Employee> employeeList) {
        return employeeList.stream().collect(Collectors.groupingBy(Employee::getJobTitle));
    }

    public static double calculateAverageSalary(List<Employee> employeeList) {
        return employeeList.stream().mapToDouble(Employee::getSalary).sum() / employeeList.stream().count();
    }

    public static List<Employee> filterByName(List<Employee> employeeList, String name) {
        return employeeList.stream()
                .filter(employee -> employee.getName().equals(name))
                .collect(Collectors.toList());
    }

    public static List<Employee> filterByNameAndSortBySalaryDesc(List<Employee> employeeList, String name) {
        return employeeList.stream()
                .filter(employee -> employee.getName().equals(name))
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .collect(Collectors.toList());
    }

    public static Employee filterByNameAndFindWithMaxSalary(List<Employee> employeeList, String name) {
        return employeeList.stream()
                .filter(employee -> employee.getName().equals(name))
                .max(Comparator.comparing(Employee::getSalary)).orElse(null);
    }
}
