package solvd.projects.database.dbservice.mybatis.services;



import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.dbservice.mybatis.mappers.IUniversitiesMapper;
import solvd.projects.database.dbservice.mybatis.services.serviceInterfaces.IUniversitiesServices;
import solvd.projects.database.tableclasses.Universities;

import java.util.List;

public class UniversitiesService implements IUniversitiesServices {
    private static final Logger LOGGER = LogManager.getLogger(UniversitiesService.class);

    @Override
    public Universities getById(Long id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IUniversitiesMapper iUniversitiesMapper = session.getMapper(IUniversitiesMapper.class);
            return iUniversitiesMapper.getById(id);
        }finally {
            session.rollback();
            session.close();
        }
    }

    @Override
    public void insert(Universities object) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IUniversitiesMapper iUniversitiesMapper =session.getMapper(IUniversitiesMapper.class);
            iUniversitiesMapper.insert(object);
            session.commit();
            LOGGER.info("insert completed !!!!!");
        }finally {
            session.rollback();
            session.close();
        }

    }

    @Override
    public void update(Universities object, Long id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            object.setId(id);
            IUniversitiesMapper iUniversitiesMapper = session.getMapper(IUniversitiesMapper.class);
            iUniversitiesMapper.update(object);
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
          IUniversitiesMapper iUniversitiesMapper =session.getMapper(IUniversitiesMapper.class);
          iUniversitiesMapper.delete(id);
          session.commit();
          LOGGER.info("Delete completed");
      }finally {
          session.rollback();
          session.close();
      }
    }

    @Override
    public List<Universities> getAllUniversities() {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IUniversitiesMapper iUniversitiesMapper = session.getMapper(IUniversitiesMapper.class);
            return iUniversitiesMapper.getAllUniversities();
        }finally {
            session.rollback();
            session.close();
        }
    }
}
