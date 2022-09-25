package solvd.projects.database.dbservices.mybatis.mappers;

import solvd.projects.database.models.Deccans;

import java.util.List;

public interface IDeccansMapper extends IBaseMapper<Deccans> {
    List<Deccans> getAllDeccans();
}
