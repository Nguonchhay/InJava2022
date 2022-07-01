package com.nguonchhay.galleryapp;

import com.nguonchhay.galleryapp.screens.LoginScreen;

import javax.swing.*;

public class MainApp {
    public static void launch() {
        try {
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.windows.WindowsLookAndFeel"
            );
        } catch (Exception e) {
            System.out.println("System does not support SystemLookAndFeel");
        }

        LoginScreen loginScreen = new LoginScreen();
        loginScreen.open();
    }
}
