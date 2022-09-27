package solvd.projects.database.dbservices.mybatis.services;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.dbservices.mybatis.mappers.ITypeLecturesMapper;
import solvd.projects.database.dbservices.mybatis.services.serviceInterfaces.ITypeLecturesServices;
import solvd.projects.database.models.TypeLectures;

import java.util.List;

public class TypeLecturesServices implements ITypeLecturesServices {
    private static final Logger LOGGER = LogManager.getLogger(TypeLecturesServices.class);
    @Override
    public TypeLectures getById(Long id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            ITypeLecturesMapper iTypeLecturesMapper = session.getMapper(ITypeLecturesMapper.class);
            return iTypeLecturesMapper.getById(id);
        }finally {
            session.rollback();
            session.close();
        }
    }

    @Override
    public void insert(TypeLectures object) {
       SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
       try {
           ITypeLecturesMapper iTypeLecturesMapper = session.getMapper(ITypeLecturesMapper.class);
           iTypeLecturesMapper.insert(object);
           session.commit();
           LOGGER.info("Insert completed");
       }finally {
           session.rollback();
           session.close();
       }
    }

    @Override
    public void update(TypeLectures object, Long id) {
        SqlSession session =MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            object.setId(id);
            ITypeLecturesMapper iTypeLecturesMapper = session.getMapper(ITypeLecturesMapper.class);
            iTypeLecturesMapper.update(object);
            session.commit();
            LOGGER.info("Update completed");
        }finally {
            session.rollback();
            session.close();
        }

    }

    @Override
    public void delete(Long id) {
        SqlSession session =MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            ITypeLecturesMapper iTypeLecturesMapper = session.getMapper(ITypeLecturesMapper.class);
            iTypeLecturesMapper.delete(id);
            session.commit();
            LOGGER.info("Delete completed");
        }finally {
            session.rollback();
            session.close();
        }
    }

    @Override
    public List<TypeLectures> getAllTypeLectures() {
        SqlSession session =MyBatisUtil.getSqlSessionFactory().openSession();
        try {
             ITypeLecturesMapper iTypeLecturesMapper = session.getMapper(ITypeLecturesMapper.class);
             return iTypeLecturesMapper.getAllTypeLectures();
        }finally {
            session.rollback();
            session.close();
        }
    }
}
