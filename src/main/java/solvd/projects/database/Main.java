package solvd.projects.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.mysql.dao.*;
import solvd.projects.database.tableclasses.*;

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




// -----------------------------------------------Vice_rectors----------------------------------------------------------

//        ViceRectorsDAO viceRectorsDAO =new ViceRectorsDAO();

                                                //insert

//        ViceRectors viceRectors = new ViceRectors("Lela","turnamindze",new Date(232323321456L),55123,"batumi","lela@gmail.com");
//        viceRectorsDAO.create(viceRectors);


                                              //Update
//        ViceRectors viceRectors = new ViceRectors("Nino","iremadze",new Date(232323321456L),11111,"batumius","nino@gmail.com");
//        viceRectorsDAO.update("all",viceRectors,2L);


                                             //Delete
//        viceRectorsDAO.remove(2L);

                                            //SelectById
//        ViceRectors viceRectors = new ViceRectors();
//        viceRectorsDAO.getBy(viceRectors,1L);
//        LOGGER.info(viceRectors);

                                           //SelectALL
//        for (ViceRectors o:viceRectorsDAO.getAllViceRectors()) {
//            LOGGER.info(o);
//        }


//  -----------------------------------------Universities---------------------------------------------------------------

//        UniversitiesDAO universitiesDAO = new UniversitiesDAO();

                                            //Insert
//        Universities universities =new Universities("Tsu","tbilisi","tsu.com","tsu@gmail.com",8L,3L);
//        universitiesDAO.create(universities);

                                           //Update

//          Universities universities = new Universities("BTU","tbilisi","BTU.com","BTU@gmail.com",8L,3L);
//          universitiesDAO.update("all",universities,2L);

                                          //Remove
//            universitiesDAO.remove(6L);

                                          //SelectBy
//        Universities universities = new Universities();
//        universitiesDAO.getBy(universities,1L);
//        LOGGER.info(universities);


                                         //SelectAll
//        for (Universities u:universitiesDAO.getAllUniversities()) {
//            LOGGER.info(u);
//        }



//  ---------------------------------------------Lectors--------------------------------------------------------------


//        LectorsDAO lectorsDAO = new LectorsDAO();

                                            //Insert

//        Lectors lectors = new Lectors("Cicino","Ketilidapatiosani",new Date(232323321456L),00001,"Batumi","cicino@gmail.com",1L);
//        lectorsDAO.create(lectors);

                                           //Update

//          Lectors lectors = new Lectors("Cicino","sarajishvili",new Date(232323321456L),00001,"Batumi","cicino@gmail.com",1L);
//          lectorsDAO.update("surname",lectors,3L);

                                         //Delete
//            lectorsDAO.remove(3L);

                                         //SelectById
//        Lectors lectors = new Lectors();
//        lectorsDAO.getBy(lectors,1L);
//        LOGGER.info(lectors);

                                      //SelectALL
//        for (Lectors l:lectorsDAO.getAllLectors()) {
//            LOGGER.info(l);
//        }


// -----------------------------------------Deccans----------------------------------------------------------------------











    }
}
