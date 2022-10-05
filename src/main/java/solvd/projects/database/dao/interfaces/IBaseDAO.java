package solvd.projects.database.dao.interfaces;

public interface IBaseDAO<T>{
    T getById(Long id);
    void insert(T object);
    void update(T object);
    void delete(Long id);
}
