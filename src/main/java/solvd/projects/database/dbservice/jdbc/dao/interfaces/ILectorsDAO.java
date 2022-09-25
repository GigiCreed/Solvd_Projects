package solvd.projects.database.dbservice.jdbc.dao.interfaces;

import solvd.projects.database.tableclasses.Lectors;

import java.util.List;

public interface ILectorsDAO extends IBaseDAO<Lectors>{
    List<Lectors> getAllLectors();
}
