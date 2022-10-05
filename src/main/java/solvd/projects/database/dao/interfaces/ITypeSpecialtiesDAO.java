package solvd.projects.database.dao.interfaces;

import solvd.projects.database.models.TypeSpecialties;

import java.util.List;

public interface ITypeSpecialtiesDAO extends IBaseDAO<TypeSpecialties> {
    List<TypeSpecialties> getAllTypeSpecialties();
}
