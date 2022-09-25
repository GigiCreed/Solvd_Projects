package solvd.projects.database.dbservices.mybatis.mappers;

import solvd.projects.database.tableclasses.Rectors;

import java.util.List;

public interface IRectorsMapper extends IBaseMapper<Rectors> {
    List<Rectors> getAllRectors();
}
