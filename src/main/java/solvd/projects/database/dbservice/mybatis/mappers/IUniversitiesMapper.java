package solvd.projects.database.dbservice.mybatis.mappers;

import solvd.projects.database.tableclasses.Universities;

import java.util.List;

public interface IUniversitiesMapper extends IBaseMapper<Universities> {
    List<Universities> getAllUniversities();
}
