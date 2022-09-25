package solvd.projects.database.dbservice.jdbc.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.dbservice.jdbc.dao.interfaces.IDeccansDAO;
import solvd.projects.database.dbservice.jdbc.AbstractMySqlDAO;
import solvd.projects.database.dbservice.jdbc.connectionpool.ConnectionPool;
import solvd.projects.database.tableclasses.Deccans;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeccansDAO extends AbstractMySqlDAO implements IDeccansDAO {
    private static final Logger LOGGER = LogManager.getLogger(DeccansDAO.class);


    @Override
    public void create(Deccans deccans)  {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("insert into deccans (name,surname,age,address,phone_number,email,Universities_id)  values ( ?,?,?,?,?,?,?)");
            preparedStatement.setString(1,deccans.getName());
            preparedStatement.setString(2,deccans.getSurname());
            preparedStatement.setDate(3,deccans.getAge());
            preparedStatement.setString(4,deccans.getAddress());
            preparedStatement.setInt(5,deccans.getPhone_number());
            preparedStatement.setString(6, deccans.getEmail());
            preparedStatement.setLong(7,deccans.getUniversitiesId());
            preparedStatement.executeUpdate();


        }catch (SQLException e){
            LOGGER.error(e);
        }finally {
            try {
                assert preparedStatement != null;
                preparedStatement.close();
            } catch (SQLException e) {
               LOGGER.error(e);
            }
            ConnectionPool.getInstance().putback(connection);
        }
    }

    @Override
    public Deccans getBy(Deccans deccans, Long id)  {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            preparedStatement =connection.prepareStatement("Select * from deccans where id = ?");
            preparedStatement.setLong(1,id);
            resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                deccans.setId(resultSet.getLong("id"));
                deccans.setName(resultSet.getString("name"));
                deccans.setSurname(resultSet.getString("surname"));
                deccans.setAge(resultSet.getDate("age"));
                deccans.setAddress(resultSet.getString("address"));
                deccans.setPhone_number(resultSet.getInt("phone_number"));
                deccans.setEmail(resultSet.getString("email"));
                deccans.setUniversitiesId(resultSet.getLong("Universities_id"));
            }

        }catch (SQLException e){
            LOGGER.error(e);
        }finally {
            try {
                assert resultSet != null;
                resultSet.close();
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }

            ConnectionPool.getInstance().putback(connection);
        }
        return deccans;
    }

    @Override
    public void remove(Long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("Delete From deccans where id = ?");
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();


        }catch (SQLException e){
            LOGGER.error(e);
        }finally {
            try {
                assert preparedStatement != null;
                preparedStatement.close();
            } catch (SQLException e) {
               LOGGER.error(e);
            }
            ConnectionPool.getInstance().putback(connection);
        }
    }

    @Override
    public void update(String setParameter, Deccans deccans, Long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        try {
            switch (setParameter) {
                case "name" -> {
                    PreparedStatement preparedStatementName = connection.prepareStatement("update deccans set name = ? where id = ?");
                    preparedStatementName.setString(1, deccans.getName());
                    preparedStatementName.setLong(2, id);
                    preparedStatementName.executeUpdate();
                    preparedStatementName.close();
                }
                case "surname" -> {
                    PreparedStatement preparedStatementSurname = connection.prepareStatement("update deccans set surname = ? where id = ?");
                    preparedStatementSurname.setString(1, deccans.getSurname());
                    preparedStatementSurname.setLong(2, id);
                    preparedStatementSurname.executeUpdate();
                    preparedStatementSurname.close();
                }
                case "age" -> {
                    PreparedStatement preparedStatementAge = connection.prepareStatement("update deccans set age = ? where id = ?");
                    preparedStatementAge.setDate(1, deccans.getAge());
                    preparedStatementAge.setLong(2, id);
                    preparedStatementAge.executeUpdate();
                    preparedStatementAge.close();
                }
                case "phone_number" -> {
                    PreparedStatement preparedStatementPhoneNumber = connection.prepareStatement("update deccans set phone_number = ? where id = ?");
                    preparedStatementPhoneNumber.setInt(1, deccans.getPhone_number());
                    preparedStatementPhoneNumber.setLong(2, id);
                    preparedStatementPhoneNumber.executeUpdate();
                    preparedStatementPhoneNumber.close();
                }
                case "address" -> {
                    PreparedStatement preparedStatementAddress = connection.prepareStatement("update deccans set address = ? where id = ?");
                    preparedStatementAddress.setString(1, deccans.getAddress());
                    preparedStatementAddress.setLong(2, id);
                    preparedStatementAddress.executeUpdate();
                    preparedStatementAddress.close();
                }
                case "email" -> {
                    PreparedStatement preparedStatementEmail = connection.prepareStatement("update deccans set email = ? where id = ?");
                    preparedStatementEmail.setString(1, deccans.getEmail());
                    preparedStatementEmail.setLong(2, id);
                    preparedStatementEmail.executeUpdate();
                    preparedStatementEmail.close();
                }
                case "Universities_id" -> {
                    PreparedStatement preparedStatementUniversitiesId = connection.prepareStatement("Update deccans SET Universities_id = ? WHERE id = ?");
                    preparedStatementUniversitiesId.setLong(1, deccans.getUniversitiesId());
                    preparedStatementUniversitiesId.setLong(2, id);
                    preparedStatementUniversitiesId.executeUpdate();
                    preparedStatementUniversitiesId.close();
                }
                case "all" -> {
                    PreparedStatement preparedStatementAll = connection.prepareStatement("update deccans set name = ? , surname = ?, age = ?, address = ?, phone_number= ?, email = ?, Universities_id= ? where id = ?");
                    preparedStatementAll.setString(1, deccans.getName());
                    preparedStatementAll.setString(2, deccans.getSurname());
                    preparedStatementAll.setDate(3, deccans.getAge());
                    preparedStatementAll.setString(4, deccans.getAddress());
                    preparedStatementAll.setInt(5, deccans.getPhone_number());
                    preparedStatementAll.setString(6, deccans.getEmail());
                    preparedStatementAll.setLong(7, deccans.getUniversitiesId());
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
    public List<Deccans> getAllDeccans() {
        Connection connection = ConnectionPool.getInstance().retrieve();
        List<Deccans> deccansList = new ArrayList<>();
        Statement statement=null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select * from deccans");
            while (resultSet.next()){
                Deccans deccans = new Deccans();

                deccans.setId(resultSet.getLong("id"));
                deccans.setName(resultSet.getString("name"));
                deccans.setSurname(resultSet.getString("surname"));
                deccans.setAge(resultSet.getDate("age"));
                deccans.setAddress(resultSet.getString("address"));
                deccans.setPhone_number(resultSet.getInt("phone_number"));
                deccans.setEmail(resultSet.getString("email"));
                deccans.setUniversitiesId(resultSet.getLong("Universities_id"));

                deccansList.add(deccans);
            }

        }catch (SQLException e){
            LOGGER.error(e);
        }finally {
            try {
                assert statement != null;
                statement.close();
                assert resultSet != null;
                resultSet.close();
            } catch (SQLException e) {
               LOGGER.error(e);
            }
            ConnectionPool.getInstance().putback(connection);
        }
        return deccansList;
    }
}
