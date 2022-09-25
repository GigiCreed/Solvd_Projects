package solvd.projects.database.service.mybatis.services.interfacies;

public interface IBaseServices <T>{
    T getById(Long id);
    void insert(T object);
    void update(T object,Long id);
    void delete(Long id);
}
