package com.gmail.ggas.file;

import com.gmail.ggas.exception.UserLoginException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class SportsmanFileReader {

    public final static  String relativePassToFile = "database/sportsmenList.txt";


    public static long readMaxId() {
        List<String> lines = readAllLines();
        long maxId = 0;
        for (String line : lines) {
            long currentLineid;
            try {
                currentLineid = Long.parseLong(retrieveIdFromLine(line));
            } catch (NumberFormatException e) {
                System.out.println("Invalid line found");
                continue;
            }
            if (currentLineid > maxId) {
                maxId = currentLineid;
            }

        }
        return maxId;
    }

    public static List<String> readAllLines() {
        List<String> list = new ArrayList<>();
        try (Scanner in = new Scanner(new File(relativePassToFile))) {
            while (in.hasNextLine()) {
                list.add(in.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static List readAllLogins() {
        List<String> list = readAllLines();
        List<String> allLogins = new ArrayList<>();
        for (String string : list
        ) {
            list.add(retrieveLoginFromLine(string));
        }
        return list;
    }

    public static String retrieveIdFromLine(String string) {
        return string.split(";")[0];
    }

    public static String retrieveLoginFromLine(String string) {
        return string.split(";")[5];
    }

    public static String retrievePasswordFromLine(String string) {
        return string.split(";")[9];
    }

    public static String readLineByLogin(String login) {
        List<String> lines = readAllLines();
        for (String line : lines) {
            String currentLineLogin;
            try {
                currentLineLogin = retrieveLoginFromLine(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid line found");
                continue;
            }
            if (currentLineLogin.equals(login)) {
                return line;
            }
        }
        return null;
    }

    public static String findPasswordByLogin(String login, String password) throws UserLoginException {
        List<String> lines = readAllLines();
        ListIterator<String> iterator = lines.listIterator();
        String truePassword;
        while (iterator.hasNext()) {
            String currentLine = iterator.next();
            if (currentLine.split(";")[5].equals(login)) {
                truePassword = currentLine.split(";")[9];
                return truePassword;
            } else {

            }
        }
        throw new UserLoginException();
    }

    public static String readLineById(String id) {
        List<String> lines = readAllLines();
        for (String line : lines) {
            String currentLineId;
            try {
                currentLineId = retrieveIdFromLine(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid line found");
                continue;
            }
            if (currentLineId.equals(id)) {
                return line;
            }
        }
        return null;
    }
}

