package solvd.projects.database.mysql.dao.interfaces;

import solvd.projects.database.tableclasses.Students;

import java.util.List;

public interface IStudentsDAO extends IBaseDAO<Students>{
    List<Students> getAllStudents();
}
