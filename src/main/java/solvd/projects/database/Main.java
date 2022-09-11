package solvd.projects.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.mysql.dao.RectorsDAO;
import solvd.projects.database.mysql.dao.StudentsDAO;
import solvd.projects.database.mysql.dao.UniversitiesDAO;
import solvd.projects.database.tableclasses.Rectors;
import solvd.projects.database.tableclasses.Students;
import solvd.projects.database.tableclasses.Universities;

import java.sql.Date;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args) {

// --------------------------------------------Students----------------------------------------------------------------

//        StudentsDAO studentsDAO = new StudentsDAO();
//
//                                     SelectById
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


//  ----------------------------------------------Rectors---------------------------------------------------------------



//        RectorsDAO rectorsDAO = new RectorsDAO();

                                        //Select All

//        for (Rectors r: rectorsDAO.getAllRectors()) {
//            LOGGER.info(r);
//        }

                                      //SelectById

//         Rectors rectors = new Rectors();
//         rectorsDAO.getBy(rectors,1L);
//         LOGGER.info(rectors);

                                    //Insert

//        Rectors rectors = new Rectors("irakli","rodinadze", new Date(1028833200000L),5555,"tamarMefisdasaxleba","tina@gmail.com");
//        rectorsDAO.create(rectors);

                                  //Delete

//           rectorsDAO.remove(9L);

                                //update

//        Rectors rectors = new Rectors("Tiniko","Rodinadze",new Date(1028833200000L),599281101,"Tamar Mefis dasaxelba", "Tiniko@gmail.com");
//        rectorsDAO.update("all",rectors,8L);

















    }
}
