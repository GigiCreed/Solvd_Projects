package solvd.projects.patterns.builder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        Teacher teacher = Teacher.builder()
                .withName("Gigi")
                .withSecondName("Mamaladze")
                .withAge((short)18)
                .withPhoneNumber(5559235).build();
        LOGGER.info(teacher);
    }
}
