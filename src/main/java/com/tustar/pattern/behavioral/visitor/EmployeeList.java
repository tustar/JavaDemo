package com.tustar.pattern.behavioral.visitor;

import java.util.ArrayList;

public class EmployeeList {

    private ArrayList<Employee> employees = new ArrayList<>();

    public void add(Employee employee) {
        employees.add(employee);
    }

    public void accept(Department department) {
        for (Employee employee : employees) {
            employee.accept(department);
        }
    }
}
