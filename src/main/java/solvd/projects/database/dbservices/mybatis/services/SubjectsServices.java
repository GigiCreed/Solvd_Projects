package solvd.projects.database.dbservices.mybatis.services;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.dbservices.mybatis.mappers.ISubjectsMapper;
import solvd.projects.database.dbservices.mybatis.services.serviceInterfaces.ISubjectsServices;
import solvd.projects.database.models.Subjects;

import java.util.List;

public class SubjectsServices implements ISubjectsServices {
    private static final Logger LOGGER = LogManager.getLogger(SubjectsServices.class);
    @Override
    public Subjects getById(Long id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            ISubjectsMapper iSubjectsMapper = session.getMapper(ISubjectsMapper.class);
            return iSubjectsMapper.getById(id);
        }finally {
            session.rollback();
            session.close();
        }
    }

    @Override
    public void insert(Subjects object) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            ISubjectsMapper iSubjectsMapper = session.getMapper(ISubjectsMapper.class);
            iSubjectsMapper.insert(object);
            session.commit();
            LOGGER.info("Insert completed");
        }finally {
            session.rollback();
            session.close();
        }
    }

    @Override
    public void update(Subjects object, Long id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            object.setId(id);
            ISubjectsMapper iSubjectsMapper = session.getMapper(ISubjectsMapper.class);
            iSubjectsMapper.update(object);
            session.commit();
            LOGGER.info("Update completed");
        }finally {
            session.rollback();
            session.close();
        }
    }

    @Override
    public void delete(Long id) {
      SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
      try {
          ISubjectsMapper iSubjectsMapper = session.getMapper(ISubjectsMapper.class);
          iSubjectsMapper.delete(id);
          session.commit();
          LOGGER.info("Delete completed");
      }finally {
          session.rollback();
          session.close();
      }
    }

    @Override
    public List<Subjects> getAllSubjects() {
        SqlSession session =MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            ISubjectsMapper iSubjectsMapper = session.getMapper(ISubjectsMapper.class);
            return iSubjectsMapper.getAllSubjects();
        }finally {
            session.rollback();
            session.close();
        }
    }
}
