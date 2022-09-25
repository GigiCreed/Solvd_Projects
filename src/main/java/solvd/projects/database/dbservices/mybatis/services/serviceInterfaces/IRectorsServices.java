package solvd.projects.database.dbservices.mybatis.services.serviceInterfaces;

import solvd.projects.database.models.Rectors;

import java.util.List;

public interface IRectorsServices extends IBaseServices<Rectors> {
    List<Rectors> getAllRectors();
}
