package com.nguonchhay.week9;

import javax.swing.*;

public class Week9Demo {
    public static void demo() {
        // frameDemo();
        CalculationScreen calculationScreen = new CalculationScreen();
        calculationScreen.display();
    }

    public static void frameDemo() {
        JFrame frame = new JFrame("Java Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
