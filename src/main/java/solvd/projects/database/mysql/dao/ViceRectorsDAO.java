package solvd.projects.database.mysql.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.interfaces.IViceRectorsDAO;
import solvd.projects.database.mysql.AbstractMySqlDAO;
import solvd.projects.database.mysql.connectionpool.ConnectionPool;
import solvd.projects.database.tableclasses.ViceRectors;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ViceRectorsDAO extends AbstractMySqlDAO implements IViceRectorsDAO {
    private static final Logger LOGGER = LogManager.getLogger(ViceRectorsDAO.class);
    @Override
    public void create(ViceRectors viceRectors) {
       try {
           Connection connection = ConnectionPool.getInstance().retrieve();
           PreparedStatement preparedStatement =connection.prepareStatement("insert into vice_rectors (name,surname,age,phone_number,address,email)  values ( ?,?,?,?,?,?)");
           preparedStatement.setString(1,viceRectors.getName());
           preparedStatement.setString(2,viceRectors.getSurname());
           preparedStatement.setDate(3,viceRectors.getAge());
           preparedStatement.setInt(4,viceRectors.getPhone_number());
           preparedStatement.setString(5,viceRectors.getAddress());
           preparedStatement.setString(6, viceRectors.getEmail());
           preparedStatement.executeUpdate();

           connection.close();
           preparedStatement.close();
       }catch (SQLException e){
           LOGGER.error(e);
       }
    }

    @Override
    public ViceRectors getBy(ViceRectors viceRectors, Long id) {
        try {
            Connection connection =ConnectionPool.getInstance().retrieve();
            PreparedStatement preparedStatement =connection.prepareStatement("Select * from vice_rectors where id = ?");
            preparedStatement.setLong(1,id);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                viceRectors.setId(resultSet.getLong("id"));
                viceRectors.setName(resultSet.getString("name"));
                viceRectors.setSurname(resultSet.getString("surname"));
                viceRectors.setAge(resultSet.getDate("age"));
                viceRectors.setPhone_number(resultSet.getInt("phone_number"));
                viceRectors.setAddress(resultSet.getString("address"));
                viceRectors.setEmail(resultSet.getString("email"));
            }

            connection.close();
            preparedStatement.close();
            resultSet.close();
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return viceRectors;
    }

    @Override
    public void remove(Long id) {
        try {
            Connection connection = ConnectionPool.getInstance().retrieve();
            PreparedStatement preparedStatement = connection.prepareStatement("Delete From vice_rectors where id = ?");
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();

            connection.close();
            preparedStatement.close();
        }catch (SQLException e){
            LOGGER.error(e);
        }
    }

    @Override
    public void update(String setParameter, ViceRectors viceRectors, Long id) {
        try {
            Connection connection =ConnectionPool.getInstance().retrieve();
            switch (setParameter){
                case "name":PreparedStatement preparedStatementName =connection.prepareStatement("update vice_rectors set name = ? where id = ?");
                    preparedStatementName.setString(1,viceRectors.getName());
                    preparedStatementName.setLong(2,id);
                    preparedStatementName.executeUpdate();
                    preparedStatementName.close();
                    break;
                case "surname":PreparedStatement preparedStatementSurname = connection.prepareStatement("update vice_rectors set surname = ? where id = ?");
                    preparedStatementSurname.setString(1,viceRectors.getSurname());
                    preparedStatementSurname.setLong(2,id);
                    preparedStatementSurname.executeUpdate();
                    preparedStatementSurname.close();
                    break;
                case "age":PreparedStatement preparedStatementAge = connection.prepareStatement("update vice_rectors set age = ? where id = ?");
                    preparedStatementAge.setDate(1,viceRectors.getAge());
                    preparedStatementAge.setLong(2,id);
                    preparedStatementAge.executeUpdate();
                    preparedStatementAge.close();
                    break;
                case "phone_number":PreparedStatement preparedStatementPhoneNumber = connection.prepareStatement("update vice_rectors set phone_number = ? where id = ?");
                    preparedStatementPhoneNumber.setInt(1,viceRectors.getPhone_number());
                    preparedStatementPhoneNumber.setLong(2,id);
                    preparedStatementPhoneNumber.executeUpdate();
                    preparedStatementPhoneNumber.close();
                    break;
                case "address":PreparedStatement preparedStatementAddress = connection.prepareStatement("update vice_rectors set address = ? where id = ?");
                    preparedStatementAddress.setString(1,viceRectors.getAddress());
                    preparedStatementAddress.setLong(2,id);
                    preparedStatementAddress.executeUpdate();
                    preparedStatementAddress.close();
                    break;
                case "email":PreparedStatement preparedStatementEmail = connection.prepareStatement("update vice_rectors set email = ? where id = ?");
                    preparedStatementEmail.setString(1,viceRectors.getEmail());
                    preparedStatementEmail.setLong(2,id);
                    preparedStatementEmail.executeUpdate();
                    preparedStatementEmail.close();
                    break;
                case "all":PreparedStatement preparedStatementAll = connection.prepareStatement("update vice_rectors set name = ? , surname = ?, age = ?, phone_number= ?, address = ?, email = ? where id = ?");
                    preparedStatementAll.setString(1,viceRectors.getName());
                    preparedStatementAll.setString(2,viceRectors.getSurname());
                    preparedStatementAll.setDate(3,viceRectors.getAge());
                    preparedStatementAll.setInt(4,viceRectors.getPhone_number());
                    preparedStatementAll.setString(5,viceRectors.getAddress());
                    preparedStatementAll.setString(6,viceRectors.getEmail());
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
    public List<ViceRectors> getAllViceRectors() {
        List<ViceRectors> viceRectorsList = new ArrayList<>();
        try {
            Connection connection = ConnectionPool.getInstance().retrieve();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from vice_rectors");
            while (resultSet.next()){
                ViceRectors viceRectors = new ViceRectors();

                viceRectors.setId(resultSet.getLong("id"));
                viceRectors.setName(resultSet.getString("name"));
                viceRectors.setSurname(resultSet.getString("surname"));
                viceRectors.setAge(resultSet.getDate("age"));
                viceRectors.setPhone_number(resultSet.getInt("phone_number"));
                viceRectors.setAddress(resultSet.getString("address"));
                viceRectors.setEmail(resultSet.getString("email"));

                viceRectorsList.add(viceRectors);
            }
            connection.close();
            statement.close();
            resultSet.close();
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return viceRectorsList;
    }

}