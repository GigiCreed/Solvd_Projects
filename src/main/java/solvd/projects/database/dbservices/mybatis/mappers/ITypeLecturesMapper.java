package solvd.projects.database.dbservices.mybatis.mappers;

import solvd.projects.database.tableclasses.TypeLectures;

import java.util.List;

public interface ITypeLecturesMapper extends IBaseMapper<TypeLectures> {
    List<TypeLectures> getAllTypeLectures();
}
