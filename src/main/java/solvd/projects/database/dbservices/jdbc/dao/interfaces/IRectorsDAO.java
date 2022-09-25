package solvd.projects.database.dbservices.jdbc.dao.interfaces;

import solvd.projects.database.models.Rectors;

import java.util.List;

public interface IRectorsDAO extends IBaseDAO<Rectors>{
    List<Rectors> getAllRectors();
}
