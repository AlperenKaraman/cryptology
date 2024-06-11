package org.example;

import java.security.SecureRandom;
import java.util.Random;

public class DynamicPasswordGenerator {
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()-_=+{}[]|;:,.<>?";

    private static final int PASSWORD_LENGTH = 16;

    private static volatile boolean running = true;
    private static volatile String currentPassword = "";

    public static void startGenerating() throws InterruptedException {
        while (running) {
            currentPassword = generatePassword(PASSWORD_LENGTH);
            System.out.println("Current Password: " + currentPassword);
            Thread.sleep(10000); // Her 10 saniyede bir yeni şifre oluştur
        }
    }

    public static void stopGenerating() {
        running = false;
    }

    public static String getCurrentPassword() {
        return currentPassword;
    }

    public static void resumeGenerating() {
        running = true;
        new Thread(() -> {
            try {
                startGenerating();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private static String generatePassword(int length) {
        StringBuilder password = new StringBuilder();
        Random random = new SecureRandom();

        // Karakter seti
        String combinedChars = UPPER + LOWER + DIGITS + SPECIAL;

        // Şifre oluşturma
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(combinedChars.length());
            password.append(combinedChars.charAt(index));
        }

        return password.toString();
    }
}
