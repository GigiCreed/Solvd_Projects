package solvd.projects.database.interfaces;

import solvd.projects.database.tableclasses.ViceRectors;

import java.util.List;

public interface IViceRectorsDAO extends IBaseDAO<ViceRectors> {
    List<ViceRectors> getAllViceRectors();
}
