package com.gmail.ggas.file;

import org.apache.commons.lang3.StringUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CoachFileWriter {

    public final static String relativePassToFile = "database/coachList.txt";

    public static void writeLinesToFile(List<String> lines) {

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(relativePassToFile);
            fileWriter.write(StringUtils.join(lines, "\n"));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeWriter(fileWriter);
        }
    }

    private static void closeWriter(FileWriter fileWriter) {
        if (fileWriter != null) {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
