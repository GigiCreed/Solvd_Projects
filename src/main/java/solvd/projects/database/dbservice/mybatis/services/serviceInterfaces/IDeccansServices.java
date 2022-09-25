package solvd.projects.database.dbservice.mybatis.services.serviceInterfaces;

import solvd.projects.database.tableclasses.Deccans;

import java.util.List;

public interface IDeccansServices  extends IBaseServices<Deccans> {
    List<Deccans> getAllDeccans();
}
