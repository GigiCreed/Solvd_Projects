package solvd.projects.database.service.mybatis.services.interfacies;

import solvd.projects.database.tableclasses.Deccans;

import java.util.List;

public interface IDeccansServices  extends IBaseServices<Deccans> {
    List<Deccans> getAllDeccans();
}
