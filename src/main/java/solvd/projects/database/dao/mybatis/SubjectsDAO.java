package solvd.projects.database.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.dao.interfaces.ISubjectsDAO;
import solvd.projects.database.models.Subjects;

import java.util.List;

public class SubjectsDAO {
    private static final Logger LOGGER = LogManager.getLogger(SubjectsDAO.class);

    public Subjects getById(Long id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            ISubjectsDAO iSubjectsDAO = session.getMapper(ISubjectsDAO.class);
            return iSubjectsDAO.getById(id);
        }finally {
            session.rollback();
            session.close();
        }
    }


    public void insert(Subjects object) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            ISubjectsDAO iSubjectsDAO = session.getMapper(ISubjectsDAO.class);
            iSubjectsDAO.insert(object);
            session.commit();
            LOGGER.info("Insert completed");
        }finally {
            session.rollback();
            session.close();
        }
    }


    public void update(Subjects object) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            ISubjectsDAO iSubjectsDAO = session.getMapper(ISubjectsDAO.class);
            iSubjectsDAO.update(object);
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
          ISubjectsDAO iSubjectsDAO = session.getMapper(ISubjectsDAO.class);
          iSubjectsDAO.delete(id);
          session.commit();
          LOGGER.info("Delete completed");
      }finally {
          session.rollback();
          session.close();
      }
    }

    public List<Subjects> getAllSubjects() {
        SqlSession session =MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            ISubjectsDAO iSubjectsDAO = session.getMapper(ISubjectsDAO.class);
            return iSubjectsDAO.getAllSubjects();
        }finally {
            session.rollback();
            session.close();
        }
    }
}
