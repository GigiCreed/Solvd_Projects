package solvd.projects.database.dao.interfaces;

import solvd.projects.database.models.Faculties;

import java.util.List;

public interface IFacultiesDAO extends IBaseDAO<Faculties> {
    List<Faculties> getAllFaculties();
}
