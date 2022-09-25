package solvd.projects.database.dbservices.jdbc.dao.interfaces;

import solvd.projects.database.models.Students;

import java.util.List;

public interface IStudentsDAO extends IBaseDAO<Students>{
    List<Students> getAllStudents();
}
