package com.nguonchhay;

import java.sql.Array;
import java.util.Locale;
import java.util.Scanner;

public class Week3Demo {

    public void printArray(int []arr) {
        for (int index = 0; index < arr.length; index++) {
            System.out.print(arr[index] + "  ");
        }
    }

    public void task1() {
        int[] arrNumber = {4, 5};
        int count = arrNumber.length;
        if (count > 0) {
            int maxValue = arrNumber[0];
            for (int index = 1; index < count; index++) {
                if (maxValue < arrNumber[index]) {
                    maxValue = arrNumber[index];
                }
            }
            System.out.println("Max value: " + maxValue);
        } else {
            System.out.println("Empty array");
        }
    }

    public void task2() {
        int[] arrNumber = {10, 4, 6, 2, 3};
        System.out.println("Before sort");
        printArray(arrNumber);

        int count = arrNumber.length;
        for (int index = 0; index < count - 1; index++) {
            for (int nextIndex = index + 1; nextIndex < count; nextIndex++) {
                if (arrNumber[index] > arrNumber[nextIndex]) {
                    int temp = arrNumber[index];
                    arrNumber[index] = arrNumber[nextIndex];
                    arrNumber[nextIndex] = temp;
                }
            }
        }

        System.out.println("\nAfter sort");
        printArray(arrNumber);
    }

    public int mySum(int[] arr) {
        int index = 0;
        int sum = 0;
        while (index < arr.length) {
            sum += arr[index++];
        }
        return sum;
    }

    public void task3() {
        int[] arrNumber = {1, 4, 6, 2, 3};
        System.out.println("Array values:");
        printArray(arrNumber);
        int sum = mySum(arrNumber);
        System.out.println("\nSum: " + sum);
    }

    public int countRemoveItem(int[] arr, int removeNumber) {
        int count = 0;
        for (int ind = 0; ind < arr.length; ind++) {
            if (arr[ind] == removeNumber) {
                count++;
            }
        }
        return count;
    }

    public int[] removeArrayItems(int[] arr, int removeNumber) {
        int count = countRemoveItem(arr, removeNumber);

        int[] newArray = new int[arr.length - count];
        if (count > 0) {
            int newInd = 0;
            for (int ind = 0; ind < arr.length; ind++) {
                if (arr[ind] != removeNumber) {
                    newArray[newInd++] = arr[ind];
                }
            }
        }

        return newArray;
    }

    public void task4() {
        int[] arrNumber = {1, 4, 60, 2, 6};
        System.out.println("Before remove:");
        printArray(arrNumber);

        int[] newNumber = removeArrayItems(arrNumber, 6);
        System.out.println("After remove:");
        printArray(newNumber);
    }

    public void task5() {
        int[] arrNumber = {1, 4, 6, 20, 30};
        int maxValue = arrNumber[0];
        int secondMaxValue = arrNumber[0];

        /**
         * Apply on IF condition
         * ind = 0 => arrNumber[0] = 10, maxValue = 1, secondMaxValue = 1
         * ind = 1 => arrNumber[1] = 40, secondMaxValue = 1, maxValue = 40
         * ind = 2 => arrNumber[2] = 6, continue next loop
         * ind = 3 => arrNumber[3] = 2, continue next loop
         * ind = 4 => arrNumber[4] = 30, continue next loop
         * ind = 5 exit loop
         */

        /**
         * Apply on IF...ELSE condition
         * ind = 0 => arrNumber[0] = 10, maxValue = 1, secondMaxValue = 1
         * ind = 1 => arrNumber[1] = 40, secondMaxValue = 1, maxValue = 40
         * ind = 2 => arrNumber[2] = 6, if (40 < 6) fail then else (1 < 6) then secondMaxValue = 6
         * ind = 3 => arrNumber[3] = 2, if (40 < 2) fail then else (6 < 2) fail
         * ind = 4 => arrNumber[4] = 30, if (40 < 30) fail then else (6 < 30) then secondMaxValue = 30
         * ind = 5 exit loop
         */

        for (int ind = 1; ind < arrNumber.length; ind++) {
            if (maxValue < arrNumber[ind]) {
                secondMaxValue = maxValue;
                maxValue = arrNumber[ind];
            } else {
                if (secondMaxValue < arrNumber[ind]) {
                    secondMaxValue = arrNumber[ind];
                }
            }
        }

//        for (int ind = 0; ind < arrNumber.length; ind++) {
//            if (arrNumber[ind] > secondMaxValue && arrNumber[ind] != maxValue) {
//                secondMaxValue = arrNumber[ind];
//            }
//        }

        System.out.println("Second max value: " + secondMaxValue);
    }

    public void task6() {
        final int countProduct = 100;
        String[] names = new String[countProduct];
        double[] unitPrices = new double[countProduct];
        int[] quantities = new int[countProduct];
        int numProduct = 0;

        char answer = ' ';
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("--------------");
            System.out.print("Product name: ");
            names[numProduct] = scanner.nextLine();

            System.out.print("Quantity: ");
            quantities[numProduct] = scanner.nextInt();

            System.out.print("Unit Price: ");
            unitPrices[numProduct] = scanner.nextDouble();

            System.out.print("\nPress y|Y to continue: ");
            answer = scanner.next().toLowerCase().charAt(0);

            numProduct++;
        } while(answer == 'y');

        // Display products
        System.out.println("\n\t Product Info");
        System.out.println("\n#\tProduct Name\tQuantity\tUnit Price\tTotal");
        double total = 0;
        for (int i = 0; i < numProduct; i++) {
            double subTotal = quantities[i] * unitPrices[i];
            total += subTotal;
            System.out.println(
                (i + 1) + "\t" + names[i] + "\t" + quantities[i] + "\t" + unitPrices[i] + "\t" + subTotal
            );
        }
        System.out.println("\n---------------------------------------");
        System.out.println("\t\t\t " + total);
    }
}
