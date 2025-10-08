package com.example.futsapp.logic;


public class LoginManager {
    /**
     * Simulación de login: usuario y contraseña no vacíos son válidos
     */
    public static boolean login(String username, String password) {
        if (username == null || username.isEmpty()) return false;
        if (password == null || password.isEmpty()) return false;
        return true;
    }
}