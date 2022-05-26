package com.nguonchhay.oop;

public class MyCalculator {
    protected int value1;
    protected int value2;

    public MyCalculator() {
        this.value1 = -1;
        this.value2 = 5;
    }

    public MyCalculator(int value1, int value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public int getValue1() {
        return this.value1;
    }

    public void setValue1(int value) {
        this.value1 = value;
    }

    public int getValue2() {
        return this.value2;
    }

    public void setValue2(int value) {
        this.value2 = value;
    }

    public int sum() {
        return this.value1 + this.value2;
    }

    public int minus() {
        return this.value1 - this.value2;
    }

    public int mul() {
        return this.value1 * this.value2;
    }
}
