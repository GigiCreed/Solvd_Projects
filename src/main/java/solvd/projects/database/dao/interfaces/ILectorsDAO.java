package solvd.projects.database.dao.interfaces;

import solvd.projects.database.models.Lectors;

import java.util.List;

public interface ILectorsDAO extends IBaseDAO<Lectors>{
    List<Lectors> getAllLectors();
}
