package solvd.projects.database.dbservices.mybatis.services.serviceInterfaces;

import solvd.projects.database.models.Universities;

import java.util.List;

public interface IUniversitiesServices extends IBaseServices<Universities>{
    List<Universities> getAllUniversities();
}
