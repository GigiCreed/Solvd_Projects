package solvd.projects.database.dbservices.mybatis.services;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.dbservices.mybatis.mappers.IFacultiesMapper;
import solvd.projects.database.dbservices.mybatis.services.serviceInterfaces.IFacultiesServices;
import solvd.projects.database.models.Faculties;

import java.util.List;

public class FacultiesServices implements IFacultiesServices {
    private static final Logger LOGGER = LogManager.getLogger(FacultiesServices.class);

    @Override
    public Faculties getById(Long id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IFacultiesMapper iFacultiesMapper = session.getMapper(IFacultiesMapper.class);
            return iFacultiesMapper.getById(id);
        }finally {
            session.rollback();
            session.close();
        }
    }

    @Override
    public void insert(Faculties object) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IFacultiesMapper iFacultiesMapper = session.getMapper(IFacultiesMapper.class);
            iFacultiesMapper.insert(object);
            session.commit();
            LOGGER.info("insert completed");
        }finally {
            session.rollback();
            session.close();
        }
    }

    @Override
    public void update(Faculties object, Long id) {
       SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
       try {
           object.setId(id);
           IFacultiesMapper iFacultiesMapper = session.getMapper(IFacultiesMapper.class);
           iFacultiesMapper.update(object);
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
          IFacultiesMapper iFacultiesMapper = session.getMapper(IFacultiesMapper.class);
          iFacultiesMapper.delete(id);
          session.commit();
          LOGGER.info("Delete completed");
      }finally {
          session.rollback();
          session.close();
      }
    }

    @Override
    public List<Faculties> getAllFaculties() {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IFacultiesMapper iFacultiesMapper = session.getMapper(IFacultiesMapper.class);
            return iFacultiesMapper.getAllFaculties();
        }finally {
            session.rollback();
            session.close();
        }
    }
}
