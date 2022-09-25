package solvd.projects.database.dbservices.jdbc.dao.interfaces;

import solvd.projects.database.models.Faculties;

import java.util.List;

public interface IFacultiesDAO extends IBaseDAO<Faculties> {
    List<Faculties> getAllFaculties();
}
