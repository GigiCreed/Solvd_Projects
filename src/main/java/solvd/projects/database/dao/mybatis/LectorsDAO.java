package solvd.projects.database.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.dao.interfaces.ILectorsDAO;
import solvd.projects.database.models.Lectors;

import java.util.List;

public class LectorsDAO {
    private static final Logger LOGGER = LogManager.getLogger(LectorsDAO.class);


    public Lectors getById(Long id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            ILectorsDAO iLectorsDAO = session.getMapper(ILectorsDAO.class);
            return iLectorsDAO.getById(id);
        }finally {
            session.rollback();
            session.close();
        }
    }


    public void insert(Lectors object) {
        SqlSession session  = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            ILectorsDAO iLectorsDAO = session.getMapper(ILectorsDAO.class);
            iLectorsDAO.insert(object);
            session.commit();
            LOGGER.info("insert completed");
        }finally {
            session.rollback();
            session.close();
        }
    }


    public void update(Lectors object) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            ILectorsDAO iLectorsDAO = session.getMapper(ILectorsDAO.class);
            iLectorsDAO.update(object);
            session.commit();
            LOGGER.info("Updated completed");
        }finally {
            session.rollback();
            session.close();
        }
    }


    public void delete(Long id) {
       SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
       try {
           ILectorsDAO iLectorsDAO = session.getMapper(ILectorsDAO.class);
           iLectorsDAO.delete(id);
           session.commit();
           LOGGER.info("delete completed");
       }finally {
           session.rollback();
           session.close();
       }
    }


    public List<Lectors> getAllLectors() {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            ILectorsDAO iLectorsDAO = session.getMapper(ILectorsDAO.class);
            return iLectorsDAO.getAllLectors();
        }finally {
            session.rollback();
            session.close();
        }
    }
}
