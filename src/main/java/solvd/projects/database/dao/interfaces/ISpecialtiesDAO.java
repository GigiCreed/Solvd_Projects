package solvd.projects.database.dao.interfaces;

import solvd.projects.database.models.Specialties;

import java.util.List;

public interface ISpecialtiesDAO extends IBaseDAO<Specialties> {
    List<Specialties> getAllSpecialties();
}
