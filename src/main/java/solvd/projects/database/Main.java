package solvd.projects.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.mysql.dao.StudentsDAO;
import solvd.projects.database.mysql.dao.UniversitiesDAO;
import solvd.projects.database.tableclasses.Students;
import solvd.projects.database.tableclasses.Universities;

import java.sql.Date;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args) {

//        StudentsDAO studentsDAO = new StudentsDAO();
//
//                                     SelectBYID
//     Students students = new Students();
//     studentsDAO.getBy(students,23L);
//     LOGGER.info(students);
//
//                                        INSERT
//      Students students1 = new Students("Nika","iremadze",new Date(1014076800000L),55555,3,"sds",1L,2L);
//      studentsDAO.create(students1);
//                                        REMOVE
//     studentsDAO.remove(27L);
//                                        Update
//     Students forUpdate = new Students("Gigi","Gigi",new Date(10140768000000L),14141414,7,"ffffff",1L,2L);
//     studentsDAO.update("all",forUpdate,24L);
//                                       SelectAll
//        for (Students o: studentsDAO.getAllStudents()) {
//            LOGGER.info(o);
//        }

        UniversitiesDAO universitiesDAO = new UniversitiesDAO();
//
//        Universities universities = new Universities();
//        universitiesDAO.getBy(universities,1L);
//        LOGGER.info(universities);

//        for (Universities o: universitiesDAO.getAllUniversities()){
//            LOGGER.info(o);
//        }



    }
}
