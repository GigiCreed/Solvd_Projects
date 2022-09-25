package solvd.projects.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.service.jdbc.dao.*;
import solvd.projects.database.tableclasses.*;

public class Service {
    private static  final Logger LOGGER = LogManager.getLogger(Service.class);
    public static void main(String[] args) {

        UniversitiesDAO universitiesDAO = new UniversitiesDAO();
        StudentsDAO studentsDAO = new StudentsDAO();
        FacultiesDAO facultiesDAO = new FacultiesDAO();
        LectorsDAO lectorsDAO = new LectorsDAO();
        SubjectsDAO subjectsDAO = new SubjectsDAO();
        SpecialtiesDAO specialtiesDAO = new SpecialtiesDAO();
        DeccansDAO deccansDAO = new DeccansDAO();

        Universities universities = new Universities();
        universitiesDAO.getBy(universities,1L);

        Students students = new Students();
        studentsDAO.getBy(students,1L);

        Faculties faculties = new Faculties();
        facultiesDAO.getBy(faculties,1L);

        Lectors lectors = new Lectors();
        lectorsDAO.getBy(lectors,1L);

        Subjects subjects = new Subjects();
        subjectsDAO.getBy(subjects,1L);

        Specialties specialties = new Specialties();
        specialtiesDAO.getBy(specialties,1L);

        Deccans deccans = new Deccans();
        deccansDAO.getBy(deccans,1L);

        LOGGER.info(universities);
        LOGGER.info(students);
        LOGGER.info(faculties);
        LOGGER.info(lectors);
        LOGGER.info(subjects);
        LOGGER.info(specialties);
        LOGGER.info(deccans);

    }
}
