package solvd.projects.database.dbservices.mybatis.mappers;

import solvd.projects.database.models.ViceRectors;

import java.util.List;

public interface IViceRectorsMapper extends IBaseMapper<ViceRectors> {
    List<ViceRectors> getAllViceRectors();
}
