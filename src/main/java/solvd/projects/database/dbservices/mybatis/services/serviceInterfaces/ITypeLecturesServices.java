package solvd.projects.database.dbservices.mybatis.services.serviceInterfaces;

import solvd.projects.database.models.TypeLectures;

import java.util.List;

public interface ITypeLecturesServices extends IBaseServices<TypeLectures> {
    List<TypeLectures> getAllTypeLectures();
}
