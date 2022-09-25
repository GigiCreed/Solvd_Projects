package solvd.projects.database.service.mybatis.services.interfacies;

import solvd.projects.database.tableclasses.Specialties;

import java.util.List;

public interface ISpecialtiesServices extends IBaseServices<Specialties> {
    List<Specialties> getAllSpecialties();
}
