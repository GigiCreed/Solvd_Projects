package solvd.projects.database.dbservice.mybatis.services.serviceInterfaces;

import solvd.projects.database.tableclasses.Subjects;

import java.util.List;

public interface ISubjectsServices extends IBaseServices<Subjects> {
    List<Subjects> getAllSubjects();
}
