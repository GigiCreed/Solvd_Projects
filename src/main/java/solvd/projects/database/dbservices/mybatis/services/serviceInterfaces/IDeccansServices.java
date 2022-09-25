package solvd.projects.database.dbservices.mybatis.services.serviceInterfaces;

import solvd.projects.database.models.Deccans;

import java.util.List;

public interface IDeccansServices  extends IBaseServices<Deccans> {
    List<Deccans> getAllDeccans();
}
