package solvd.projects.database.dbservice.mybatis.services;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.dbservice.mybatis.mappers.IStudentsMapper;
import solvd.projects.database.dbservice.mybatis.services.serviceInterfaces.IStudentServices;
import solvd.projects.database.tableclasses.Students;

import java.util.List;

public class StudentsServices implements IStudentServices {
    private static final Logger LOGGER = LogManager.getLogger(StudentsServices.class);
    @Override
    public Students getById(Long id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IStudentsMapper iStudentsMapper =session.getMapper(IStudentsMapper.class);
            return iStudentsMapper.getById(id);
        }finally {
            session.rollback();
            session.close();
        }
    }
    @Override
    public void insert(Students object) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IStudentsMapper iStudentsMapper = session.getMapper(IStudentsMapper.class);
            iStudentsMapper.insert(object);
            session.commit();
            LOGGER.info("insert completed");

        }finally {
            session.rollback();
            session.close();
        }
    }
    @Override
    public void update(Students students, Long id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            students.setId(id);
            IStudentsMapper iStudentsMapper= session.getMapper(IStudentsMapper.class);
            iStudentsMapper.update(students);
            session.commit();
            LOGGER.info("update completed");
        }finally {
            session.rollback();
            session.close();
        }
    }

    @Override
    public void delete(Long id) {
     SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
     try {
         IStudentsMapper iStudentsMapper = session.getMapper(IStudentsMapper.class);
         iStudentsMapper.delete(id);
         session.commit();
         LOGGER.info("delete completed");
     }finally {
         session.rollback();
         session.close();
     }
    }

    @Override
    public List<Students> getAllStudents() {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IStudentsMapper iStudentsMapper =session.getMapper(IStudentsMapper.class);
            return iStudentsMapper.getAllStudents();
        }finally {
            session.rollback();
            session.close();
        }
    }
}