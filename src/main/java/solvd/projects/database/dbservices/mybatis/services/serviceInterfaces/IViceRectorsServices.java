package solvd.projects.database.dbservices.mybatis.services.serviceInterfaces;

import solvd.projects.database.models.ViceRectors;

import java.util.List;

public interface IViceRectorsServices extends IBaseServices<ViceRectors> {
    List<ViceRectors> getAllViceRectors();
}
