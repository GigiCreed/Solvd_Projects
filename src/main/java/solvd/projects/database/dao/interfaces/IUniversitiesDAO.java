package solvd.projects.database.dao.interfaces;



import solvd.projects.database.models.Universities;

import java.util.List;

public interface IUniversitiesDAO extends IBaseDAO<Universities> {
    List<Universities> getAllUniversities();
}
