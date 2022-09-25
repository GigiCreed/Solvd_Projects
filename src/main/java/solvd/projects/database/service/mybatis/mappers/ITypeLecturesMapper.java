package solvd.projects.database.service.mybatis.mappers;

import solvd.projects.database.tableclasses.TypeLectures;

import java.util.List;

public interface ITypeLecturesMapper extends IBaseMapper<TypeLectures> {
    List<TypeLectures> getAllTypeLectures();
}
