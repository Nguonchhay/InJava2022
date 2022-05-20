package com.nguonchhay;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.*;

public class Week4Demo {

    public void printList(List<Integer> arr) {
        for (int index = 0; index < arr.size(); index++) {
            System.out.println(" " + arr.get(index));
        }
    }

    public void task1() {
        ArrayList<Integer> originalArray = new ArrayList<>();
        originalArray.add(1);
        originalArray.add(3);
        originalArray.add(5);
        System.out.println("Original Array:");
        printList(originalArray);

//        ArrayList<Integer> cloneArray = originalArray;
//        cloneArray.set(1, 7);
//        System.out.println("Clone Array:");
//        printList(cloneArray);

        ArrayList<Integer> cloneArray = new ArrayList<>();
//        originalArray.forEach(item -> {
//            cloneArray.add(item);
//        });
        cloneArray.addAll(originalArray);
        cloneArray.set(1, 9);
        System.out.println("Clone Array:");
        printList(cloneArray);

        System.out.println("Original Array:");
        printList(originalArray);
    }

    public List<Integer> replaceListElement(List<Integer> arr, int oldElement, int newElement) {
        for (int index = 0; index < arr.size(); index++) {
            if (arr.get(index) == oldElement) {
                arr.set(index, newElement);
            }
        }
        return arr;
    }

    public void task2() {
        List<Integer> arr = new ArrayList<>();
        arr.addAll(Arrays.asList(new Integer[] {1, 3, 5, 7, 3}));
        System.out.println("Before replace: ");
        printList(arr);

        arr = replaceListElement(arr, 3, 6);
        System.out.println("After replace: ");
        printList(arr);
    }

    public void task3() {
        LinkedList<String> names = new LinkedList<>();
        names.add("AAA");
        names.add("BBB");
        names.add("CCC");
        System.out.println("Order:");
        Iterator<String> iteratorOrder = names.iterator();
        while(iteratorOrder.hasNext()) {
            System.out.println(iteratorOrder.next());
        }

        System.out.println("Reverse Order:");
        Iterator<String> iteratorReverse = names.descendingIterator();
        while(iteratorReverse.hasNext()) {
            System.out.println(iteratorReverse.next());
        }
    }

    public void task4() {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(2);

        Set<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(4);
        set2.add(5);

        Set<Integer> combination = new HashSet<>();
        combination.addAll(set1);
        combination.addAll(set2);
        combination.forEach(item -> {
            System.out.println(item);
        });
    }

    public void task5() {
        List<Integer> arr1 = new ArrayList<>();
        arr1.add(1);
        arr1.add(2);
        arr1.add(3);
        int sumArr1 = 0;
        for (int index = 0; index < arr1.size(); index++) {
            sumArr1 += arr1.get(index);
        }

        List<Integer> arr2 = new ArrayList<>();
        arr2.add(5);
        int sumArr2 = 0;
        for (int item : arr2) {
            sumArr2 += item;
        }

        if (sumArr1 < sumArr2) {
            System.out.println("Array 1 < Array 2");
        } else {
            System.out.println("Array 1 > Array 2");
        }
    }

    public void task5More() {
        List<Integer> arr1 = new ArrayList<>();
        arr1.addAll(Arrays.asList(new Integer[]{1, 2, 3}));

        List<Integer> arr2 = new ArrayList<>();
        arr2.addAll(Arrays.asList(new Integer[]{5}));

        int sumArr1 = arr1.stream().mapToInt(item -> item.intValue()).sum();
        int sumArr2 = arr2.stream().mapToInt(item -> item.intValue()).sum();
        if (sumArr1 < sumArr2) {
            System.out.println("Array 1 < Array 2");
        } else {
            System.out.println("Array 1 > Array 2");
        }
    }

    public void task6() {
        int[] arr = {2, 3, 6};
        Map<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < arr.length; index++) {
            map.put(index, arr[index]);
        }

        map.forEach((index, item) -> {
            System.out.println(index + " => " + item);
        });
    }
}
