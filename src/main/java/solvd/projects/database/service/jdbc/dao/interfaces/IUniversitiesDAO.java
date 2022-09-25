package solvd.projects.database.service.jdbc.dao.interfaces;



import solvd.projects.database.tableclasses.Universities;

import java.util.List;

public interface IUniversitiesDAO extends IBaseDAO<Universities> {
    List<Universities> getAllUniversities();
}
