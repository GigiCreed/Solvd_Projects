package solvd.projects.database.dbservices.mybatis.services.serviceInterfaces;

import solvd.projects.database.tableclasses.TypeSpecialties;

import java.util.List;

public interface ITypeSpecialtiesServices extends IBaseServices<TypeSpecialties> {
    List<TypeSpecialties> getAllTypeSpecialties();
}
