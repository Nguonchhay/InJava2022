package com.nguonchhay;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Week2Demo {

    public void task1() {
        /**
         * Steps:
         * 1. Get user input score
         * 2. One score has one grade
         * 3. Apply multiple condition to find grade
         * 4. Display grade based on input score
         */
        System.out.print("Enter score: ");
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();
        // 95 <= score <= 100 => A
        // 90 <= score < 95 => B
        if (score >= 95) {
            System.out.println("Your grade is A");
        } else if (score >= 90 && score < 95) {
            System.out.println("Your grade is B");
        } else if (score >= 80 && score < 90) {
            System.out.println("Your grade is C");
        } else if (score >= 65 && score < 80) {
            System.out.println("Your grade is D");
        } else if (score >= 50 && score < 65) {
            System.out.println("Your grade is E");
        } else {
            System.out.println("Your grade is F");
        }
    }

    public void task2() {
        /**
         * Rectangle:
         * 1. Area      = width * height
         * 2. Perimeter = 2 * (width + height)
         */
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter width: ");
        double width = scanner.nextDouble();

        System.out.print("Enter height: ");
        double height = scanner.nextDouble();

        double area = width * height;
        double perimeter = 2 * (width + height);

        System.out.println("Area = " + area + ", perimeter = " + perimeter);
    }

    public void task3() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int firstValue = scanner.nextInt();

        System.out.print("Enter second number: ");
        int secondValue = scanner.nextInt();

        if (firstValue == 30 || secondValue == 30 || firstValue + secondValue == 30) {
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }
    }

    public void task4() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input 1: ");
        int input1 = scanner.nextInt();

        System.out.print("Input 2: ");
        int input2 = scanner.nextInt();

        System.out.print("Input operator(+, -, *, /, or %): ");
        char sign = scanner.next().charAt(0);

        switch (sign) {
            case '+':
                // int sum = input1 + input2;
                // System.out.println("Result: " + sum);
                System.out.println("Result: " + (input1 + input2));
                break;
            case '-':
                System.out.println("Result: " + (input1 - input2));
                break;
            case '*':
                System.out.println("Result: " + (input1 * input2));
                break;
            case '/':
                // check condition for input2 = 0
                System.out.println("Result: " + (input1 / input2));
                break;
            case '%':
                System.out.println("Result: " + (input1 % input2));
                break;
            default:
                System.out.println("Invalid operator");
        }
    }

    public void task5() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter birth date (mm/dd/yyyy): ");
        String strBirthDate = scanner.next();

        System.out.print("Enter name: ");
        String name = scanner.next();

        // Get current date
        Calendar calendar = Calendar.getInstance();

        // Convert input birth date to Date object
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        try {
            Date birtDate = simpleDateFormat.parse(strBirthDate);
            long timeDifferent = Math.abs(calendar.getTimeInMillis() - birtDate.getTime());

            /**
             * 1s = 1000ms
             * 1m = 60s
             * 1h = 60m
             * 1d = 24h
             */

            long days = TimeUnit.DAYS.convert(timeDifferent, TimeUnit.MILLISECONDS);
            int year = (int)(days / 365);
            int remainingDays = (int)(days % 365);

            System.out.println("Welcome to " + name + " you are " + year + " years old and days: " + remainingDays);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
