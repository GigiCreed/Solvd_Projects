package solvd.projects.database.service.jdbc.dao.interfaces;

import solvd.projects.database.tableclasses.Rectors;

import java.util.List;

public interface IRectorsDAO extends IBaseDAO<Rectors>{
    List<Rectors> getAllRectors();
}
