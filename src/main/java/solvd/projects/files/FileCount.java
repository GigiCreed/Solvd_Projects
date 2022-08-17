package solvd.projects.files;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class FileCount {
    private static final Logger LOGGER= LogManager.getLogger(FileCount.class);
    public static void main(String[] args) throws IOException {
        String readFile = FileUtils.readFileToString(new File("text.txt"), StandardCharsets.UTF_8.name());
        if(Objects.equals(readFile, "")){
            LOGGER.error("File is empty !!!!");
        }
        else {
            long text = Arrays.stream(readFile.split("\\s+")).distinct().count();
            FileUtils.writeLines(new File("uniqueWordNumber.txt"), StandardCharsets.UTF_8.name(), Collections.singleton(text));
            LOGGER.info(" Complected !!!! ");
        }

    }

}