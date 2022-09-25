package solvd.projects.database.dbservice.mybatis.mappers;

import solvd.projects.database.tableclasses.Specialties;

import java.util.List;

public interface ISpecialtiesMapper extends IBaseMapper<Specialties>{
    List<Specialties> getALLSpecialties();
}
