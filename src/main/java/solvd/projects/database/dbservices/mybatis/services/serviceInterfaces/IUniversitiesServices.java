package solvd.projects.database.dbservices.mybatis.services.serviceInterfaces;

import solvd.projects.database.tableclasses.Universities;

import java.util.List;

public interface IUniversitiesServices extends IBaseServices<Universities>{
    List<Universities> getAllUniversities();
}
