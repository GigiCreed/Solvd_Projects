package solvd.projects.database.mysql.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.interfaces.IUniversitiesDAO;
import solvd.projects.database.mysql.AbstractMySqlDAO;
import solvd.projects.database.mysql.connectionpool.ConnectionPool;
import solvd.projects.database.tableclasses.Universities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UniversitiesDAO extends AbstractMySqlDAO implements IUniversitiesDAO {
    private static final Logger LOGGER = LogManager.getLogger(UniversitiesDAO.class);

    private Connection connection = ConnectionPool.getInstance().retrieve();
    @Override
    public void create(Universities universities) {
        try {

            PreparedStatement preparedStatement =connection.prepareStatement("insert into universities (name,address,site_address,email,Rectors_id,Vice_rectors_id) Values (?,?,?,?,?,?)");
            preparedStatement.setString(1,universities.getName());
            preparedStatement.setString(2,universities.getAddress());
            preparedStatement.setString(3,universities.getSiteAddress());
            preparedStatement.setString(4,universities.getEmail());
            preparedStatement.setLong(5,universities.getRectorsId());
            preparedStatement.setLong(6,universities.getViceRectorsId());
            preparedStatement.executeUpdate();

            connection.close();
            preparedStatement.close();

        } catch (SQLException e){
             LOGGER.error(e);
        }
    }

    @Override
    public Universities getBy(Universities universities, Long id) {
      try {

          PreparedStatement preparedStatement = connection.prepareStatement("select * from universities Where id = ?");
          preparedStatement.setLong(1,id);
          ResultSet resultSet =preparedStatement.executeQuery();
          while (resultSet.next()){
              universities.setId(resultSet.getLong("id"));
              universities.setName(resultSet.getString("name"));
              universities.setAddress(resultSet.getString("address"));
              universities.setSiteAddress(resultSet.getString("site_address"));
              universities.setEmail(resultSet.getString("email"));
              universities.setRectorsId(resultSet.getLong("Rectors_id"));
              universities.setViceRectorsId(resultSet.getLong("Vice_rectors_id"));
          }

          connection.close();
          preparedStatement.close();
          resultSet.close();
      }catch (SQLException e){
          LOGGER.error(e);
      }
      return universities;
    }

    @Override
    public void remove(Long id) {
       try {

           PreparedStatement preparedStatement = connection.prepareStatement("Delete From universities where id = ?");
           preparedStatement.setLong(1,id);
           preparedStatement.executeUpdate();

           connection.close();
           preparedStatement.close();
       }catch (SQLException e){
           LOGGER.error(e);
       }
    }

    @Override
    public void update(String setParameter, Universities universities, Long id) {
        try {
            switch (setParameter){
            case "name":PreparedStatement preparedStatementName = connection.prepareStatement("Update universities Set name = ? Where id = ?");
                preparedStatementName.setString(1,universities.getName());
                preparedStatementName.setLong(2,id);
                preparedStatementName.executeUpdate();
                preparedStatementName.close();
                break;
            case "address":PreparedStatement preparedStatementAddress = connection.prepareStatement("Update universities Set address = ? Where id = ?");
                preparedStatementAddress.setString(1,universities.getAddress());
                preparedStatementAddress.setLong(2,id);
                preparedStatementAddress.executeUpdate();
                preparedStatementAddress.close();
                break;
            case "site_address":PreparedStatement preparedStatementSiteAddress = connection.prepareStatement("Update universities Set site_address = ? Where id = ?");
                preparedStatementSiteAddress.setString(1,universities.getSiteAddress());
                preparedStatementSiteAddress.setLong(2,id);
                preparedStatementSiteAddress.executeUpdate();
                preparedStatementSiteAddress.close();
                break;
            case "email":PreparedStatement preparedStatementEmail = connection.prepareStatement("Update universities Set email = ? Where id = ?");
                preparedStatementEmail.setString(1,universities.getEmail());
                preparedStatementEmail.setLong(2,id);
                preparedStatementEmail.executeUpdate();
                preparedStatementEmail.close();
                break;
            case "Rectors_id":PreparedStatement preparedStatementRectorsId = connection.prepareStatement("Update universities Set Rectors_id = ? Where id = ?");
                preparedStatementRectorsId.setLong(1,universities.getRectorsId());
                preparedStatementRectorsId.setLong(2,id);
                preparedStatementRectorsId.executeUpdate();
                preparedStatementRectorsId.close();
                break;
            case "Vice_rectors_id":PreparedStatement preparedStatementViceRectorsId = connection.prepareStatement("Update universities Set Vice_rectors_id = ? Where id = ?");
                preparedStatementViceRectorsId.setLong(1,universities.getViceRectorsId());
                preparedStatementViceRectorsId.setLong(2,id);
                preparedStatementViceRectorsId.executeUpdate();
                preparedStatementViceRectorsId.close();
                break;
            case "all":
                PreparedStatement preparedStatementAll = connection.prepareStatement("Update universities Set name = ?, address = ?, site_address = ?, email = ?, Rectors_id = ?, Vice_rectors_id = ? Where id = ?");
                preparedStatementAll.setString(1,universities.getName());
                preparedStatementAll.setString(2,universities.getAddress());
                preparedStatementAll.setString(3,universities.getSiteAddress());
                preparedStatementAll.setString(4,universities.getEmail());
                preparedStatementAll.setLong(5,universities.getRectorsId());
                preparedStatementAll.setLong(6,universities.getViceRectorsId());
                preparedStatementAll.setLong(7,id);
                preparedStatementAll.executeUpdate();
                preparedStatementAll.close();
                break;
            default:
                LOGGER.error("Not exist this parameter");
            }
            connection.close();
        }catch (SQLException e){
            LOGGER.error(e);
        }
    }

    @Override
    public List<Universities> getAllUniversities() {
       List<Universities> universitiesList = new ArrayList<>();
       try{

         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery("Select * from universities");
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

         connection.close();
         statement.close();
         resultSet.close();
       }catch (SQLException e){
           LOGGER.error(e);
       }
       return universitiesList;
    }
}
