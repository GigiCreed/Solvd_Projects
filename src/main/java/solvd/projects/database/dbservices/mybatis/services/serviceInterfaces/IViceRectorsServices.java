package solvd.projects.database.dbservices.mybatis.services.serviceInterfaces;

import solvd.projects.database.tableclasses.ViceRectors;

import java.util.List;

public interface IViceRectorsServices extends IBaseServices<ViceRectors> {
    List<IViceRectorsServices> getAllViceRectors();
}
