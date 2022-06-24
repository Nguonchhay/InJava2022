package com.nguonchhay.galleryapp;

import com.nguonchhay.galleryapp.screens.LoginScreen;

public class MainApp {
    public static void launch() {
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.open();
    }
}
