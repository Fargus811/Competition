package repository;

import entity.Coach;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileConfigurator {

    private static final String DIR_PATH = "/Users/mac/Downloads/MyProjects/Competition/database";
    private static final String SPORTSMEN_FILE_NAME = "sportsmenList.txt";
    private static final String COACH_FILE_NAME = "coachList.txt";
    private static final String USERS_FILENAME = "allUsersList.txt";
    private File coachFile =new File(DIR_PATH + File.separator + COACH_FILE_NAME);
    private File sportsmenFile = new File(DIR_PATH + File.separator + SPORTSMEN_FILE_NAME);
    private File allUsersFile = new File(DIR_PATH + File.separator + USERS_FILENAME);

    public boolean initFiles() {
        boolean createdCoachFile;
        boolean createdSportsmenFile;
        boolean createdAllUsersFile;
        createdSportsmenFile = createFileIfNotExists(sportsmenFile, SPORTSMEN_FILE_NAME);
        createdCoachFile = createFileIfNotExists(coachFile, COACH_FILE_NAME);
        createdAllUsersFile = createFileIfNotExists(allUsersFile, USERS_FILENAME);

        return createdAllUsersFile && createdCoachFile && createdSportsmenFile;
    }

    private boolean createFileIfNotExists(File file, String fileName) {
        boolean created = true;
        if (!file.exists()) {
            try {
                created = file.createNewFile();
            } catch (IOException e) {
                System.err.println("FileConfigurator.fileExist();" + fileName + " file cannot be created");
                e.printStackTrace();
            }
        }
        return created;
    }

    boolean writeDataToFile(File fileToSave, Object userdata) {
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
