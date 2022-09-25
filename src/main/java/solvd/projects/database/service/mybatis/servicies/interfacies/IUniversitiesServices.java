package solvd.projects.database.service.mybatis.servicies.interfacies;

import solvd.projects.database.tableclasses.Universities;

import java.util.List;

public interface IUniversitiesServices extends IBaseServices<Universities>{
    List<Universities> getAllUniversities();
}
