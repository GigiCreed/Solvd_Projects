package solvd.projects.database.mysql.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.mysql.dao.interfaces.IRectorsDAO;
import solvd.projects.database.mysql.AbstractMySqlDAO;
import solvd.projects.database.mysql.connectionpool.ConnectionPool;
import solvd.projects.database.tableclasses.Rectors;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RectorsDAO extends AbstractMySqlDAO implements IRectorsDAO {
    private static final Logger LOGGER = LogManager.getLogger(RectorsDAO.class);

    @Override
    public void create(Rectors rectors) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement = null;
       try {
           preparedStatement =connection.prepareStatement("insert into rectors (name,surname,age,phone_number,address,email)  values ( ?,?,?,?,?,?)");
           preparedStatement.setString(1,rectors.getName());
           preparedStatement.setString(2,rectors.getSurname());
           preparedStatement.setDate(3,rectors.getAge());
           preparedStatement.setInt(4,rectors.getPhoneNumber());
           preparedStatement.setString(5,rectors.getAddress());
           preparedStatement.setString(6, rectors.getEmail());
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
    public Rectors getBy(Rectors rectors, Long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
      try {
          preparedStatement =connection.prepareStatement("Select * from rectors where id = ?");
          preparedStatement.setLong(1,id);
          resultSet =preparedStatement.executeQuery();
          while (resultSet.next()){
              rectors.setId(resultSet.getLong("id"));
              rectors.setName(resultSet.getString("name"));
              rectors.setSurname(resultSet.getString("surname"));
              rectors.setAge(resultSet.getDate("age"));
              rectors.setPhoneNumber(resultSet.getInt("phone_number"));
              rectors.setAddress(resultSet.getString("address"));
              rectors.setEmail(resultSet.getString("email"));
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
        return rectors;
    }

    @Override
    public void remove(Long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement=null;
       try {
           preparedStatement = connection.prepareStatement("Delete From rectors where id = ?");
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
    public void update(String setParameter, Rectors rectors, Long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
      try {
          switch (setParameter) {
              case "name" -> {
                  PreparedStatement preparedStatementName = connection.prepareStatement("update rectors set name = ? where id = ?");
                  preparedStatementName.setString(1, rectors.getName());
                  preparedStatementName.setLong(2, id);
                  preparedStatementName.executeUpdate();
                  preparedStatementName.close();
              }
              case "surname" -> {
                  PreparedStatement preparedStatementSurname = connection.prepareStatement("update rectors set surname = ? where id = ?");
                  preparedStatementSurname.setString(1, rectors.getSurname());
                  preparedStatementSurname.setLong(2, id);
                  preparedStatementSurname.executeUpdate();
                  preparedStatementSurname.close();
              }
              case "age" -> {
                  PreparedStatement preparedStatementAge = connection.prepareStatement("update rectors set age = ? where id = ?");
                  preparedStatementAge.setDate(1, rectors.getAge());
                  preparedStatementAge.setLong(2, id);
                  preparedStatementAge.executeUpdate();
                  preparedStatementAge.close();
              }
              case "phone_number" -> {
                  PreparedStatement preparedStatementPhoneNumber = connection.prepareStatement("update rectors set phone_number = ? where id = ?");
                  preparedStatementPhoneNumber.setInt(1, rectors.getPhoneNumber());
                  preparedStatementPhoneNumber.setLong(2, id);
                  preparedStatementPhoneNumber.executeUpdate();
                  preparedStatementPhoneNumber.close();
              }
              case "address" -> {
                  PreparedStatement preparedStatementAddress = connection.prepareStatement("update rectors set address = ? where id = ?");
                  preparedStatementAddress.setString(1, rectors.getAddress());
                  preparedStatementAddress.setLong(2, id);
                  preparedStatementAddress.executeUpdate();
                  preparedStatementAddress.close();
              }
              case "email" -> {
                  PreparedStatement preparedStatementEmail = connection.prepareStatement("update rectors set email = ? where id = ?");
                  preparedStatementEmail.setString(1, rectors.getEmail());
                  preparedStatementEmail.setLong(2, id);
                  preparedStatementEmail.executeUpdate();
                  preparedStatementEmail.close();
              }
              case "all" -> {
                  PreparedStatement preparedStatementAll = connection.prepareStatement("update rectors set name = ? , surname = ?, age = ?, phone_number= ?, address = ?, email = ? where id = ?");
                  preparedStatementAll.setString(1, rectors.getName());
                  preparedStatementAll.setString(2, rectors.getSurname());
                  preparedStatementAll.setDate(3, rectors.getAge());
                  preparedStatementAll.setInt(4, rectors.getPhoneNumber());
                  preparedStatementAll.setString(5, rectors.getAddress());
                  preparedStatementAll.setString(6, rectors.getEmail());
                  preparedStatementAll.setLong(7, id);
                  preparedStatementAll.executeUpdate();
                  preparedStatementAll.close();
              }
              default -> LOGGER.error("Parameter don't exist");
          }


      }catch (SQLException e){
          LOGGER.error(e);
      }finally {
          ConnectionPool.getInstance().putback(connection);
      }
    }

    @Override
    public List<Rectors> getAllRectors() {
        Connection connection = ConnectionPool.getInstance().retrieve();
        List<Rectors> rectorsList = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet =null;
       try {

           statement = connection.createStatement();
           resultSet = statement.executeQuery("Select * from rectors");
           while (resultSet.next()){
               Rectors rectors = new Rectors();

               rectors.setId(resultSet.getLong("id"));
               rectors.setName(resultSet.getString("name"));
               rectors.setSurname(resultSet.getString("surname"));
               rectors.setAge(resultSet.getDate("age"));
               rectors.setPhoneNumber(resultSet.getInt("phone_number"));
               rectors.setAddress(resultSet.getString("address"));
               rectors.setEmail(resultSet.getString("email"));

               rectorsList.add(rectors);
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
        return rectorsList;
    }
}
