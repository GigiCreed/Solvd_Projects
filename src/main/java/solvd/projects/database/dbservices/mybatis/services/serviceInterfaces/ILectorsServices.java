package solvd.projects.database.dbservices.mybatis.services.serviceInterfaces;

import solvd.projects.database.models.Lectors;

import java.util.List;

public interface ILectorsServices extends IBaseServices<Lectors> {
    List<Lectors> getAllLectors();
}
