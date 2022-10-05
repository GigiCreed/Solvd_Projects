package solvd.projects.database.dao.interfaces;

import solvd.projects.database.models.Deccans;

import java.util.List;

public interface IDeccansDAO extends IBaseDAO<Deccans> {
    List<Deccans> getAllDeccans() ;
}
