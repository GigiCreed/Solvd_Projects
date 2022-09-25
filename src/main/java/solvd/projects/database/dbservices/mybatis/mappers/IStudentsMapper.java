package solvd.projects.database.dbservices.mybatis.mappers;

import solvd.projects.database.models.Students;

import java.util.List;

public interface IStudentsMapper extends IBaseMapper<Students> {
    List<Students> getAllStudents();
}
