package com.tustar.pattern.behavioral.visitor;

public class Client {
    public static void main(String[] args) {

        EmployeeList employeeList = new EmployeeList();

        FullTimeEmployee zwj = new FullTimeEmployee("张无忌", 3200.0, 45);
        FullTimeEmployee yg = new FullTimeEmployee("杨过", 2000.0, 40);
        FullTimeEmployee dy = new FullTimeEmployee("段誉", 2400.0, 38);

        PartTimeEmployee hqg = new PartTimeEmployee("洪七公", 80.0, 20);
        PartTimeEmployee gj = new PartTimeEmployee("郭靖", 60.0, 18);

        employeeList.add(zwj);
        employeeList.add(yg);
        employeeList.add(dy);
        employeeList.add(hqg);
        employeeList.add(gj);

        employeeList.accept(new FAD());
        employeeList.accept(new HRD());
    }
}
