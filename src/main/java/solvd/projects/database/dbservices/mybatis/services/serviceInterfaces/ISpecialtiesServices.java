package solvd.projects.database.dbservices.mybatis.services.serviceInterfaces;

import solvd.projects.database.tableclasses.Specialties;

import java.util.List;

public interface ISpecialtiesServices extends IBaseServices<Specialties> {
    List<Specialties> getAllSpecialties();
}
