package file;

import org.apache.commons.lang3.StringUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CoachFileWriter {

    public static void writeLinesToFile(List<String> lines){
        FileWriter fileWriter = null;
        try {
             fileWriter = new FileWriter("/Users/mac/Downloads/MyProjects/Competition/database/coachList.txt");

                fileWriter.write(StringUtils.join(lines,"\n"));

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            closeWriter(fileWriter);
        }

    }

    private static void closeWriter(FileWriter fileWriter) {
        if (fileWriter != null){
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
