package repository;

import entity.Coach;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileConfigurator {

    private static final String dirPath = "/Users/mac/Downloads/MyProjects/Competition/database";
    private File coachFile;
    private File sportsmenFile;
    private File allUsersFile;

    public boolean filesExist() {
        boolean created = true;
        coachFile = new File(dirPath + File.separator + "coachList.txt");
        if (!coachFile.exists()) {
            try {
                created = coachFile.createNewFile();
            } catch (IOException e) {
                System.err.println("FileConfigurator.fileExist(); Coach file cannot be created");
                e.printStackTrace();
            }
        }

        sportsmenFile = new File(dirPath + File.separator + "sportsmenList.txt");
        if (!sportsmenFile.exists()) {
            try {
                created = sportsmenFile.createNewFile();
            } catch (IOException e) {
                System.err.println("FileConfigurator.fileExist(); Coach file cannot be created");
                e.printStackTrace();
            }
        }

        allUsersFile = new File(dirPath + File.separator + "allUsersFileList.txt");
        if (!allUsersFile.exists()) {
            try {
                created = allUsersFile.createNewFile();
            } catch (IOException e) {
                System.err.println("FileConfigurator.fileExist(); Coach file cannot be created");
                e.printStackTrace();
            }
        }
        return created;
    }

    boolean setDataToFile(File fileToSave, Object userdata) {
        if (!fileToSave.exists()) {
            System.out.println("Что-то пошло не так? Вы удалили файл или перенесли его");
            return false;
        }

        try {
            FileWriter fileWriter = new FileWriter(fileToSave, true);
            if (userdata instanceof Coach) {
                System.out.println(((Coach) userdata).parseToDbString());
                fileWriter.write(((Coach) userdata).parseToDbString());
                fileWriter.close();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return false;
    }

    public File getCoachFile() {
        return coachFile;
    }

    public File getSportsmenFile() {
        return sportsmenFile;
    }

    public File getAllUsersFile() {
        return allUsersFile;
    }
}
