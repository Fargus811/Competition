package com.gmail.ggas.file;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class has been created for only usages with id
 */
public class EntityKeyValueFileStore {

    private String relativePathToFile;

    public EntityKeyValueFileStore(String relativePathToFile) {
        this.relativePathToFile = relativePathToFile;
        new FileConfigurator(relativePathToFile).initFile();
    }

    public void writeLinesToFile(List<String> lines) {

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(relativePathToFile);
            fileWriter.write(StringUtils.join(lines, "\n"));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeWriter(fileWriter);
        }
    }

    private void closeWriter(FileWriter fileWriter) {
        if (fileWriter != null) {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public String readLineById(String id) {
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

    public long readMaxId() {
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

    public List<String> readAllLines() {
        List<String> list = new ArrayList<>();
        try (Scanner in = new Scanner(new File(relativePathToFile))) {
            while (in.hasNextLine()) {
                list.add(in.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return list;
    }

    public String retrieveIdFromLine(String string) {
        return string.split(";")[0];
    }

    public void deleteById(long id) {
        List<String> allLines = readAllLines();
        allLines.remove(readLineById(String.valueOf(id)));
        writeLinesToFile(allLines);
    }


}
