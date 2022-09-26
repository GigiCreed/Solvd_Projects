package solvd.projects.database.dbservices.mybatis.services;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.dbservices.mybatis.mappers.ISpecialtiesMapper;
import solvd.projects.database.dbservices.mybatis.services.serviceInterfaces.ISpecialtiesServices;
import solvd.projects.database.models.Specialties;

import java.util.List;

public class SpecialtiesServices implements ISpecialtiesServices {
    private static final Logger LOGGER = LogManager.getLogger(SpecialtiesServices.class);
    @Override
    public Specialties getById(Long id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            ISpecialtiesMapper iSpecialtiesMapper = session.getMapper(ISpecialtiesMapper.class);
            return iSpecialtiesMapper.getById(id);
        }finally {
            session.rollback();
            session.close();
        }
    }

    @Override
    public void insert(Specialties object) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            ISpecialtiesMapper iSpecialtiesMapper = session.getMapper(ISpecialtiesMapper.class);
            iSpecialtiesMapper.insert(object);
            session.commit();
            LOGGER.info("Insert Completed");
        }finally {
            session.rollback();
            session.close();
        }

    }

    @Override
    public void update(Specialties object, Long id) {
      SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
      try {
          object.setId(id);
          ISpecialtiesMapper iSpecialtiesMapper = session.getMapper(ISpecialtiesMapper.class);
          iSpecialtiesMapper.update(object);
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
          ISpecialtiesMapper iSpecialtiesMapper = session.getMapper(ISpecialtiesMapper.class);
          iSpecialtiesMapper.delete(id);
          session.commit();
          LOGGER.info("Delete completed");
      }finally {
          session.rollback();
          session.close();
      }
    }

    @Override
    public List<Specialties> getAllSpecialties() {
       SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
       try {
           ISpecialtiesMapper iSpecialtiesMapper = session.getMapper(ISpecialtiesMapper.class);
           return iSpecialtiesMapper.getALLSpecialties();
       }finally {
           session.rollback();
           session.close();
       }
    }
}
