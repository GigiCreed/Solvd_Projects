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

    private Connection connection = ConnectionPool.getInstance().retrieve();
    @Override
    public void create(Rectors rectors) {
       try {

           PreparedStatement preparedStatement =connection.prepareStatement("insert into rectors (name,surname,age,phone_number,address,email)  values ( ?,?,?,?,?,?)");
           preparedStatement.setString(1,rectors.getName());
           preparedStatement.setString(2,rectors.getSurname());
           preparedStatement.setDate(3,rectors.getAge());
           preparedStatement.setInt(4,rectors.getPhone_number());
           preparedStatement.setString(5,rectors.getAddress());
           preparedStatement.setString(6, rectors.getEmail());
           preparedStatement.executeUpdate();

           connection.close();
           preparedStatement.close();

       }catch (SQLException e){
           LOGGER.error(e);
       }

    }

    @Override
    public Rectors getBy(Rectors rectors, Long id) {
      try {

          PreparedStatement preparedStatement =connection.prepareStatement("Select * from rectors where id = ?");
          preparedStatement.setLong(1,id);
          ResultSet resultSet =preparedStatement.executeQuery();
          while (resultSet.next()){
              rectors.setId(resultSet.getLong("id"));
              rectors.setName(resultSet.getString("name"));
              rectors.setSurname(resultSet.getString("surname"));
              rectors.setAge(resultSet.getDate("age"));
              rectors.setPhone_number(resultSet.getInt("phone_number"));
              rectors.setAddress(resultSet.getString("address"));
              rectors.setEmail(resultSet.getString("email"));
          }

          connection.close();
          preparedStatement.close();
          resultSet.close();
      }catch (SQLException e){
          LOGGER.error(e);
      }
        return rectors;
    }

    @Override
    public void remove(Long id) {
       try {

           PreparedStatement preparedStatement = connection.prepareStatement("Delete From rectors where id = ?");
           preparedStatement.setLong(1,id);
           preparedStatement.executeUpdate();

           connection.close();
           preparedStatement.close();
       }catch (SQLException e){
           LOGGER.error(e);
       }
    }

    @Override
    public void update(String setParameter, Rectors rectors, Long id) {
      try {

          switch (setParameter){
              case "name":PreparedStatement preparedStatementName =connection.prepareStatement("update rectors set name = ? where id = ?");
                  preparedStatementName.setString(1,rectors.getName());
                  preparedStatementName.setLong(2,id);
                  preparedStatementName.executeUpdate();
                  preparedStatementName.close();
              break;
              case "surname":PreparedStatement preparedStatementSurname = connection.prepareStatement("update rectors set surname = ? where id = ?");
                  preparedStatementSurname.setString(1,rectors.getSurname());
                  preparedStatementSurname.setLong(2,id);
                  preparedStatementSurname.executeUpdate();
                  preparedStatementSurname.close();
              break;
              case "age":PreparedStatement preparedStatementAge = connection.prepareStatement("update rectors set age = ? where id = ?");
                  preparedStatementAge.setDate(1,rectors.getAge());
                  preparedStatementAge.setLong(2,id);
                  preparedStatementAge.executeUpdate();
                  preparedStatementAge.close();
              break;
              case "phone_number":PreparedStatement preparedStatementPhoneNumber = connection.prepareStatement("update rectors set phone_number = ? where id = ?");
                  preparedStatementPhoneNumber.setInt(1,rectors.getPhone_number());
                  preparedStatementPhoneNumber.setLong(2,id);
                  preparedStatementPhoneNumber.executeUpdate();
                  preparedStatementPhoneNumber.close();
              break;
              case "address":PreparedStatement preparedStatementAddress = connection.prepareStatement("update rectors set address = ? where id = ?");
                  preparedStatementAddress.setString(1,rectors.getAddress());
                  preparedStatementAddress.setLong(2,id);
                  preparedStatementAddress.executeUpdate();
                  preparedStatementAddress.close();
              break;
              case "email":PreparedStatement preparedStatementEmail = connection.prepareStatement("update rectors set email = ? where id = ?");
                  preparedStatementEmail.setString(1,rectors.getEmail());
                  preparedStatementEmail.setLong(2,id);
                  preparedStatementEmail.executeUpdate();
                  preparedStatementEmail.close();
              break;
              case "all":PreparedStatement preparedStatementAll = connection.prepareStatement("update rectors set name = ? , surname = ?, age = ?, phone_number= ?, address = ?, email = ? where id = ?");
                  preparedStatementAll.setString(1,rectors.getName());
                  preparedStatementAll.setString(2,rectors.getSurname());
                  preparedStatementAll.setDate(3,rectors.getAge());
                  preparedStatementAll.setInt(4,rectors.getPhone_number());
                  preparedStatementAll.setString(5,rectors.getAddress());
                  preparedStatementAll.setString(6,rectors.getEmail());
                  preparedStatementAll.setLong(7,id);
                  preparedStatementAll.executeUpdate();
                  preparedStatementAll.close();
              break;
              default:
                  LOGGER.error("Parameter don't exist");
          }
          connection.close();

      }catch (SQLException e){
          LOGGER.error(e);
      }
    }

    @Override
    public List<Rectors> getAllRectors() {
        List<Rectors> rectorsList = new ArrayList<>();
       try {

           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery("Select * from rectors");
           while (resultSet.next()){
               Rectors rectors = new Rectors();

               rectors.setId(resultSet.getLong("id"));
               rectors.setName(resultSet.getString("name"));
               rectors.setSurname(resultSet.getString("surname"));
               rectors.setAge(resultSet.getDate("age"));
               rectors.setPhone_number(resultSet.getInt("phone_number"));
               rectors.setAddress(resultSet.getString("address"));
               rectors.setEmail(resultSet.getString("email"));

               rectorsList.add(rectors);
           }
          connection.close();
          statement.close();
          resultSet.close();
       }catch (SQLException e){
           LOGGER.error(e);
       }
        return rectorsList;
    }
}
