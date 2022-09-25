package solvd.projects.database.dbservice.jdbc.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.dbservice.jdbc.dao.interfaces.IViceRectorsDAO;
import solvd.projects.database.dbservice.jdbc.AbstractMySqlDAO;
import solvd.projects.database.dbservice.jdbc.connectionpool.ConnectionPool;
import solvd.projects.database.tableclasses.ViceRectors;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ViceRectorsDAO extends AbstractMySqlDAO implements IViceRectorsDAO {
    private static final Logger LOGGER = LogManager.getLogger(ViceRectorsDAO.class);


    @Override
    public void create(ViceRectors viceRectors) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement=null;
       try {
           preparedStatement =connection.prepareStatement("insert into vice_rectors (name,surname,age,phone_number,address,email,Universities_id)  values ( ?,?,?,?,?,?,?)");
           preparedStatement.setString(1,viceRectors.getName());
           preparedStatement.setString(2,viceRectors.getSurname());
           preparedStatement.setDate(3,viceRectors.getAge());
           preparedStatement.setInt(4,viceRectors.getPhoneNumber());
           preparedStatement.setString(5,viceRectors.getAddress());
           preparedStatement.setString(6, viceRectors.getEmail());
           preparedStatement.setLong(7,viceRectors.getUniversitiesId());
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
    public ViceRectors getBy(ViceRectors viceRectors, Long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        try {
            preparedStatement =connection.prepareStatement("Select * from vice_rectors where id = ?");
            preparedStatement.setLong(1,id);
            resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                viceRectors.setId(resultSet.getLong("id"));
                viceRectors.setName(resultSet.getString("name"));
                viceRectors.setSurname(resultSet.getString("surname"));
                viceRectors.setAge(resultSet.getDate("age"));
                viceRectors.setPhoneNumber(resultSet.getInt("phone_number"));
                viceRectors.setAddress(resultSet.getString("address"));
                viceRectors.setEmail(resultSet.getString("email"));
                viceRectors.setUniversitiesId(resultSet.getLong("Universities_id"));
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
        return viceRectors;
    }

    @Override
    public void remove(Long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("Delete From vice_rectors where id = ?");
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
    public void update(String setParameter, ViceRectors viceRectors, Long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        try {

            switch (setParameter) {
                case "name" -> {
                    PreparedStatement preparedStatementName = connection.prepareStatement("update vice_rectors set name = ? where id = ?");
                    preparedStatementName.setString(1, viceRectors.getName());
                    preparedStatementName.setLong(2, id);
                    preparedStatementName.executeUpdate();
                    preparedStatementName.close();
                }
                case "surname" -> {
                    PreparedStatement preparedStatementSurname = connection.prepareStatement("update vice_rectors set surname = ? where id = ?");
                    preparedStatementSurname.setString(1, viceRectors.getSurname());
                    preparedStatementSurname.setLong(2, id);
                    preparedStatementSurname.executeUpdate();
                    preparedStatementSurname.close();
                }
                case "age" -> {
                    PreparedStatement preparedStatementAge = connection.prepareStatement("update vice_rectors set age = ? where id = ?");
                    preparedStatementAge.setDate(1, viceRectors.getAge());
                    preparedStatementAge.setLong(2, id);
                    preparedStatementAge.executeUpdate();
                    preparedStatementAge.close();
                }
                case "phone_number" -> {
                    PreparedStatement preparedStatementPhoneNumber = connection.prepareStatement("update vice_rectors set phone_number = ? where id = ?");
                    preparedStatementPhoneNumber.setInt(1, viceRectors.getPhoneNumber());
                    preparedStatementPhoneNumber.setLong(2, id);
                    preparedStatementPhoneNumber.executeUpdate();
                    preparedStatementPhoneNumber.close();
                }
                case "address" -> {
                    PreparedStatement preparedStatementAddress = connection.prepareStatement("update vice_rectors set address = ? where id = ?");
                    preparedStatementAddress.setString(1, viceRectors.getAddress());
                    preparedStatementAddress.setLong(2, id);
                    preparedStatementAddress.executeUpdate();
                    preparedStatementAddress.close();
                }
                case "email" -> {
                    PreparedStatement preparedStatementEmail = connection.prepareStatement("update vice_rectors set email = ? where id = ?");
                    preparedStatementEmail.setString(1, viceRectors.getEmail());
                    preparedStatementEmail.setLong(2, id);
                    preparedStatementEmail.executeUpdate();
                    preparedStatementEmail.close();
                }
                case "Universities_id" -> {
                    PreparedStatement preparedStatementUniversitiesId = connection.prepareStatement("update vice_rectors set Universities_id = ? where id = ?");
                    preparedStatementUniversitiesId.setLong(1, viceRectors.getUniversitiesId());
                    preparedStatementUniversitiesId.setLong(2, id);
                    preparedStatementUniversitiesId.executeUpdate();
                    preparedStatementUniversitiesId.close();
                }
                case "all" -> {
                    PreparedStatement preparedStatementAll = connection.prepareStatement("update vice_rectors set name = ? , surname = ?, age = ?, phone_number= ?, address = ?, email = ? Universities_id = ? where id = ?");
                    preparedStatementAll.setString(1, viceRectors.getName());
                    preparedStatementAll.setString(2, viceRectors.getSurname());
                    preparedStatementAll.setDate(3, viceRectors.getAge());
                    preparedStatementAll.setInt(4, viceRectors.getPhoneNumber());
                    preparedStatementAll.setString(5, viceRectors.getAddress());
                    preparedStatementAll.setString(6, viceRectors.getEmail());
                    preparedStatementAll.setLong(7, viceRectors.getUniversitiesId());
                    preparedStatementAll.setLong(8, id);
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
    public List<ViceRectors> getAllViceRectors() {
        Connection connection = ConnectionPool.getInstance().retrieve();
        List<ViceRectors> viceRectorsList = new ArrayList<>();
        Statement statement=null;
        ResultSet resultSet=null;
        try {

            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select * from vice_rectors");
            while (resultSet.next()){
                ViceRectors viceRectors = new ViceRectors();

                viceRectors.setId(resultSet.getLong("id"));
                viceRectors.setName(resultSet.getString("name"));
                viceRectors.setSurname(resultSet.getString("surname"));
                viceRectors.setAge(resultSet.getDate("age"));
                viceRectors.setPhoneNumber(resultSet.getInt("phone_number"));
                viceRectors.setAddress(resultSet.getString("address"));
                viceRectors.setEmail(resultSet.getString("email"));
                viceRectors.setUniversitiesId(resultSet.getLong("Universities_id"));

                viceRectorsList.add(viceRectors);
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
        return viceRectorsList;
    }

}
