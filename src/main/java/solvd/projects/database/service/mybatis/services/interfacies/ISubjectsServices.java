package solvd.projects.database.service.mybatis.services.interfacies;

import solvd.projects.database.tableclasses.Subjects;

import java.util.List;

public interface ISubjectsServices extends IBaseServices<Subjects> {
    List<Subjects> getAllSubjects();
}
