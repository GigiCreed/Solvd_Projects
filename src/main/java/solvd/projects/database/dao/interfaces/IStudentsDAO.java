package solvd.projects.database.dao.interfaces;

import solvd.projects.database.models.Students;

import java.util.List;

public interface IStudentsDAO extends IBaseDAO<Students>{
    List<Students> getAllStudents();
}
