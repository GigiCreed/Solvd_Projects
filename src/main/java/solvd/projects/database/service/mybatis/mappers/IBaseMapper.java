package solvd.projects.database.service.mybatis.mappers;

public interface IBaseMapper <T>{
    T getById(Long id);
    void insert(T object);
    void update(T students);
    void delete(Long id);
}