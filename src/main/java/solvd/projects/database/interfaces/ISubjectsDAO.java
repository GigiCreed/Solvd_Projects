package solvd.projects.database.interfaces;

import solvd.projects.database.tableclasses.Subjects;

import java.util.List;

public interface ISubjectsDAO extends IBaseDAO<Subjects> {
    List<Subjects> getAllSubjects();
}
