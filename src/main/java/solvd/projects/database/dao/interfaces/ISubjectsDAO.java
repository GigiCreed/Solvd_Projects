package solvd.projects.database.dao.interfaces;

import solvd.projects.database.models.Subjects;

import java.util.List;

public interface ISubjectsDAO extends IBaseDAO<Subjects> {
    List<Subjects> getAllSubjects();
}
