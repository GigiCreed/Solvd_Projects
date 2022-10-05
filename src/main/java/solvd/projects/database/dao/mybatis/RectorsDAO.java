package solvd.projects.database.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.dao.interfaces.IRectorsDAO;
import solvd.projects.database.models.Rectors;

import java.util.List;

public class RectorsDAO {
    private static final Logger LOGGER = LogManager.getLogger(RectorsDAO.class);

    public Rectors getById(Long id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IRectorsDAO iRectorsDAO =session.getMapper(IRectorsDAO.class);
            return iRectorsDAO.getById(id);
        }finally {
            session.rollback();
            session.close();
        }
    }


    public void insert(Rectors object) {
      SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
      try {
        IRectorsDAO iRectorsDAO =session.getMapper(IRectorsDAO.class);
          iRectorsDAO.insert(object);
        session.commit();
        LOGGER.info("insert Completed");
      }finally {
          session.rollback();
          session.close();
      }
    }


    public void update(Rectors object) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IRectorsDAO iRectorsDAO =session.getMapper(IRectorsDAO.class);
            iRectorsDAO.update(object);
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
          IRectorsDAO iRectorsDAO =session.getMapper(IRectorsDAO.class);
          iRectorsDAO.delete(id);
          session.commit();
          LOGGER.info("Delete completed");
       }finally {
           session.rollback();
           session.close();
       }
    }


    public List<Rectors> getAllRectors() {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IRectorsDAO iRectorsDAO =session.getMapper(IRectorsDAO.class);
            return iRectorsDAO.getAllRectors();
        }finally {
            session.rollback();
            session.close();
        }
    }
}
