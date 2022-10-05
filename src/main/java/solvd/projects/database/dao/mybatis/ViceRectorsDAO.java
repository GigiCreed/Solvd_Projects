package solvd.projects.database.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.dao.interfaces.IViceRectorsDAO;
import solvd.projects.database.models.ViceRectors;

import java.util.List;

public class ViceRectorsDAO {

    private final static Logger LOGGER = LogManager.getLogger(ViceRectorsDAO.class);

    public ViceRectors getById(Long id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IViceRectorsDAO iViceRectorsDAO = session.getMapper(IViceRectorsDAO.class);
            return iViceRectorsDAO.getById(id);
        }finally {
            session.rollback();
            session.close();
        }
    }


    public void insert(ViceRectors object) {
     SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
     try {
         IViceRectorsDAO iViceRectorsDAO = session.getMapper(IViceRectorsDAO.class);
         iViceRectorsDAO.insert(object);
         session.commit();
         LOGGER.info("insert completed!!");
     }finally {
         session.rollback();
         session.close();
     }
    }


    public void update(ViceRectors object) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IViceRectorsDAO iViceRectorsDAO = session.getMapper(IViceRectorsDAO.class);
            iViceRectorsDAO.update(object);
            session.commit();
            LOGGER.info("Updated completed !!!");
        }finally {
            session.rollback();
            session.close();
        }
    }


    public void delete(Long id) {
       SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
       try {
           IViceRectorsDAO iViceRectorsDAO = session.getMapper(IViceRectorsDAO.class);
           iViceRectorsDAO.delete(id);
           session.commit();
           LOGGER.info("Deleted completed");
       }finally {
           session.rollback();
           session.close();
       }
    }


    public List<ViceRectors> getAllViceRectors() {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IViceRectorsDAO iViceRectorsDAO = session.getMapper(IViceRectorsDAO.class);
            return iViceRectorsDAO.getAllViceRectors();
        }finally {
            session.rollback();
            session.close();
        }
    }
}
