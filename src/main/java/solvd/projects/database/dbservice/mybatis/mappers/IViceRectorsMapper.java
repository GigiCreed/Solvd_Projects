package solvd.projects.database.dbservice.mybatis.mappers;

import solvd.projects.database.tableclasses.ViceRectors;

import java.util.List;

public interface IViceRectorsMapper extends IBaseMapper<ViceRectors> {
    List<ViceRectors> getAllViceRectors();
}
