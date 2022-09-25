package solvd.projects.database.dbservice.mybatis.mappers;

import solvd.projects.database.tableclasses.Faculties;

import java.util.List;

public interface IFacultiesMapper extends IBaseMapper<Faculties> {
    List<Faculties> getAllFaculties();
}
