package solvd.projects.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.service.mybatis.servicies.StudentsServices;
import solvd.projects.database.tableclasses.Students;

import java.sql.Date;

public class MyBatisService {
    private static final Logger LOGGER = LogManager.getLogger(MyBatisService.class);
    public static void main(String[] args) {
        StudentsServices studentsServices = new StudentsServices();
        Students students = new Students("Gigi","mamaladze", new Date(100000002323L),555,555,"sdsd",1L,1L);
        studentsServices.insert(students);
    }
}
