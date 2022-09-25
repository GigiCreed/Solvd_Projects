package solvd.projects.database.dbservices.jdbc.dao.interfaces;

import solvd.projects.database.tableclasses.TypeSpecialties;

import java.util.List;

public interface ITypeSpecialtiesDAO extends IBaseDAO<TypeSpecialties> {
    List<TypeSpecialties> getAllTypeSpecialties();
}
