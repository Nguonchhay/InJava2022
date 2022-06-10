package com.nguonchhay.week7;

public class Employee {

    private double baseSalary;
    private int numWorkingHourPerDay;

    public Employee() {
        this.baseSalary = 0;
        this.numWorkingHourPerDay = 0;
    }

    public Employee(double baseSalary) {
        setBaseSalary(baseSalary);
    }

    public Employee(double salary, int hour) {
        setBaseSalary(salary);
        setNumWorkingHourPerDay(hour);
    }

    public double getBaseSalary() {
        return this.baseSalary;
    }

    public void setBaseSalary(double salary) {
        this.baseSalary = salary;
    }

    public int getNumWorkingHourPerDay() {
        return this.numWorkingHourPerDay;
    }

    public void setNumWorkingHourPerDay(int hour) {
        this.numWorkingHourPerDay = hour;
    }

    public double getInfo(double salary, int numWorkingHourPerDay) {
        double total = salary * numWorkingHourPerDay;
        return total;
    }

    public void addSal() {
        double totalSalary = getInfo(getBaseSalary(), getNumWorkingHourPerDay());
        if (totalSalary < 500) {
            setBaseSalary(totalSalary + 10);
        }
    }

    public void addWork() {
        if (getNumWorkingHourPerDay() > 6) {
            setBaseSalary(getBaseSalary() + 5);
        }
    }

    public void printFinalSalary() {
        System.out.println(getInfo(getBaseSalary(), getNumWorkingHourPerDay()));
    }
}
