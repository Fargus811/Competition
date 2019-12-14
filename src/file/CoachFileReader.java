package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoachFileReader {

    public static long readMaxId() {
        List<String> lines = readAllLines();
        long maxId = 0;
        for (String line : lines
        ) {
            long currentLineid;
            try {
                currentLineid = Long.parseLong(retrieveIdfromString(line));
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
        Scanner in = null;
        try {
            in = new Scanner(new File("/Users/mac/Downloads/MyProjects/Competition/database/coachList.txt"));
            while (in.hasNextLine()) {
                list.add(in.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
            }
        }

        return list;
    }


    public static String retrieveIdfromString(String string) {
        return string.split(";")[0];
    }

    public static String readLineById(String id) {
        List<String> lines = readAllLines();
        for (String line : lines
        ) {
            String currentLineid;
            try {
                currentLineid = retrieveIdfromString(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid line found");
                continue;
            }
            if (currentLineid.equals(id)) {
                return line;
            }

        }
        return null;
    }
}
