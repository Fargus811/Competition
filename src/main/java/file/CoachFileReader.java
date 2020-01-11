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
        try (Scanner in = new Scanner(new File("/Users/mac/Downloads/MyProjects/Competition/database/coachList.txt"))) {
            while (in.hasNextLine()) {
                list.add(in.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return list;
    }


    public static String retrieveIdFromLine(String string) {
        return string.split(";")[0];
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
