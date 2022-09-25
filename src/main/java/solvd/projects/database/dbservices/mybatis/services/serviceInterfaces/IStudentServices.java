package solvd.projects.database.dbservices.mybatis.services.serviceInterfaces;

import solvd.projects.database.tableclasses.Students;

import java.util.List;

public interface IStudentServices extends IBaseServices<Students> {
    List<Students> getAllStudents();
}