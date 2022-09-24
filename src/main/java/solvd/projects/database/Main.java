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

//        Rectors rectors = new Rectors("irakli","rodinadze", new Date(1028833200000L),5555,"tamarMefisdasaxleba","tina@gmail.com",3L);
//        rectorsDAO.create(rectors);

                                  //Delete

//           rectorsDAO.remove(9L);

                                //update

//        Rectors rectors = new Rectors("Tiniko","Rodinadze",new Date(1028833200000L),599281101,"Tamar Mefis dasaxelba", "Tiniko@gmail.com",3L);
//        rectorsDAO.update("all",rectors,3L);




// -----------------------------------------------Vice_rectors----------------------------------------------------------

//        ViceRectorsDAO viceRectorsDAO =new ViceRectorsDAO();

                                                //insert

//        ViceRectors viceRectors = new ViceRectors("Lela","turnamindze",new Date(232323321456L),55123,"batumi","lela@gmail.com",1L);
//        viceRectorsDAO.create(viceRectors);


                                              //Update
//        ViceRectors viceRectors = new ViceRectors("Nino","iremadze",new Date(232323321456L),11111,"batumius","nino@gmail.com",1L);
//        viceRectorsDAO.update("all",viceRectors,2L);


                                             //Delete
//        viceRectorsDAO.remove(3L);

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
//        Universities universities =new Universities("Tsu","tbilisi","tsu.com","tsu@gmail.com");
//        universitiesDAO.create(universities);

                                           //Update

//          Universities universities = new Universities("BTU","tbilisi","BTU.com","BTU@gmail.com");
//          universitiesDAO.update("all",universities,2L);

                                          //Remove
//            universitiesDAO.remove(2L);

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
//
//                                            //Insert
//
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

//   DeccansDAO deccansDAO = new DeccansDAO();

                                       //Insert
//        Deccans deccans = new Deccans("lasha","turmanidze",new Date(232323321456L),"batumi",444444,"giorgi@gmail.com",1L);
//        deccansDAO.create(deccans);


                                     //Remove
//        deccansDAO.remove(5L);

                                    //Update
//        Deccans deccans = new Deccans("Luka","Qatamadze",new Date(232323321456L),"batumi",7777777,"Luka@gmail.com",1L);
//        deccansDAO.update("all",deccans,6L);

                                    //SelectById

//        Deccans deccans = new Deccans();
//        deccansDAO.getBy(deccans,6L);
//        LOGGER.info(deccans);

                                 //SelectAll
//        for (Deccans d:deccansDAO.getAllDeccans()) {
//            LOGGER.info(d);
//        }


//-------------------------------------------Faculties----------------------------------------------------------------------

//         FacultiesDAO facultiesDAO = new FacultiesDAO();

                                       //inserting
//        Faculties faculties = new Faculties("Medicine",1L,1L);
//        facultiesDAO.create(faculties);

                                      //Updating
//         Faculties faculties = new Faculties("Sport",1L,2L);
//         facultiesDAO.update("name",faculties,5L);


                                   //remove
//        facultiesDAO.remove(5L);

                                  //SelectById
//        Faculties faculties = new Faculties();
//        facultiesDAO.getBy(faculties,4L);
//        LOGGER.info(faculties);

                                //SelectAll
//        for (Faculties f: facultiesDAO.getAllFaculties()) {
//            LOGGER.info(f);
//        }


//   ---------------------------------------------Specialties-----------------------------------------------------------

//        SpecialtiesDAO specialtiesDAO = new SpecialtiesDAO();

                                                //insert
//        Specialties specialties = new Specialties("Coach",1L);
//        specialtiesDAO.create(specialties);

                                              //Update
//        Specialties specialties = new Specialties("Business",2L);
//        specialtiesDAO.update("all",specialties,2L);

                                              //remove
//        specialtiesDAO.remove(3L);

                                             //SelectById
//        Specialties specialties = new Specialties();
//        specialtiesDAO.getBy(specialties,1L);
//        LOGGER.info(specialties);

                                            //SelectAll
//        for (Specialties s: specialtiesDAO.getAllSpecialties()) {
//            LOGGER.info(s);
//        }


//------------------------------------------------Subjects--------------------------------------------------------------

//      SubjectsDAO subjectsDAO = new SubjectsDAO();


                                              //inserting

//        Subjects subjects = new Subjects("Programing Language JavaScript",4,1L);
//        subjectsDAO.create(subjects);

                                             //Upadate
//          Subjects subjects = new Subjects("Programing Language C++",1,1L);
//          subjectsDAO.update("course",subjects,2L);


                                           //Remove
//        subjectsDAO.remove(3L);

                                           //SelectById
//        Subjects subjects = new Subjects();
//        subjectsDAO.getBy(subjects,1L);
//        LOGGER.info(subjects);

                                          //SelectAll
//        for (Subjects s: subjectsDAO.getAllSubjects()) {
//            LOGGER.info(s);
//        }


// ---------------------------------------------------------Type_Lectures-----------------------------------------------

//        TypeLecturesDAO typeLecturesDAO = new TypeLecturesDAO();


                                                //inserting

//        TypeLectures typeLectures = new TypeLectures("theoretical",4L,4L);
//        typeLecturesDAO.create(typeLectures);

                                               //Updating
//         TypeLectures typeLectures = new TypeLectures("Practical",4L,4L);
//         typeLecturesDAO.update("type",typeLectures,6L);

                                              //remove
//           typeLecturesDAO.remove(6L);

                                              //SelectById
//          TypeLectures typeLectures =new TypeLectures();
//          typeLecturesDAO.getBy(typeLectures,1L);
//          LOGGER.info(typeLectures);

                                            //SelectAll
//        for (TypeLectures t: typeLecturesDAO.getAllTypeLectures()) {
//            LOGGER.info(t);
//        }


//---------------------------------------------------Type_Specialities--------------------------------------------------


//        TypeSpecialtiesDAO typeSpecialtiesDAO = new TypeSpecialtiesDAO();


                                             //inserting
//        TypeSpecialties typeSpecialties = new TypeSpecialties("Minor",2L,24L);
//        typeSpecialtiesDAO.create(typeSpecialties);

                                           //Updating
//         TypeSpecialties typeSpecialties = new TypeSpecialties("Reader",2L, 24L);
//         typeSpecialtiesDAO.update("all",typeSpecialties,2L);

                                         //remove
//        typeSpecialtiesDAO.remove(3L);

                                         //selectById

//         TypeSpecialties typeSpecialties = new TypeSpecialties();
//         typeSpecialtiesDAO.getBy(typeSpecialties,1L);
//         LOGGER.info(typeSpecialties);

                                       //SelectAll
//        for (TypeSpecialties t: typeSpecialtiesDAO.getAllTypeSpecialties()) {
//            LOGGER.info(t);
//        }


//----------------------------------------------FINISH------------------------------------------------------------------

    }
}
