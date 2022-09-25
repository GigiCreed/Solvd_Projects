package solvd.projects.database.dbservices.mybatis.services.serviceInterfaces;

public interface IBaseServices <T>{
    T getById(Long id);
    void insert(T object);
    void update(T object,Long id);
    void delete(Long id);
}
