package solvd.projects.database.service.mybatis.mappers;

import solvd.projects.database.tableclasses.Specialties;

import java.util.List;

public interface ISpecialtiesMapper extends IBaseMapper<Specialties>{
    List<Specialties> getALLSpecialties();
}
