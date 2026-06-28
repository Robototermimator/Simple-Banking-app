package com.thorn.banking.security;

import java.security.MessageDigest;

public class PasswordHasher {
    // Hashes a password using SHA-256 algorithm
    public static String hash(String input){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(input.getBytes("UTF-8"));

            StringBuilder hexString = new StringBuilder();

            for (byte b : encodedhash){
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        }
        catch (Exception e){
            throw new RuntimeException("Error hashing PIN");

        }
    }public static boolean verify(String inputPin, String storedHash){
        return hash(inputPin).equals(storedHash);
    }
}
