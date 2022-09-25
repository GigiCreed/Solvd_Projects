package solvd.projects.database.service.mybatis.servicies.interfacies;

import solvd.projects.database.tableclasses.Students;

import java.util.List;

public interface IStudentServices extends IBaseService<Students> {
    List<Students> getAllStudents();
}