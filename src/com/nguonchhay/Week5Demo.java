package com.nguonchhay;

import com.nguonchhay.oop.MyCalculator;

public class Week5Demo {
     MyCalculator cal = new MyCalculator();

     public void demo() {
         System.out.println("Week5Demo: " + cal.getValue2());
         System.out.println("3 + 6 = " + cal.sum());
         System.out.println("3 * 6 = " + cal.mul());
         System.out.println("3 - 6 = " + cal.minus());
     }
}
