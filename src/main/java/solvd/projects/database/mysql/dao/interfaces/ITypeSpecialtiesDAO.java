package solvd.projects.database.mysql.dao.interfaces;

import solvd.projects.database.tableclasses.TypeSpecialties;

import java.util.List;

public interface ITypeSpecialtiesDAO extends IBaseDAO<TypeSpecialties> {
    List<TypeSpecialties> getAllTypeSpecialties();
}
