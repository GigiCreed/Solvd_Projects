package solvd.projects.database.mysql.dao.interfaces;

import solvd.projects.database.tableclasses.TypeLectures;

import java.util.List;

public interface ITypeLecturesDAO extends IBaseDAO<TypeLectures> {
    List<TypeLectures> getAllTypeLectures();
}
