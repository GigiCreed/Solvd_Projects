package solvd.projects.database.service.mybatis.servicies.interfacies;

import solvd.projects.database.tableclasses.Rectors;

import java.util.List;

public interface IRectorsServices extends IBaseServices<Rectors> {
    List<Rectors> getAllRectors();
}
