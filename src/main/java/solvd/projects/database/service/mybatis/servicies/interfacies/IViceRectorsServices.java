package solvd.projects.database.service.mybatis.servicies.interfacies;

import solvd.projects.database.tableclasses.ViceRectors;

import java.util.List;

public interface IViceRectorsServices extends IBaseServices<ViceRectors> {
    List<IViceRectorsServices> getAllViceRectors();
}
