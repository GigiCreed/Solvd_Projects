package solvd.projects.database.dbservices.mybatis.services;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.dbservices.mybatis.mappers.IDeccansMapper;
import solvd.projects.database.dbservices.mybatis.services.serviceInterfaces.IDeccansServices;
import solvd.projects.database.models.Deccans;

import java.util.List;

public class DeccansServices implements IDeccansServices {
    private static final Logger LOGGER = LogManager.getLogger(DeccansServices.class);
    @Override
    public Deccans getById(Long id) {
        SqlSession session =MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IDeccansMapper iDeccansMapper =session.getMapper(IDeccansMapper.class);
            return iDeccansMapper.getById(id);
        }finally {
            session.rollback();
            session.close();
        }
    }

    @Override
    public void insert(Deccans object) {
       SqlSession session =MyBatisUtil.getSqlSessionFactory().openSession();
       try {
           IDeccansMapper iDeccansMapper = session.getMapper(IDeccansMapper.class);
           iDeccansMapper.insert(object);
           session.commit();
           LOGGER.info("Insert completed");
       }finally {
           session.rollback();
           session.close();
       }
    }

    @Override
    public void update(Deccans object, Long id) {
          SqlSession session =MyBatisUtil.getSqlSessionFactory().openSession();
          try {
              object.setId(id);
              IDeccansMapper iDeccansMapper = session.getMapper(IDeccansMapper.class);
              iDeccansMapper.update(object);
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
            IDeccansMapper iDeccansMapper = session.getMapper(IDeccansMapper.class);
            iDeccansMapper.delete(id);
            session.commit();
            LOGGER.info("Delete completed");
        }finally {
            session.rollback();
            session.close();
        }
    }

    @Override
    public List<Deccans> getAllDeccans() {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IDeccansMapper iDeccansMapper = session.getMapper(IDeccansMapper.class);
            return iDeccansMapper.getAllDeccans();
        }finally {
            session.rollback();
            session.close();
        }
    }
}
