package solvd.projects.database.service.mybatis.mappers;

import solvd.projects.database.tableclasses.Faculties;

import java.util.List;

public interface IFacultiesMapper extends IBaseMapper<Faculties> {
    List<Faculties> getAllFaculties();
}
