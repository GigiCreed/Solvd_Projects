package solvd.projects.database.service.mybatis.mappers;

import solvd.projects.database.tableclasses.Lectors;

import java.util.List;

public interface ILectorsMapper extends IBaseMapper<Lectors> {
    List<Lectors> getAllLectors();
}
