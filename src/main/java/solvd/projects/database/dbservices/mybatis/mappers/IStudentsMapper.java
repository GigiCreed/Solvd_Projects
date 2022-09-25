package solvd.projects.database.dbservices.mybatis.mappers;

import solvd.projects.database.tableclasses.Students;

import java.util.List;

public interface IStudentsMapper extends IBaseMapper<Students> {
    List<Students> getAllStudents();
}
