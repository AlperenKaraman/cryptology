package org.example;

public class PasswordChecker {
    private static String lastPassword;

    public static boolean checkPassword(String password) {
        return password.equals(lastPassword);
    }

    public static void updatePassword(String password) {
        lastPassword = password;
    }
}
