package solvd.projects.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.json.models.Students;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class JsonWriter {
    private static final Logger LOGGER = LogManager.getLogger(JsonWriter.class);
    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/resources/jsonfiles/studentsWriter.json"),getStudents());
            LOGGER.info("File is Created");
        }catch (IOException ex){
            LOGGER.error(ex);
        }
    }
    public static List<Students> getStudents() {
        return List.of(
        new Students("gigi", "mamaladze", new Date(10140768000000L), 555, 4),
        new Students("Nika", "mamaladze", new Date(10140768000000L), 555, 4),
        new Students("Levani", "mamaladze", new Date(10140768000000L), 555, 4)
      );
    }

}
