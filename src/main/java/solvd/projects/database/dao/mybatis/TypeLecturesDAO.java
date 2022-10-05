package solvd.projects.database.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.dao.interfaces.ITypeLecturesDAO;
import solvd.projects.database.models.TypeLectures;

import java.util.List;

public class TypeLecturesDAO {
    private static final Logger LOGGER = LogManager.getLogger(TypeLecturesDAO.class);

    public TypeLectures getById(Long id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            ITypeLecturesDAO iTypeLecturesDAO = session.getMapper(ITypeLecturesDAO.class);
            return iTypeLecturesDAO.getById(id);
        }finally {
            session.rollback();
            session.close();
        }
    }


    public void insert(TypeLectures object) {
       SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
       try {
           ITypeLecturesDAO iTypeLecturesDAO = session.getMapper(ITypeLecturesDAO.class);
           iTypeLecturesDAO.insert(object);
           session.commit();
           LOGGER.info("Insert completed");
       }finally {
           session.rollback();
           session.close();
       }
    }


    public void update(TypeLectures object) {
        SqlSession session =MyBatisUtil.getSqlSessionFactory().openSession();
        try {

            ITypeLecturesDAO iTypeLecturesDAO = session.getMapper(ITypeLecturesDAO.class);
            iTypeLecturesDAO.update(object);
            session.commit();
            LOGGER.info("Update completed");
        }finally {
            session.rollback();
            session.close();
        }

    }


    public void delete(Long id) {
        SqlSession session =MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            ITypeLecturesDAO iTypeLecturesDAO = session.getMapper(ITypeLecturesDAO.class);
            iTypeLecturesDAO.delete(id);
            session.commit();
            LOGGER.info("Delete completed");
        }finally {
            session.rollback();
            session.close();
        }
    }


    public List<TypeLectures> getAllTypeLectures() {
        SqlSession session =MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            ITypeLecturesDAO iTypeLecturesDAO = session.getMapper(ITypeLecturesDAO.class);
             return iTypeLecturesDAO.getAllTypeLectures();
        }finally {
            session.rollback();
            session.close();
        }
    }
}
