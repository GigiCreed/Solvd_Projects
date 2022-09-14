package solvd.projects.database.mysql.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.mysql.dao.interfaces.IFacultiesDAO;
import solvd.projects.database.mysql.AbstractMySqlDAO;
import solvd.projects.database.mysql.connectionpool.ConnectionPool;
import solvd.projects.database.tableclasses.Faculties;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacultiesDAO extends AbstractMySqlDAO implements IFacultiesDAO {
    private static final Logger LOGGER = LogManager.getLogger(FacultiesDAO.class);

    @Override
    public void create(Faculties faculties) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement =null;
        try {
            preparedStatement = connection.prepareStatement("insert into faculties (name,Universities_id) Values (?,?)");
            preparedStatement.setString(1,faculties.getName());
            preparedStatement.setLong(2,faculties.getUniversitiesId());
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
    public Faculties getBy(Faculties faculties, Long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet =null;
        try {
            preparedStatement = connection.prepareStatement("Select * from faculties Where id = ?");
            preparedStatement.setLong(1,id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                faculties.setId(resultSet.getLong("id"));
                faculties.setName(resultSet.getString("name"));
                faculties.setUniversitiesId(resultSet.getLong("Universities_id"));
            }


        }catch (SQLException e){
            LOGGER.error(e);
        }finally {
            try {
                assert preparedStatement != null;
                preparedStatement.close();
                assert resultSet != null;
                resultSet.close();
            }catch (SQLException e){
                LOGGER.error(e);
            }
            ConnectionPool.getInstance().putback(connection);
        }
        return faculties;
    }

    @Override
    public void remove(Long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement = null;
       try {
           preparedStatement = connection.prepareStatement("delete from faculties where id = ?");
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
    public void update(String setParameter, Faculties faculties, Long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        try {
            switch (setParameter) {
                case "name" -> {
                    PreparedStatement preparedStatementName = connection.prepareStatement("Update faculties Set name = ? where id = ?");
                    preparedStatementName.setString(1, faculties.getName());
                    preparedStatementName.setLong(2, id);
                    preparedStatementName.executeUpdate();
                    preparedStatementName.close();
                }
                case "Universities_id" -> {
                    PreparedStatement preparedStatementUniversitiesId = connection.prepareStatement("Update faculties Set Universities_id = ? where id = ?");
                    preparedStatementUniversitiesId.setLong(1, faculties.getUniversitiesId());
                    preparedStatementUniversitiesId.setLong(2, id);
                    preparedStatementUniversitiesId.executeUpdate();
                    preparedStatementUniversitiesId.close();
                }
                case "all" -> {
                    PreparedStatement preparedStatementAll = connection.prepareStatement("Update faculties Set name = ?, Universities_id = ? where id = ?");
                    preparedStatementAll.setString(1, faculties.getName());
                    preparedStatementAll.setLong(2, faculties.getUniversitiesId());
                    preparedStatementAll.setLong(3, id);
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
    public List<Faculties> getAllFaculties() {
        Connection connection = ConnectionPool.getInstance().retrieve();
        List<Faculties> facultiesList = new ArrayList<>();
        Statement statement =null;
        ResultSet resultSet =null;
       try {
           statement = connection.createStatement();
           resultSet = statement.executeQuery("Select * from faculties");
           while (resultSet.next()) {
               Faculties faculties = new Faculties();
               faculties.setId(resultSet.getLong("id"));
               faculties.setName(resultSet.getString("name"));
               faculties.setUniversitiesId(resultSet.getLong("Universities_id"));

               facultiesList.add(faculties);
           }

       }catch (SQLException e){
           LOGGER.error(e);
       }finally {
           try {
               assert statement != null;
               statement.close();
               assert resultSet != null;
               resultSet.close();
           }catch (SQLException e){
               LOGGER.error(e);
           }
           ConnectionPool.getInstance().putback(connection);
       }

       return facultiesList;
    }
}
