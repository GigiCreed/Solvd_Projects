package solvd.projects.database.dbservices.mybatis.services.serviceInterfaces;

import solvd.projects.database.models.TypeSpecialties;

import java.util.List;

public interface ITypeSpecialtiesServices extends IBaseServices<TypeSpecialties> {
    List<TypeSpecialties> getAllTypeSpecialties();
}
