package solvd.projects.database.dbservice.mybatis.services.serviceInterfaces;

import solvd.projects.database.tableclasses.Lectors;

import java.util.List;

public interface ILectorsServices extends IBaseServices<Lectors> {
    List<Lectors> getAllLectors();
}
