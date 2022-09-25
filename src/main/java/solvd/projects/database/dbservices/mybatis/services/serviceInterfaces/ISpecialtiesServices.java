package solvd.projects.database.dbservices.mybatis.services.serviceInterfaces;

import solvd.projects.database.models.Specialties;

import java.util.List;

public interface ISpecialtiesServices extends IBaseServices<Specialties> {
    List<Specialties> getAllSpecialties();
}
