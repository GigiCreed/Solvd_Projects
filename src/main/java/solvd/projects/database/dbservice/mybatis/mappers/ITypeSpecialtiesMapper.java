package solvd.projects.database.dbservice.mybatis.mappers;

import solvd.projects.database.tableclasses.TypeSpecialties;

import java.util.List;

public interface ITypeSpecialtiesMapper extends IBaseMapper<TypeSpecialties> {
    List<TypeSpecialties> getAllTypeSpecialties();
}
