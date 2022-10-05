package solvd.projects.database.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import solvd.projects.database.dao.interfaces.IStudentsDAO;
import solvd.projects.database.models.Students;

import java.util.List;

public class StudentsDAO {
    private static final Logger LOGGER = LogManager.getLogger(StudentsDAO.class);

    public Students getById(Long id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IStudentsDAO iStudentsDAO =session.getMapper(IStudentsDAO.class);
            return iStudentsDAO.getById(id);
        }finally {
            session.rollback();
            session.close();
        }
    }

    public void insert(Students object) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IStudentsDAO iStudentsDAO =session.getMapper(IStudentsDAO.class);
            iStudentsDAO.insert(object);
            session.commit();
            LOGGER.info("insert completed");

        }finally {
            session.rollback();
            session.close();
        }
    }

    public void update(Students students) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {

            IStudentsDAO iStudentsDAO =session.getMapper(IStudentsDAO.class);
            iStudentsDAO.update(students);
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
         IStudentsDAO iStudentsDAO = session.getMapper(IStudentsDAO.class);
         iStudentsDAO.delete(id);
         session.commit();
         LOGGER.info("delete completed");
     }finally {
         session.rollback();
         session.close();
     }
    }


    public List<Students> getAllStudents() {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IStudentsDAO iStudentsDAO = session.getMapper(IStudentsDAO.class);
            return iStudentsDAO.getAllStudents();
        }finally {
            session.rollback();
            session.close();
        }
    }
}