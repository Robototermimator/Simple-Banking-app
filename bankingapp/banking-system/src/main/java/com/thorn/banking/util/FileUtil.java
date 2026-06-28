package com.thorn.banking.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static void writeFile(String path, List<String> lines) {

     try {

            File file = new File(path);

            // Create parent directory if it doesn't exist
            File parent = file.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {

                for (String line : lines) {
                    writer.write(line);
                    writer.newLine();
                }

            }

        } catch (IOException e) {
            throw new RuntimeException("Error writing file: " + path, e);
        }
    }
    // READ FROM FILE
    public static List<String> readFile(String path) {

        List<String> lines = new ArrayList<>();

        File file = new File(path);

        if (!file.exists()) return lines;

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + path, e);
        }

        return lines;
    }
}