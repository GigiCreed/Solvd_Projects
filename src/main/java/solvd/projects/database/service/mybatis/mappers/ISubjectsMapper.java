package solvd.projects.database.service.mybatis.mappers;

import solvd.projects.database.tableclasses.Subjects;

import java.util.List;

public interface ISubjectsMapper extends IBaseMapper<Subjects> {
    List<Subjects> getAllSubjects();
}
