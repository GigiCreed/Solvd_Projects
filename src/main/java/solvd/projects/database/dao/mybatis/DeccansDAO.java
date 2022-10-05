package solvd.projects.database.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import solvd.projects.database.dao.interfaces.IDeccansDAO;
import solvd.projects.database.models.Deccans;

import java.util.List;

public class DeccansDAO {
    private static final Logger LOGGER = LogManager.getLogger(DeccansDAO.class);
    public Deccans getById(Long id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IDeccansDAO iDeccansDAO =session.getMapper(IDeccansDAO.class);
            return iDeccansDAO.getById(id);
        }finally {
            session.rollback();
            session.close();
        }
    }


    public void insert(Deccans object) {
       SqlSession session =MyBatisUtil.getSqlSessionFactory().openSession();
       try {
           IDeccansDAO iDeccansDAO =session.getMapper(IDeccansDAO.class);
           iDeccansDAO.insert(object);
           session.commit();
           LOGGER.info("Insert completed");
       }finally {
           session.rollback();
           session.close();
       }
    }


    public void update(Deccans object) {
          SqlSession session =MyBatisUtil.getSqlSessionFactory().openSession();
          try {
              IDeccansDAO iDeccansDAO =session.getMapper(IDeccansDAO.class);
              iDeccansDAO.update(object);
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
            IDeccansDAO iDeccansDAO =session.getMapper(IDeccansDAO.class);
            iDeccansDAO.delete(id);
            session.commit();
            LOGGER.info("Delete completed");
        }finally {
            session.rollback();
            session.close();
        }
    }


    public List<Deccans> getAllDeccans() {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IDeccansDAO iDeccansDAO =session.getMapper(IDeccansDAO.class);
            return iDeccansDAO.getAllDeccans();
        }finally {
            session.rollback();
            session.close();
        }
    }
}
