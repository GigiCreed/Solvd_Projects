package solvd.projects.database.dbservice.mybatis.services.serviceInterfaces;

import solvd.projects.database.tableclasses.TypeSpecialties;

import java.util.List;

public interface ITypeSpecialtiesServices extends IBaseServices<TypeSpecialties> {
    List<TypeSpecialties> getAllTypeSpecialties();
}
