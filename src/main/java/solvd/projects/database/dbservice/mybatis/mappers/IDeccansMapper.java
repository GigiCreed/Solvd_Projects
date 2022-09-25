package solvd.projects.database.dbservice.mybatis.mappers;

import solvd.projects.database.tableclasses.Deccans;

import java.util.List;

public interface IDeccansMapper extends IBaseMapper<Deccans> {
    List<Deccans> getAllDeccans();
}
