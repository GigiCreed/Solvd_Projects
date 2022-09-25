package solvd.projects.database.dbservices.mybatis.mappers;

import solvd.projects.database.models.Rectors;

import java.util.List;

public interface IRectorsMapper extends IBaseMapper<Rectors> {
    List<Rectors> getAllRectors();
}
