package solvd.projects.database.mysql.dao.interfaces;

public interface IBaseDAO<T>{
    void create(T object);

    T getBy(T object,Long id);

    void remove(Long id);

    void update(String setParameter, T object, Long id);
}
