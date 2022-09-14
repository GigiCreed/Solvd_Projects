package solvd.projects.database.mysql.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.mysql.dao.interfaces.IUniversitiesDAO;
import solvd.projects.database.mysql.AbstractMySqlDAO;
import solvd.projects.database.mysql.connectionpool.ConnectionPool;
import solvd.projects.database.tableclasses.Universities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UniversitiesDAO extends AbstractMySqlDAO implements IUniversitiesDAO {
    private static final Logger LOGGER = LogManager.getLogger(UniversitiesDAO.class);


    @Override
    public void create(Universities universities) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement = null;
        try {

            preparedStatement =connection.prepareStatement("insert into universities (name,address,site_address,email,Rectors_id,Vice_rectors_id) Values (?,?,?,?,?,?)");
            preparedStatement.setString(1,universities.getName());
            preparedStatement.setString(2,universities.getAddress());
            preparedStatement.setString(3,universities.getSiteAddress());
            preparedStatement.setString(4,universities.getEmail());
            preparedStatement.setLong(5,universities.getRectorsId());
            preparedStatement.setLong(6,universities.getViceRectorsId());
            preparedStatement.executeUpdate();



        } catch (SQLException e){
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
    public Universities getBy(Universities universities, Long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
      try {
          preparedStatement = connection.prepareStatement("select * from universities Where id = ?");
          preparedStatement.setLong(1,id);
          resultSet =preparedStatement.executeQuery();
          while (resultSet.next()){
              universities.setId(resultSet.getLong("id"));
              universities.setName(resultSet.getString("name"));
              universities.setAddress(resultSet.getString("address"));
              universities.setSiteAddress(resultSet.getString("site_address"));
              universities.setEmail(resultSet.getString("email"));
              universities.setRectorsId(resultSet.getLong("Rectors_id"));
              universities.setViceRectorsId(resultSet.getLong("Vice_rectors_id"));
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
      return universities;
    }

    @Override
    public void remove(Long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement = null;
       try {
           preparedStatement = connection.prepareStatement("Delete From universities where id = ?");
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
    public void update(String setParameter, Universities universities, Long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        try {
            switch (setParameter) {
                case "name" -> {
                    PreparedStatement preparedStatementName = connection.prepareStatement("Update universities Set name = ? Where id = ?");
                    preparedStatementName.setString(1, universities.getName());
                    preparedStatementName.setLong(2, id);
                    preparedStatementName.executeUpdate();
                    preparedStatementName.close();
                }
                case "address" -> {
                    PreparedStatement preparedStatementAddress = connection.prepareStatement("Update universities Set address = ? Where id = ?");
                    preparedStatementAddress.setString(1, universities.getAddress());
                    preparedStatementAddress.setLong(2, id);
                    preparedStatementAddress.executeUpdate();
                    preparedStatementAddress.close();
                }
                case "site_address" -> {
                    PreparedStatement preparedStatementSiteAddress = connection.prepareStatement("Update universities Set site_address = ? Where id = ?");
                    preparedStatementSiteAddress.setString(1, universities.getSiteAddress());
                    preparedStatementSiteAddress.setLong(2, id);
                    preparedStatementSiteAddress.executeUpdate();
                    preparedStatementSiteAddress.close();
                }
                case "email" -> {
                    PreparedStatement preparedStatementEmail = connection.prepareStatement("Update universities Set email = ? Where id = ?");
                    preparedStatementEmail.setString(1, universities.getEmail());
                    preparedStatementEmail.setLong(2, id);
                    preparedStatementEmail.executeUpdate();
                    preparedStatementEmail.close();
                }
                case "Rectors_id" -> {
                    PreparedStatement preparedStatementRectorsId = connection.prepareStatement("Update universities Set Rectors_id = ? Where id = ?");
                    preparedStatementRectorsId.setLong(1, universities.getRectorsId());
                    preparedStatementRectorsId.setLong(2, id);
                    preparedStatementRectorsId.executeUpdate();
                    preparedStatementRectorsId.close();
                }
                case "Vice_rectors_id" -> {
                    PreparedStatement preparedStatementViceRectorsId = connection.prepareStatement("Update universities Set Vice_rectors_id = ? Where id = ?");
                    preparedStatementViceRectorsId.setLong(1, universities.getViceRectorsId());
                    preparedStatementViceRectorsId.setLong(2, id);
                    preparedStatementViceRectorsId.executeUpdate();
                    preparedStatementViceRectorsId.close();
                }
                case "all" -> {
                    PreparedStatement preparedStatementAll = connection.prepareStatement("Update universities Set name = ?, address = ?, site_address = ?, email = ?, Rectors_id = ?, Vice_rectors_id = ? Where id = ?");
                    preparedStatementAll.setString(1, universities.getName());
                    preparedStatementAll.setString(2, universities.getAddress());
                    preparedStatementAll.setString(3, universities.getSiteAddress());
                    preparedStatementAll.setString(4, universities.getEmail());
                    preparedStatementAll.setLong(5, universities.getRectorsId());
                    preparedStatementAll.setLong(6, universities.getViceRectorsId());
                    preparedStatementAll.setLong(7, id);
                    preparedStatementAll.executeUpdate();
                    preparedStatementAll.close();
                }
                default -> LOGGER.error("Not exist this parameter");
            }

        }catch (SQLException e){
            LOGGER.error(e);
        }finally {
            ConnectionPool.getInstance().putback(connection);
        }
    }

    @Override
    public List<Universities> getAllUniversities() {
        Connection connection = ConnectionPool.getInstance().retrieve();
       List<Universities> universitiesList = new ArrayList<>();
        Statement statement=null;
        ResultSet resultSet=null;

       try{
         statement = connection.createStatement();
         resultSet = statement.executeQuery("Select * from universities");
         while (resultSet.next()){
             Universities universities = new Universities();
             universities.setId(resultSet.getLong("id"));
             universities.setName(resultSet.getString("name"));
             universities.setAddress(resultSet.getString("address"));
             universities.setSiteAddress(resultSet.getString("site_address"));
             universities.setEmail(resultSet.getString("email"));
             universities.setRectorsId(resultSet.getLong("Rectors_id"));
             universities.setViceRectorsId(resultSet.getLong("Vice_rectors_id"));

             universitiesList.add(universities);
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
       return universitiesList;
    }
}
