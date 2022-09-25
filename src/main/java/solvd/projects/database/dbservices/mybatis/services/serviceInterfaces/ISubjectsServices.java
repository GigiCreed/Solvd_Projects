package solvd.projects.database.dbservices.mybatis.services.serviceInterfaces;

import solvd.projects.database.models.Subjects;

import java.util.List;

public interface ISubjectsServices extends IBaseServices<Subjects> {
    List<Subjects> getAllSubjects();
}
