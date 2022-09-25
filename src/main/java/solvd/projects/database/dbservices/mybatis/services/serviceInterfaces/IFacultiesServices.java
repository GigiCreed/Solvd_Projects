package solvd.projects.database.dbservices.mybatis.services.serviceInterfaces;

import solvd.projects.database.tableclasses.Faculties;

import java.util.List;

public interface IFacultiesServices extends IBaseServices<Faculties> {
    List<Faculties> getAllFaculties();
}
