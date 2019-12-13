package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompetitionFileReader {

    public static long readMaxId(File file) {
        readAllLines();



    }

    private static void readAllLines() {
        List<String> list = new ArrayList<>();
        Scanner in = null;
        try {
            in = new Scanner(new File());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (in.hasNextLine()) {
            list.add(in.nextLine());
        }
    }

    private static long retrieveIdfromString(String string){
        String[] strings = string.split(";");
        return Long.parseLong(strings[0]);
    }
}
