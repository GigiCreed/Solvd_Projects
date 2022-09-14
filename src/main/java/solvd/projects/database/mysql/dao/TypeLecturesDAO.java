package solvd.projects.database.mysql.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.mysql.dao.interfaces.ITypeLecturesDAO;
import solvd.projects.database.mysql.AbstractMySqlDAO;
import solvd.projects.database.mysql.connectionpool.ConnectionPool;
import solvd.projects.database.tableclasses.TypeLectures;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TypeLecturesDAO extends AbstractMySqlDAO implements ITypeLecturesDAO {

    private static final Logger LOGGER = LogManager.getLogger(TypeLecturesDAO.class);



    @Override
    public void create(TypeLectures typeLectures) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement = connection.prepareStatement("Insert into type_lectures (type, Lectors_id, Subjects_id) values (?,?,?)");
            preparedStatement.setString(1,typeLectures.getType());
            preparedStatement.setLong(2,typeLectures.getLectorsId());
            preparedStatement.setLong(3,typeLectures.getSubjectsId());
            preparedStatement.executeUpdate();


        }catch (SQLException e){
            LOGGER.error(e);
        }finally {
            try {
                assert preparedStatement != null;
                preparedStatement.close();
            }catch (SQLException e){
                LOGGER.error(e);
            }
            ConnectionPool.getInstance().putback(connection);
        }
    }

    @Override
    public TypeLectures getBy(TypeLectures typeLectures, Long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
       try {
           preparedStatement = connection.prepareStatement("Select * from type_lectures where id = ?");
           preparedStatement.setLong(1,id);
           resultSet = preparedStatement.executeQuery();
           while (resultSet.next()){
               typeLectures.setId(resultSet.getLong("id"));
               typeLectures.setType(resultSet.getString("type"));
               typeLectures.setLectorsId(resultSet.getLong("Lectors_id"));
               typeLectures.setSubjectsId(resultSet.getLong("Subjects_id"));
           }

       }catch (SQLException e){
           LOGGER.error(e);
       }finally {
           try {
               assert resultSet != null;
               resultSet.close();
               preparedStatement.close();
           }catch (SQLException e){
               LOGGER.error(e);
           }
           ConnectionPool.getInstance().putback(connection);
       }
        return typeLectures;
    }

    @Override
    public void remove(Long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement = connection.prepareStatement("Delete from type_lectures where id = ?");
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            LOGGER.error(e);
        }finally {
            try {
                assert preparedStatement != null;
                preparedStatement.close();
            }catch (SQLException e){
                LOGGER.error(e);
            }
            ConnectionPool.getInstance().putback(connection);
        }
    }

    @Override
    public void update(String setParameter, TypeLectures typeLectures, Long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
       try {
           switch (setParameter) {
               case "type" -> {
                   PreparedStatement preparedStatementType = connection.prepareStatement("Update type_lectures Set type = ? where id = ?");
                   preparedStatementType.setString(1, typeLectures.getType());
                   preparedStatementType.setLong(2, id);
                   preparedStatementType.executeUpdate();
                   preparedStatementType.close();
               }
               case "Lectors_id" -> {
                   PreparedStatement preparedStatementLectorsId = connection.prepareStatement("Update type_lectures Set Lectors_id = ? where id = ?");
                   preparedStatementLectorsId.setLong(1, typeLectures.getLectorsId());
                   preparedStatementLectorsId.setLong(2, id);
                   preparedStatementLectorsId.executeUpdate();
                   preparedStatementLectorsId.close();
               }
               case "Subjects_id" -> {
                   PreparedStatement preparedStatementSubjectsId = connection.prepareStatement("Update type_lectures Set Subjects_id = ? where id = ?");
                   preparedStatementSubjectsId.setLong(1, typeLectures.getSubjectsId());
                   preparedStatementSubjectsId.setLong(2, id);
                   preparedStatementSubjectsId.executeUpdate();
                   preparedStatementSubjectsId.close();
               }
               case "all" -> {
                   PreparedStatement preparedStatementAll = connection.prepareStatement("Update type_lectures Set type = ?,Lectors_id = ? , Subjects_id = ? where id = ?");
                   preparedStatementAll.setString(1, typeLectures.getType());
                   preparedStatementAll.setLong(2, typeLectures.getLectorsId());
                   preparedStatementAll.setLong(3, typeLectures.getSubjectsId());
                   preparedStatementAll.setLong(4, id);
                   preparedStatementAll.executeUpdate();
                   preparedStatementAll.close();
               }
               default -> LOGGER.error("Parameter not exist");
           }

       }catch (SQLException e){
           LOGGER.error(e);
       }finally {
           ConnectionPool.getInstance().putback(connection);
       }
    }

    @Override
    public List<TypeLectures> getAllTypeLectures() {
        Connection connection = ConnectionPool.getInstance().retrieve();
        List<TypeLectures> typeLecturesList = new ArrayList<>();
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select * from type_lectures");
            while (resultSet.next()){
                TypeLectures typeLectures = new TypeLectures();

                typeLectures.setId(resultSet.getLong("id"));
                typeLectures.setType(resultSet.getString("type"));
                typeLectures.setLectorsId(resultSet.getLong("Lectors_id"));
                typeLectures.setSubjectsId(resultSet.getLong("Subjects_id"));

                typeLecturesList.add(typeLectures);
            }

        }catch (SQLException e){
            LOGGER.error(e);
        }finally {
          try {
              assert resultSet != null;
              resultSet.close();
              statement.close();
          }catch (SQLException e){
              LOGGER.error(e);
          }
          ConnectionPool.getInstance().putback(connection);
        }
        return typeLecturesList;
    }
}
