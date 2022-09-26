package solvd.projects.database.dbservices.mybatis.services;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.dbservices.mybatis.mappers.IViceRectorsMapper;
import solvd.projects.database.dbservices.mybatis.services.serviceInterfaces.IViceRectorsServices;
import solvd.projects.database.models.ViceRectors;

import java.util.List;

public class ViceRectorsServices implements IViceRectorsServices {

    private final static Logger LOGGER = LogManager.getLogger(ViceRectorsServices.class);
    @Override
    public ViceRectors getById(Long id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IViceRectorsMapper iViceRectorsMapper = session.getMapper(IViceRectorsMapper.class);
            return iViceRectorsMapper.getById(id);
        }finally {
            session.rollback();
            session.close();
        }
    }

    @Override
    public void insert(ViceRectors object) {
     SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
     try {
         IViceRectorsMapper iViceRectorsMapper = session.getMapper(IViceRectorsMapper.class);
         iViceRectorsMapper.insert(object);
         session.commit();
         LOGGER.info("insert completed!!");
     }finally {
         session.rollback();
         session.close();
     }
    }

    @Override
    public void update(ViceRectors object, Long id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            object.setId(id);
            IViceRectorsMapper iViceRectorsMapper = session.getMapper(IViceRectorsMapper.class);
            iViceRectorsMapper.update(object);
            session.commit();
            LOGGER.info("Updated completed !!!");
        }finally {
            session.rollback();
            session.close();
        }
    }

    @Override
    public void delete(Long id) {
       SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
       try {
           IViceRectorsMapper iViceRectorsMapper = session.getMapper(IViceRectorsMapper.class);
           iViceRectorsMapper.delete(id);
           session.commit();
           LOGGER.info("Deleted completed");
       }finally {
           session.rollback();
           session.close();
       }
    }

    @Override
    public List<ViceRectors> getAllViceRectors() {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IViceRectorsMapper iViceRectorsMapper = session.getMapper(IViceRectorsMapper.class);
            return iViceRectorsMapper.getAllViceRectors();
        }finally {
            session.rollback();
            session.close();
        }
    }
}
