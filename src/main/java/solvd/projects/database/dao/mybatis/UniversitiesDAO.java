package solvd.projects.database.dao.mybatis;



import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.dao.interfaces.IUniversitiesDAO;
import solvd.projects.database.models.Universities;

import java.util.List;

public class UniversitiesDAO {
    private static final Logger LOGGER = LogManager.getLogger(UniversitiesDAO.class);


    public Universities getById(Long id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IUniversitiesDAO iUniversitiesDAO = session.getMapper(IUniversitiesDAO.class);
            return iUniversitiesDAO.getById(id);
        }finally {
            session.rollback();
            session.close();
        }
    }


    public void insert(Universities object) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IUniversitiesDAO iUniversitiesDAO = session.getMapper(IUniversitiesDAO.class);
            iUniversitiesDAO.insert(object);
            session.commit();
            LOGGER.info("insert completed !!!!!");
        }finally {
            session.rollback();
            session.close();
        }

    }


    public void update(Universities object) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IUniversitiesDAO iUniversitiesDAO = session.getMapper(IUniversitiesDAO.class);
            iUniversitiesDAO.update(object);
            session.commit();
            LOGGER.info("Update completed");
        }finally {
            session.rollback();
            session.close();
        }
    }


    public void delete(Long id) {
      SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
      try {
          IUniversitiesDAO iUniversitiesDAO = session.getMapper(IUniversitiesDAO.class);
          iUniversitiesDAO.delete(id);
          session.commit();
          LOGGER.info("Delete completed");
      }finally {
          session.rollback();
          session.close();
      }
    }


    public List<Universities> getAllUniversities() {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IUniversitiesDAO iUniversitiesDAO = session.getMapper(IUniversitiesDAO.class);
            return iUniversitiesDAO.getAllUniversities();
        }finally {
            session.rollback();
            session.close();
        }
    }
}
