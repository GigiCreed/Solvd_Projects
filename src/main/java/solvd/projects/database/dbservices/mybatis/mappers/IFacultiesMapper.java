package solvd.projects.database.dbservices.mybatis.mappers;

import solvd.projects.database.models.Faculties;

import java.util.List;

public interface IFacultiesMapper extends IBaseMapper<Faculties> {
    List<Faculties> getAllFaculties();
}
