package solvd.projects.database.dbservices.mybatis.mappers;

import solvd.projects.database.models.Lectors;

import java.util.List;

public interface ILectorsMapper extends IBaseMapper<Lectors> {
    List<Lectors> getAllLectors();
}
