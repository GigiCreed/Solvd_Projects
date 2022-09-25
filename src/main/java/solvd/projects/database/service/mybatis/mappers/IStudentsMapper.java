package solvd.projects.database.service.mybatis.mappers;

import solvd.projects.database.tableclasses.Students;

import java.util.List;

public interface IStudentsMapper extends IBaseMapper<Students> {
    List<Students> getAllStudents();
}
