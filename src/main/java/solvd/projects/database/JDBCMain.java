package solvd.projects.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.dao.jdbc.*;
import solvd.projects.database.models.*;

import java.sql.Date;

public class JDBCMain {
    private static final Logger LOGGER = LogManager.getLogger(JDBCMain.class);
    public static void main(String[] args) {

// --------------------------------------------Students----------------------------------------------------------------

//        StudentsDAO studentsDAO = new StudentsDAO();
//
//                                     SelectById
//     Students students = studentsDAO.getById(1L);
//     LOGGER.info(students);

//
//                                        INSERT
//      Students students1 = new Students("Nika","iremadze",new Date(1014076800000L),55555,3,"sds",1L,2L);
//      studentsDAO.insert(students1);
//                                        REMOVE
//     studentsDAO.delete(27L);
//                                        Update
//     Students forUpdate = new Students(1L,"Rezo","Xuchua",new Date(10140768000000L),14141414,7,"ffffff",1L,2L);
//     studentsDAO.update(forUpdate);

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

//         Rectors rectors = rectorsDAO.getById(1L);
//         LOGGER.info(rectors);


                                    //Insert

//        Rectors rectors = new Rectors("irakli","rodinadze", new Date(1028833200000L),5555,"tamarMefisdasaxleba","tina@gmail.com",3L);
//        rectorsDAO.insert(rectors);

                                  //Delete

//           rectorsDAO.delete(9L);

                                //update

//        Rectors rectors = new Rectors(3L,"Tinatin","Rodinadze",new Date(1028833200000L),599281101,"Tamar Mefis dasaxelba", "Tiniko@gmail.com",3L);
//        rectorsDAO.update(rectors);




// -----------------------------------------------Vice_rectors----------------------------------------------------------

//        ViceRectorsDAO viceRectorsDAO =new ViceRectorsDAO();

                                                //insert

//        ViceRectors viceRectors = new ViceRectors("Lela","turnamindze",new Date(232323321456L),55123,"batumi","lela@gmail.com",3L);
//        viceRectorsDAO.insert(viceRectors);


                                              //Update
//        ViceRectors viceRectors = new ViceRectors(6L,"Nino","iremadze",new Date(232323321456L),11111,"batumius","nino@gmail.com",3L);
//        viceRectorsDAO.update(viceRectors);


                                             //Delete
//        viceRectorsDAO.delete(6L);

                                            //SelectById
//        ViceRectors viceRectors =viceRectorsDAO.getById(1L);
//        LOGGER.info(viceRectors);

                                           //SelectALL
//        for (ViceRectors o:viceRectorsDAO.getAllViceRectors()) {
//            LOGGER.info(o);
//        }


//  -----------------------------------------Universities---------------------------------------------------------------

//        UniversitiesDAO universitiesDAO = new UniversitiesDAO();

                                            //Insert
//        Universities universities =new Universities("Tsu","tbilisi","tsu.com","tsu@gmail.com");
//        universitiesDAO.insert(universities);

                                           //Update

//          Universities universities = new Universities(5L,"BTU","tbilisi","BTU.com","BTU@gmail.com");
//          universitiesDAO.update(universities);

                                          //Remove
//            universitiesDAO.delete(2L);

                                          //SelectBy
//        Universities universities =universitiesDAO.getById(1L);
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
//        lectorsDAO.insert(lectors);

                                           //Update

//          Lectors lectors = new Lectors(1L,"Cicino","sarajishvili",new Date(232323321456L),00001,"Batumi","cicino@gmail.com",1L);
//          lectorsDAO.update(lectors);

                                         //Delete
//            lectorsDAO.delete(3L);

                                         //SelectById
//        Lectors lectors = lectorsDAO.getById(1L);
//        LOGGER.info(lectors);

                                      //SelectALL
//        for (Lectors l:lectorsDAO.getAllLectors()) {
//            LOGGER.info(l);
//        }


// -----------------------------------------Deccans----------------------------------------------------------------------

//   DeccansDAO deccansDAO = new DeccansDAO();

                                       //Insert
//        Deccans deccans = new Deccans("lasha","turmanidze",new Date(232323321456L),"batumi",444444,"giorgi@gmail.com",1L);
//        deccansDAO.insert(deccans);


                                     //Remove
//        deccansDAO.delete(5L);

                                    //Update
//        Deccans deccans = new Deccans(2L,"Gigi","Mamaladze",new Date(232323321456L),"batumi",7777777,"Luka@gmail.com",1L);
//        deccansDAO.update(deccans);

                                    //SelectById

//        Deccans deccans = deccansDAO.getById(1L);
//        LOGGER.info(deccans);

                                 //SelectAll
//        for (Deccans d:deccansDAO.getAllDeccans()) {
//            LOGGER.info(d);
//        }


//-------------------------------------------Faculties----------------------------------------------------------------------

//         FacultiesDAO facultiesDAO = new FacultiesDAO();

                                       //inserting
//        Faculties faculties = new Faculties("Medicine",1L,1L);
//        facultiesDAO.insert(faculties);

                                      //Updating
//         Faculties faculties = new Faculties(2L,"Sport",1L,2L);
//         facultiesDAO.update(faculties);


                                   //remove
//        facultiesDAO.delete(5L);

                                  //SelectById
//        Faculties faculties = facultiesDAO.getById(1L);
//        LOGGER.info(faculties);


                                //SelectAll
//        for (Faculties f: facultiesDAO.getAllFaculties()) {
//            LOGGER.info(f);
//        }


//   ---------------------------------------------Specialties-----------------------------------------------------------

//        SpecialtiesDAO specialtiesDAO = new SpecialtiesDAO();

                                                //insert
//        Specialties specialties = new Specialties("Coach",1L);
//        specialtiesDAO.insert(specialties);

                                              //Update
//        Specialties specialties = new Specialties(1L,"Computer Science",1L);
//        specialtiesDAO.update(specialties);

                                              //remove
//        specialtiesDAO.delete(3L);

                                             //SelectById
//        Specialties specialties = specialtiesDAO.getById(1L);
//        LOGGER.info(specialties);

                                            //SelectAll
//        for (Specialties s: specialtiesDAO.getAllSpecialties()) {
//            LOGGER.info(s);
//        }


//------------------------------------------------Subjects--------------------------------------------------------------

//      SubjectsDAO subjectsDAO = new SubjectsDAO();


                                              //inserting

//        Subjects subjects = new Subjects("Programing Language JavaScript",4,1L);
//        subjectsDAO.insert(subjects);

                                             //Upadate
//          Subjects subjects = new Subjects(1L,"Programing Language C++",1,1L);
//          subjectsDAO.update(subjects);


                                           //Remove
//        subjectsDAO.delete(3L);

                                           //SelectById
//        Subjects subjects = subjectsDAO.getById(1L);
//        LOGGER.info(subjects);


                                          //SelectAll
//        for (Subjects s: subjectsDAO.getAllSubjects()) {
//            LOGGER.info(s);
//        }


// ---------------------------------------------------------Type_Lectures-----------------------------------------------

//        TypeLecturesDAO typeLecturesDAO = new TypeLecturesDAO();


                                                //inserting

//        TypeLectures typeLectures = new TypeLectures("theoretical",4L,4L);
//        typeLecturesDAO.insert(typeLectures);

                                               //Updating
//         TypeLectures typeLectures = new TypeLectures(1L,"Practical",4L,4L);
//         typeLecturesDAO.update(typeLectures);

                                              //remove
//           typeLecturesDAO.delete(6L);

                                              //SelectById
//          TypeLectures typeLectures =typeLecturesDAO.getById(1L);
//          LOGGER.info(typeLectures);

                                            //SelectAll
//        for (TypeLectures t: typeLecturesDAO.getAllTypeLectures()) {
//            LOGGER.info(t);
//        }


//---------------------------------------------------Type_Specialities--------------------------------------------------


//        TypeSpecialtiesDAO typeSpecialtiesDAO = new TypeSpecialtiesDAO();


                                             //inserting
//        TypeSpecialties typeSpecialties = new TypeSpecialties("Minor",2L,24L);
//        typeSpecialtiesDAO.insert(typeSpecialties);

                                           //Updating
//         TypeSpecialties typeSpecialties = new TypeSpecialties("Reader",2L, 24L);
//         typeSpecialtiesDAO.update(typeSpecialties);

                                         //remove
//        typeSpecialtiesDAO.delete(3L);

                                         //selectById

//         TypeSpecialties typeSpecialties = typeSpecialtiesDAO.getById(1L);
//         LOGGER.info(typeSpecialties);

                                       //SelectAll
//        for (TypeSpecialties t: typeSpecialtiesDAO.getAllTypeSpecialties()) {
//            LOGGER.info(t);
//        }


//----------------------------------------------FINISH------------------------------------------------------------------

    }
}
