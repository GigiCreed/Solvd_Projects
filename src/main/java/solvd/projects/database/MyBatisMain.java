package solvd.projects.mybatis;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.service.mybatis.services.UniversitiesService;


public class MyBatisMain {
    private static final Logger LOGGER = LogManager.getLogger(MyBatisMain.class);
    public static void main(String[] args) {

//        StudentsServices studentsServices = new StudentsServices();
//        Students students = new Students("Gigi","mamaladze", new Date(100000002323L),555,555,"sdsd",1L,1L);
//        studentsServices.insert(students);


//-------------------------------------------------Universities---------------------------------------------------------

        UniversitiesService universitiesService = new UniversitiesService();

        //selectAll
        LOGGER.info(universitiesService.getAllUniversities());

        //insert
//        Universities universities = new Universities("JDS","sds","sdsd","sdsd");
//        universitiesService.insert(universities);

        //getById
//        Universities universities = universitiesService.getById(1L);
//        LOGGER.info(universities);

        //Update
//        Universities universities = new Universities("Bsu","Batumi","BsuPortal.com","Bsu@gmail.com");
//        universitiesService.update(universities,1L);

        //delete
//        universitiesService.delete(4L);

    }
}
