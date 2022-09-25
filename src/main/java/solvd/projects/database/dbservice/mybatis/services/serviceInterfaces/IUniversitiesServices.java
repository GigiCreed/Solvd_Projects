package solvd.projects.database.dbservice.mybatis.services.serviceInterfaces;

import solvd.projects.database.tableclasses.Universities;

import java.util.List;

public interface IUniversitiesServices extends IBaseServices<Universities>{
    List<Universities> getAllUniversities();
}
