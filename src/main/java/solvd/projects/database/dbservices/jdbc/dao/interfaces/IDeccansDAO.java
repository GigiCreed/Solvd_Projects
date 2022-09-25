package solvd.projects.database.dbservices.jdbc.dao.interfaces;

import solvd.projects.database.tableclasses.Deccans;

import java.util.List;

public interface IDeccansDAO extends IBaseDAO<Deccans> {
    List<Deccans> getAllDeccans() ;
}
