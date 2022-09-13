package solvd.projects.database.mysql.dao.interfaces;

import solvd.projects.database.tableclasses.Deccans;

import java.util.List;

public interface IDeccansDAO extends IBaseDAO<Deccans> {
    List<Deccans> getAllDeccans();
}
