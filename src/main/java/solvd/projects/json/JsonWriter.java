package solvd.projects.json;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.json.classes.Students;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JsonWriter {
    private static final Logger LOGGER = LogManager.getLogger(JsonWriter.class);
    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JavaType javaType = objectMapper.getTypeFactory().constructCollectionType(List.class, Students.class);
            objectMapper.writeValue(new File("src/main/resources/jsonfiles/studentsWriter.json"),getStudents());
            LOGGER.info("File is Created");
        }catch (IOException ex){
            LOGGER.error(ex);
        }
    }
    public static List<Students> getStudents() {
        return List.of(
        new Students("gigi", "mamaladze", new Date(10140768000000L), 555, 4),
        new Students("Nika", "mamaladze", new Date(10140768000000L), 555, 4),
        new Students("Irakli", "mamaladze", new Date(10140768000000L), 555, 4)
      );
    }

}
