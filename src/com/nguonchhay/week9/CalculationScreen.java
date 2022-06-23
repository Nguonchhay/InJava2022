package com.nguonchhay.week9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculationScreen extends JFrame {

    JTextField txtValue1, txtValue2, txtResult;

    public CalculationScreen() {
        super.setTitle("Simple Calculator");
        super.setSize(600, 600);
    }

    public CalculationScreen(String title) {
        super.setTitle(title);
        super.setSize(600, 600);
    }

    public CalculationScreen(int width, int height) {
        super.setTitle("Simple Calculator");
        super.setSize(width, height);
    }

    public CalculationScreen(String title, int width, int height) {
        super.setTitle(title);
        super.setSize(width, height);
    }

    private void initUI() {
        int initY = 20;

        // Add form title
        JLabel lblTitle = new JLabel("Calculator", JLabel.CENTER);
        lblTitle.setBounds(200, initY, 100, 20);
        lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblTitle.setForeground(Color.BLUE);
        super.add(lblTitle);

        // Add value1 component
        JLabel lblValue1 = new JLabel("Value 1: ");
        lblValue1.setBounds(100, initY + 50, 60, 20);
        super.add(lblValue1);

        txtValue1 = new JTextField(50);
        txtValue1.setBounds(170, initY + 50, 100, 20);
        super.add(txtValue1);

        // Add value2 component
        JLabel lblValue2 = new JLabel("Value 2: ");
        lblValue2.setBounds(100, initY + 80, 60, 20);
        super.add(lblValue2);

        txtValue2 = new JTextField(50);
        txtValue2.setBounds(170, initY + 80, 100, 20);
        super.add(txtValue2);

        // Add buttons components
        JButton btnAdd = new JButton(" + ");
        btnAdd.setBounds(80, initY + 120, 50, 30);
        // btnAdd.addActionListener(new ButtonEventClick(this, btnAdd));
        btnAdd.addActionListener(e -> {
            txtResult.setText(getSum() + "");
        });
        super.add(btnAdd);

        JButton btnMinus = new JButton(" - ");
        btnMinus.setBounds(140, initY + 120, 50, 30);
        btnMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(CalculationScreen.this, "Button Minus clicked!");
            }
        });
        super.add(btnMinus);

        JButton btnMul = new JButton(" * ");
        btnMul.setBounds(200, initY + 120, 50, 30);
        super.add(btnMul);

        JButton btnDiv = new JButton(" / ");
        btnDiv.setBounds(260, initY + 120, 50, 30);
        super.add(btnDiv);

        // Add result components
        JLabel lblResult = new JLabel("Value 2: ");
        lblResult.setBounds(100, initY + 170, 60, 20);
        super.add(lblResult);

        txtResult = new JTextField(50);
        txtResult.setBounds(170, initY + 170, 100, 20);
        txtResult.setEditable(false);
        super.add(txtResult);
    }

    private double getSum() {
        double value1 = Double.parseDouble(txtValue1.getText());
        double value2 = Double.parseDouble(txtValue2.getText());
        return value1 + value2;
    }

    public void display() {
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(null);

        initUI();

        super.setVisible(true);
    }

    class ButtonEventClick implements ActionListener {
        private JFrame frame;
        private JButton button;

        public ButtonEventClick(JFrame frame, JButton btn) {
            this.frame = frame;
            this.button = btn;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(frame, "Click me");
        }
    }
}
