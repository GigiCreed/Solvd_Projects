package solvd.projects.database.dbservices.jdbc.dao.interfaces;

import solvd.projects.database.tableclasses.ViceRectors;

import java.util.List;

public interface IViceRectorsDAO extends IBaseDAO<ViceRectors> {
    List<ViceRectors> getAllViceRectors();
}
