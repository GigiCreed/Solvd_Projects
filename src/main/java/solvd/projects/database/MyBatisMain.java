package solvd.projects.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.dbservices.mybatis.services.*;
import solvd.projects.database.models.*;

import java.sql.Date;


public class MyBatisMain {
    private static final Logger LOGGER = LogManager.getLogger(MyBatisMain.class);
    public static void main(String[] args) {

//------------------------------------------------Students--------------------------------------------------------------

//        StudentsServices studentsServices = new StudentsServices();

           //insert
//        Students students = new Students("LUka","mamaladze", new Date(100000002323L),555,555,"sdsd",1L,1L);
//        studentsServices.insert(students);

           //getById
//         Students students = studentsServices.getById(1L);
//         LOGGER.info(students);

          //SelectAll
//        for (Students students:studentsServices.getAllStudents()) {
//            LOGGER.info(students);
//        }

          //Update
//        Students students = new Students("Dima","mamaladze", new Date(100000002323L),555,555,"sdsd",1L,1L);
//        studentsServices.update(students,12L);

          //Delete
//          studentsServices.delete(8L);

//-------------------------------------------------Universities---------------------------------------------------------

//        UniversitiesService universitiesService = new UniversitiesService();

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
//        RectorsServices rectorsServices = new RectorsServices();

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
//         ViceRectorsServices viceRectorsServices = new ViceRectorsServices();

         //Select All
//        for (ViceRectors v : viceRectorsServices.getAllViceRectors()) {
//            LOGGER.info(v);
//        }

        //insert
//        ViceRectors viceRectors = new ViceRectors("dima","primudro",new Date(13221312313L),55,"sdsd","sdsd",5L);
//        viceRectorsServices.insert(viceRectors);

        //getById
//        ViceRectors viceRectors =viceRectorsServices.getById(1L);
//        LOGGER.info(viceRectors);

        //update
//        ViceRectors viceRectors = new ViceRectors("Dima","primudro",new Date(13221312313L),55,"sdsd","sdsd",5L);
//        viceRectorsServices.update(viceRectors,5L);

        //Delete
//        viceRectorsServices.delete(4L);


//-------------------------------------------Deccans--------------------------------------------------------------------
//           DeccansServices deccansServices = new DeccansServices();

          //selectAll
//        for (Deccans d: deccansServices.getAllDeccans()) {
//            LOGGER.info(d);
//        }

        //ById
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

        LectorsServices lectorsServices = new LectorsServices();

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
//        FacultiesServices facultiesServices = new FacultiesServices();

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


//------------------------------------------Specialties------------------------------------------------------------------

    }
}
