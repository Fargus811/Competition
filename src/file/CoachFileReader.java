package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoachFileReader {

    public static long readMaxId() {
        List<String> lines =readAllLines();
        long maxId = 0;
        for (String line : lines
        ) {
            long currentLineid;
            try {
                currentLineid = retrieveIdfromString(line);
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

    private static List<String> readAllLines() {
        List<String> list = new ArrayList<>();
        Scanner in = null;
        try {
            in = new Scanner(new File("/Users/mac/Downloads/MyProjects/Competition/database/coachList.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (in.hasNextLine()) {
            list.add(in.nextLine());
        }
        return list;
    }

    private static long retrieveIdfromString(String string){
        String[] strings = string.split(";");
        return Long.parseLong(strings[0]);
    }
}
