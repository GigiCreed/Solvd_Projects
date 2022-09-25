package solvd.projects.database.dbservices.mybatis.mappers;

import solvd.projects.database.models.Specialties;

import java.util.List;

public interface ISpecialtiesMapper extends IBaseMapper<Specialties>{
    List<Specialties> getALLSpecialties();
}
