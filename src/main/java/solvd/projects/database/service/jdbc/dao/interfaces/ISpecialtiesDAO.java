package solvd.projects.database.service.jdbc.dao.interfaces;

import solvd.projects.database.tableclasses.Specialties;

import java.util.List;

public interface ISpecialtiesDAO extends IBaseDAO<Specialties> {
    List<Specialties> getAllSpecialties();
}
