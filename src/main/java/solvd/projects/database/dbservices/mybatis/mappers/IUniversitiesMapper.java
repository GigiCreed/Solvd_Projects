package solvd.projects.database.dbservices.mybatis.mappers;

import solvd.projects.database.models.Universities;

import java.util.List;

public interface IUniversitiesMapper extends IBaseMapper<Universities> {
    List<Universities> getAllUniversities();
}
