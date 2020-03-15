package com.gmail.ggas.file;

import java.io.File;
import java.io.IOException;

class FileConfigurator {

    private static final String DIR_PATH = "/Users/mac/Downloads/MyProjects/Competition";
    private String relativePath;
    private File file;

    FileConfigurator(String relativePath) {
        this.relativePath = relativePath;
        this.file = new File(DIR_PATH + File.separator + relativePath);
    }

    void initFile() {
        boolean fileCreated = createFileIfNotExists(file, relativePath);
        if (!fileCreated) {
            throw new RuntimeException("File " + file + " is not created");
        }
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
}
