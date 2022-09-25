package solvd.projects.database.dbservices.mybatis.services;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.dbservices.mybatis.mappers.IRectorsMapper;
import solvd.projects.database.dbservices.mybatis.services.serviceInterfaces.IRectorsServices;
import solvd.projects.database.tableclasses.Rectors;

import java.util.List;

public class RectorsServices implements IRectorsServices {
    private static final Logger LOGGER = LogManager.getLogger(RectorsServices.class);
    @Override
    public Rectors getById(Long id) {
        SqlSession session =MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IRectorsMapper iRectorsMapper =session.getMapper(IRectorsMapper.class);
            return iRectorsMapper.getById(id);
        }finally {
            session.rollback();
            session.close();
        }
    }

    @Override
    public void insert(Rectors object) {
      SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
      try {
        IRectorsMapper iRectorsMapper=session.getMapper(IRectorsMapper.class);
        iRectorsMapper.insert(object);
        session.commit();
        LOGGER.info("insert Completed");
      }finally {
          session.rollback();
          session.close();
      }
    }

    @Override
    public void update(Rectors object, Long id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            object.setId(id);
            IRectorsMapper iRectorsMapper = session.getMapper(IRectorsMapper.class);
            iRectorsMapper.update(object);
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
          IRectorsMapper iRectorsMapper = session.getMapper(IRectorsMapper.class);
          iRectorsMapper.delete(id);
          session.commit();
          LOGGER.info("Delete completed");
       }finally {
           session.rollback();
           session.close();
       }
    }

    @Override
    public List<Rectors> getAllRectors() {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IRectorsMapper iRectorsMapper = session.getMapper(IRectorsMapper.class);
            return iRectorsMapper.getAllRectors();
        }finally {
            session.rollback();
            session.close();
        }
    }
}
