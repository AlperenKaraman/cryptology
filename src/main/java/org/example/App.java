package org.example;

public class App {
    public static void main(String[] args) throws InterruptedException {
        // DynamicPasswordGenerator'ı başlat
        Thread generatorThread = new Thread(() -> {
            try {
                DynamicPasswordGenerator.startGenerating();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        generatorThread.start();

        // Giriş işlemi yapmak için kısa bir bekleme
        Thread.sleep(15000); // 15 saniye bekleme

        // Giriş yapılacak şifreyi güncelle
        String currentPassword = DynamicPasswordGenerator.getCurrentPassword();
        PasswordChecker.updatePassword(currentPassword);

        // LoginSystem'i başlat
        LoginSystem.login();
    }
}
