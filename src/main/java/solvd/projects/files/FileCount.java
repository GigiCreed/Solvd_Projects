package solvd.projects.files;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class FileCount {
    private static final Logger LOGGER = LogManager.getLogger(FileCount.class);

    public static void main(String[] args) throws IOException {
        String readFile = FileUtils.readFileToString(new File("text.txt"), StandardCharsets.UTF_8.name());
        if(Objects.equals(readFile, "")){
            LOGGER.error("File is empty !!!!");
        }
        else {
            String[] split = readFile.split("\\s+");
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            for (int i = 0; i < split.length; i++) {
                if (map.containsKey(split[i])) {
                    int count = map.get(split[i]);
                    map.put(split[i], count + 1);
                } else {
                    map.put(split[i], 1);
                }
            }
            FileUtils.writeLines(new File("uniqueWordNumber.txt"), StandardCharsets.UTF_8.name(), Collections.singleton(map));
            LOGGER.info(" Complected !!!! ");
        }




    }
}
