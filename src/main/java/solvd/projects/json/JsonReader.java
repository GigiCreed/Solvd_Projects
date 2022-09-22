package solvd.projects.json;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.json.models.Students;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonReader {
    private static final Logger LOGGER = LogManager.getLogger(JsonReader.class);
    public static void main(String[] args) {
        ObjectMapper objectMapper =new ObjectMapper();
        try {
            JavaType javaType = objectMapper.getTypeFactory().constructCollectionType(List.class, Students.class);
            List<Students> studentsList = objectMapper.readValue(new File("src/main/resources/jsonfiles/students.json"),javaType);
            LOGGER.info(studentsList);
        }catch (IOException ex){
            LOGGER.error(ex);
        }
    }
}
