package solvd.projects.database.dbservices.mybatis.mappers;

import solvd.projects.database.models.Subjects;

import java.util.List;

public interface ISubjectsMapper extends IBaseMapper<Subjects> {
    List<Subjects> getAllSubjects();
}
