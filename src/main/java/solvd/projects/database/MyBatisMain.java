package solvd.projects.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.service.mybatis.services.*;
import solvd.projects.database.tableclasses.*;

import java.sql.Date;


public class MyBatisMain {
    private static final Logger LOGGER = LogManager.getLogger(MyBatisMain.class);
    public static void main(String[] args) {

//        StudentsServices studentsServices = new StudentsServices();
//        Students students = new Students("LUka","mamaladze", new Date(100000002323L),555,555,"sdsd",1L,1L);
//        studentsServices.insert(students);


//-------------------------------------------------Universities---------------------------------------------------------

        UniversitiesService universitiesService = new UniversitiesService();

        //selectAll
//        for (Universities u:universitiesService.getAllUniversities()) {
//            LOGGER.info(u);
//        }

        //insert
//        Universities universities = new Universities("JDS","sds","sdsd","sdsd");
//        universitiesService.insert(universities);

//        getById
//        Universities universities = universitiesService.getById(1L);
//        LOGGER.info(universities);

        //Update
//        Universities universities = new Universities("TSU","Tbilisi","BsuPortal.com","Bsu@gmail.com");
//        universitiesService.update(universities,3L);

        //delete
//        universitiesService.delete(4L);

    }
}
