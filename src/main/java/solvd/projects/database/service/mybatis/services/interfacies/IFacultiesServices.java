package solvd.projects.database.service.mybatis.services.interfacies;

import solvd.projects.database.tableclasses.Faculties;

import java.util.List;

public interface IFacultiesServices extends IBaseServices<Faculties> {
    List<Faculties> getAllFaculties();
}
