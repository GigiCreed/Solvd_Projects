package solvd.projects.database.service.mybatis.services.interfacies;

import solvd.projects.database.tableclasses.Students;

import java.util.List;

public interface IStudentServices extends IBaseServices<Students> {
    List<Students> getAllStudents();
}