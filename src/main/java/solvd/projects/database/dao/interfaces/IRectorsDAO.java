package solvd.projects.database.dao.interfaces;

import solvd.projects.database.models.Rectors;

import java.util.List;

public interface IRectorsDAO extends IBaseDAO<Rectors>{
    List<Rectors> getAllRectors();
}
