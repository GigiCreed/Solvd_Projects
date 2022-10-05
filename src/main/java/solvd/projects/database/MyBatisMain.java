package solvd.projects.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.dao.mybatis.*;
import solvd.projects.database.models.*;


public class MyBatisMain {
    private static final Logger LOGGER = LogManager.getLogger(MyBatisMain.class);
    public static void main(String[] args) {

//------------------------------------------------Students--------------------------------------------------------------

//        StudentsDAO studentsDAO = new StudentsDAO();

           //insert
//        Students students = new Students("Niako","mamaladze", new Date(100000002323L),555,555,"sdsd",1L,1L);
//        studentsDAO.insert(students);

           //getById
//         Students students = studentsDAO.getById(1L);
//         LOGGER.info(students);

          //SelectAll
//        for (Students students:studentsDAO.getAllStudents()) {
//            LOGGER.info(students);
//        }

          //Update
//        Students students = new Students("Dima","mamaladze", new Date(100000002323L),555,555,"sdsd",1L,1L);
//        studentsServices.update(students,12L);

          //Delete
//          studentsServices.delete(8L);

//-------------------------------------------------Universities---------------------------------------------------------

//        UniversitiesDAO universitiesService = new UniversitiesDAO();

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



//------------------------------------------------Rectors---------------------------------------------------------------
//        RectorsDAO rectorsServices = new RectorsDAO();

        //SelectByid
//        Rectors rectors = rectorsServices.getById(1L);
//        LOGGER.info(rectors);

        //SelectAll
//        for (Rectors r:rectorsServices.getAllRectors()) {
//            LOGGER.info(r);
//        }

        //Insert
//        Rectors rectors = new Rectors("Mari","kvach",new Date(100000000785L),555,"batumi","sdsd",5L);
//        rectorsServices.insert(rectors);

        //Update
//        Rectors rectors = new Rectors("Rita","kvach",new Date(100000000785L),555,"batumi","sdsd",5L);
//        rectorsServices.update(rectors,5L);

        //Delete
//        rectorsServices.delete(5L);


//------------------------------------------------ViceRectors-----------------------------------------------------------
//         ViceRectorsDAO viceRectorsServices = new ViceRectorsDAO();

         //Select All
//        for (ViceRectors v : viceRectorsServices.getAllViceRectors()) {
//            LOGGER.info(v);
//        }

        //insert
//        ViceRectors viceRectors = new ViceRectors("dima","primudro",new Date(13221312313L),55,"sdsd","sdsd",5L);
//        viceRectorsServices.insert(viceRectors);

        //SelectById
//        ViceRectors viceRectors =viceRectorsServices.getById(1L);
//        LOGGER.info(viceRectors);

        //update
//        ViceRectors viceRectors = new ViceRectors("Dima","primudro",new Date(13221312313L),55,"sdsd","sdsd",5L);
//        viceRectorsServices.update(viceRectors,5L);

        //Delete
//        viceRectorsServices.delete(4L);


//-------------------------------------------Deccans--------------------------------------------------------------------
//           DeccansDAO deccansServices = new DeccansDAO();

          //selectAll
//        for (Deccans d: deccansServices.getAllDeccans()) {
//            LOGGER.info(d);
//        }

        //SelectById
//        Deccans deccans = deccansServices.getById(1L);
//        LOGGER.info(deccans);

        //insert
//         Deccans deccans = new Deccans("Tina","rodinadze",new Date(10000000000000L),"Sdsds",55,"Sdsdsd@gmail.com",1L);
//         deccansServices.insert(deccans);

        //Update
//        Deccans deccans = new Deccans("Tiniko","rodinadze",new Date(10000000000000L),"Sdsds",55,"Sdsdsd@gmail.com",1L);
//        deccansServices.update(deccans,6L);

        //Delete
//         deccansServices.delete(6L);


//----------------------------------------------Lectors-------------------------------------------------------------------

//        LectorsDAO lectorsServices = new LectorsDAO();

        //insert
//        Lectors lectors3 = new Lectors("Nika","kvach",new Date(100000000785L),555,"batumi","sdsd",1L);
//        lectorsServices.insert(lectors3);

        //SelectAll
//        for (Lectors l:lectorsServices.getAllLectors()) {
//            LOGGER.info(l);
//        }

        //SelectById
//        Lectors lectors =lectorsServices.getById(1L);
//        LOGGER.info(lectors);

        //Update
//        Lectors lectors = new Lectors("Luka","kvach",new Date(100000000785L),555,"batumi","sdsd",1L);
//        lectorsServices.update(lectors,1L);

        //Delete
//        lectorsServices.delete(3L);


//----------------------------------------------Faculties---------------------------------------------------------------
//        FacultiesDAO facultiesServices = new FacultiesDAO();

        //select All
//        for (Faculties f:facultiesServices.getAllFaculties()) {
//            LOGGER.info(f);
//        }

        //insert
//        Faculties faculties = new Faculties("sdsd",1L,null);
//        facultiesServices.insert(faculties);

        //update
//        Faculties faculties = new Faculties("I don't know What",1L,null);
//        facultiesServices.update(faculties,5L);

        //Delete
//        facultiesServices.delete(5L);


//------------------------------------------Specialties-----------------------------------------------------------------
//        SpecialtiesDAO specialtiesServices = new SpecialtiesDAO();

        //insert
//        Specialties specialties = new Specialties("Business",2L);
//        specialtiesServices.insert(specialties);

        //update
//        Specialties specialties = new Specialties("Economic",2L);
//        specialtiesServices.update(specialties,2L);

        //SelectByid
//        Specialties specialties = specialtiesServices.getById(1L);
//        LOGGER.info(specialties);

        //SelectAll
//        for (Specialties s : specialtiesServices.getAllSpecialties()) {
//            LOGGER.info(s);
//        }

        //remove
//        specialtiesServices.delete(2L);

//------------------------------------------------Subjects--------------------------------------------------------------
//            SubjectsDAO subjectsServices = new SubjectsDAO();

         //insert
//        Subjects subjects = new Subjects("C#",3,1L);
//        subjectsServices.insert(subjects);

        //Update
//        Subjects subjects = new Subjects("Java",3,1L);
//        subjectsServices.update(subjects,2L);

        //SelectById
//        Subjects subjects = subjectsServices.getById(1L);
//        LOGGER.info(subjects);

        //SelectALL
//        for (Subjects s: subjectsServices.getAllSubjects()) {
//            LOGGER.info(s);
//        }

        //Delete
//        subjectsServices.delete(2L);

//---------------------------------------------TypeLectures-------------------------------------------------------------

//        TypeLecturesDAO typeLecturesServices = new TypeLecturesDAO();


        //insert
//        TypeLectures typeLectures = new TypeLectures("teoritical",1L,1L);
//        typeLecturesServices.insert(typeLectures);


        //Update
//        TypeLectures typeLectures = new TypeLectures("Practical",1L,1L);
//        typeLecturesServices.update(typeLectures,1L);

        //GetByid
//        TypeLectures typeLectures = typeLecturesServices.getById(1L);
//        LOGGER.info(typeLectures);

        //SelectAll
//        for (TypeLectures t: typeLecturesServices.getAllTypeLectures()) {
//            LOGGER.info(t);
//        }

        //delete
//        typeLecturesServices.delete(1L);

//------------------------------------------------------------Finish----------------------------------------------------

    }
}
