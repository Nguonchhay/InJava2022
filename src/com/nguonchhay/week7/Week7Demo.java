package com.nguonchhay.week7;

public class Week7Demo {
    public static void demo() {
        employeeDemo();
    }

    public static void employeeDemo() {
        Employee emp = new Employee(500, 7);
        emp.addWork();
        System.out.print("Employee salary = ");
        emp.printFinalSalary();
    }
}
