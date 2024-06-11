package org.example;

import java.util.Scanner;

public class LoginSystem {
    public static void login() {
        // DynamicPasswordGenerator'ı durdur ve o anki şifreyi al
        DynamicPasswordGenerator.stopGenerating();
        String currentPassword = DynamicPasswordGenerator.getCurrentPassword();
        System.out.println("Attempting login with password: " + currentPassword);

        // Şifre kontrolünü PasswordChecker ile yap
        if (PasswordChecker.checkPassword(currentPassword)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }

        // 0'a basıldığında DynamicPasswordGenerator'ı tekrar başlat
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press 0 to resume password generation.");
        int input = scanner.nextInt();
        if (input == 0) {
            DynamicPasswordGenerator.resumeGenerating();
        }
    }
}
