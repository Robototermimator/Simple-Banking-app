package com.thorn.banking.repository;

import com.thorn.banking.model.Account;
import com.thorn.banking.util.FileUtil;

import java.util.*;

public class FileAccountRepository {

    private static final String FILE_PATH = "data/accounts.db";

    private Map<String, Account> accounts = new HashMap<>();

    public FileAccountRepository() {
        loadFromFile();
    }

    public void saveAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
        saveToFile();
    }

    public Account findById(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public Map<String, Account> getAll() {
        return accounts;
    }

    // LOAD FROM FILE
    private void loadFromFile() {

        List<String> lines = FileUtil.readFile(FILE_PATH);

        for (String line : lines) {

            String[] parts = line.split("\\|");

            Account account = new Account(
                    parts[0],
                    parts[1],
                    parts[2],
                    Double.parseDouble(parts[3]),
                    Integer.parseInt(parts[4]),
                    Boolean.parseBoolean(parts[5])
            );

            accounts.put(account.getAccountNumber(), account);
        }
    }

    //  SAVE TO FILE
    private void saveToFile() {

        List<String> lines = new ArrayList<>();

        for (Account acc : accounts.values()) {
            lines.add(acc.toFileString());
        }

        FileUtil.writeFile(FILE_PATH, lines);
    }
}