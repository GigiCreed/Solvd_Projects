package solvd.projects.database.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.dao.interfaces.IFacultiesDAO;
import solvd.projects.database.models.Faculties;

import java.util.List;

public class FacultiesDAO {
    private static final Logger LOGGER = LogManager.getLogger(FacultiesDAO.class);


    public Faculties getById(Long id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IFacultiesDAO IFacultiesDAO = session.getMapper(IFacultiesDAO.class);
            return IFacultiesDAO.getById(id);
        }finally {
            session.rollback();
            session.close();
        }
    }


    public void insert(Faculties object) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IFacultiesDAO IFacultiesDAO = session.getMapper(IFacultiesDAO.class);
            IFacultiesDAO.insert(object);
            session.commit();
            LOGGER.info("insert completed");
        }finally {
            session.rollback();
            session.close();
        }
    }


    public void update(Faculties object) {
       SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
       try {
           IFacultiesDAO IFacultiesDAO = session.getMapper(IFacultiesDAO.class);
           IFacultiesDAO.update(object);
           session.commit();
           LOGGER.info("update completed");
       }finally {
           session.rollback();
           session.close();
       }
    }


    public void delete(Long id) {
      SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
      try {
          IFacultiesDAO IFacultiesDAO = session.getMapper(IFacultiesDAO.class);
          IFacultiesDAO.delete(id);
          session.commit();
          LOGGER.info("Delete completed");
      }finally {
          session.rollback();
          session.close();
      }
    }


    public List<Faculties> getAllFaculties() {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IFacultiesDAO IFacultiesDAO = session.getMapper(IFacultiesDAO.class);
            return IFacultiesDAO.getAllFaculties();
        }finally {
            session.rollback();
            session.close();
        }
    }
}
