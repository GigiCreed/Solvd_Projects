package solvd.projects.database.dbservices.mybatis.services;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.dbservices.mybatis.mappers.ILectorsMapper;
import solvd.projects.database.dbservices.mybatis.services.serviceInterfaces.ILectorsServices;
import solvd.projects.database.models.Lectors;

import java.util.List;

public class LectorsServices implements ILectorsServices {
    private static final Logger LOGGER = LogManager.getLogger(LectorsServices.class);

    @Override
    public Lectors getById(Long id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            ILectorsMapper iLectorsMapper = session.getMapper(ILectorsMapper.class);
            return iLectorsMapper.getById(id);
        }finally {
            session.rollback();
            session.close();
        }
    }

    @Override
    public void insert(Lectors object) {
        SqlSession session  = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            ILectorsMapper iLectorsMapper =session.getMapper(ILectorsMapper.class);
            iLectorsMapper.insert(object);
            session.commit();
            LOGGER.info("insert completed");
        }finally {
            session.rollback();
            session.close();
        }
    }

    @Override
    public void update(Lectors object, Long id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            object.setId(id);
            ILectorsMapper iLectorsMapper = session.getMapper(ILectorsMapper.class);
            iLectorsMapper.update(object);
            session.commit();
            LOGGER.info("Updated completed");
        }finally {
            session.rollback();
            session.close();
        }
    }

    @Override
    public void delete(Long id) {
       SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
       try {
           ILectorsMapper iLectorsMapper = session.getMapper(ILectorsMapper.class);
           iLectorsMapper.delete(id);
           session.commit();
           LOGGER.info("delete completed");
       }finally {
           session.rollback();
           session.close();
       }
    }

    @Override
    public List<Lectors> getAllLectors() {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            ILectorsMapper iLectorsMapper = session.getMapper(ILectorsMapper.class);
            return iLectorsMapper.getAllLectors();
        }finally {
            session.rollback();
            session.close();
        }
    }
}
