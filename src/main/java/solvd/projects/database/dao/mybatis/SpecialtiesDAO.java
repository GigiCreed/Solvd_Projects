package solvd.projects.database.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.dao.interfaces.ISpecialtiesDAO;
import solvd.projects.database.models.Specialties;

import java.util.List;

public class SpecialtiesDAO {
    private static final Logger LOGGER = LogManager.getLogger(SpecialtiesDAO.class);

    public Specialties getById(Long id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            ISpecialtiesDAO iSpecialtiesDAO = session.getMapper(ISpecialtiesDAO.class);
            return iSpecialtiesDAO.getById(id);
        }finally {
            session.rollback();
            session.close();
        }
    }


    public void insert(Specialties object) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            ISpecialtiesDAO iSpecialtiesDAO = session.getMapper(ISpecialtiesDAO.class);
            iSpecialtiesDAO.insert(object);
            session.commit();
            LOGGER.info("Insert Completed");
        }finally {
            session.rollback();
            session.close();
        }

    }


    public void update(Specialties object) {
      SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
      try {
          ISpecialtiesDAO iSpecialtiesDAO = session.getMapper(ISpecialtiesDAO.class);
          iSpecialtiesDAO.update(object);
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
          ISpecialtiesDAO iSpecialtiesDAO = session.getMapper(ISpecialtiesDAO.class);
          iSpecialtiesDAO.delete(id);
          session.commit();
          LOGGER.info("Delete completed");
      }finally {
          session.rollback();
          session.close();
      }
    }


    public List<Specialties> getAllSpecialties() {
       SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
       try {
           ISpecialtiesDAO iSpecialtiesDAO = session.getMapper(ISpecialtiesDAO.class);
           return iSpecialtiesDAO.getAllSpecialties();
       }finally {
           session.rollback();
           session.close();
       }
    }
}
