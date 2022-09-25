package solvd.projects.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


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
    }
}
