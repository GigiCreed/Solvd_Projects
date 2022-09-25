package solvd.projects.database.service.mybatis.services.interfacies;

import solvd.projects.database.tableclasses.Lectors;

import java.util.List;

public interface ILectorsServices extends IBaseServices<Lectors> {
    List<Lectors> getAllLectors();
}
