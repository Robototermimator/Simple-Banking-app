package com.thorn.banking.util;

import java.util.Scanner;

public class ConsoleHelper {
    private Scanner scanner = new Scanner(System.in);

    public String getString(String prompt){
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int getInt(String prompt){
        System.out.print(prompt);
        return Integer.parseInt(scanner.nextLine());
    }

    public double getDouble(String prompt){
        System.out.print(prompt);
        return Double.parseDouble(scanner.nextLine());
    }
}