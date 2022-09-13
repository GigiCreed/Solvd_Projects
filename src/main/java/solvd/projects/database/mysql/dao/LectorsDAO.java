package solvd.projects.database.mysql.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.mysql.dao.interfaces.ILectorsDAO;
import solvd.projects.database.mysql.AbstractMySqlDAO;
import solvd.projects.database.mysql.connectionpool.ConnectionPool;
import solvd.projects.database.tableclasses.Lectors;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LectorsDAO extends AbstractMySqlDAO implements ILectorsDAO {
    private static final Logger LOGGER = LogManager.getLogger(LectorsDAO.class);

    private Connection connection = ConnectionPool.getInstance().retrieve();
    @Override
    public void create(Lectors lectors) {
        PreparedStatement preparedStatement=null;
        try {

            preparedStatement = connection.prepareStatement("insert into lectors (name,surname,age,phone_number,address,email,Universities_id)  values ( ?,?,?,?,?,?,?)");
            preparedStatement.setString(1,lectors.getName());
            preparedStatement.setString(2,lectors.getSurname());
            preparedStatement.setDate(3,lectors.getAge());
            preparedStatement.setInt(4,lectors.getPhone_number());
            preparedStatement.setString(5,lectors.getAddress());
            preparedStatement.setString(6, lectors.getEmail());
            preparedStatement.setLong(7,lectors.getUniversitiesId());
            preparedStatement.executeUpdate();



        }catch (SQLException e){
             LOGGER.error(e);
        }finally {
            try {
                preparedStatement.close();
            }catch (SQLException e){
                LOGGER.error(e);
            }
            ConnectionPool.getInstance().putback(connection);
        }
    }

    @Override
    public Lectors getBy(Lectors lectors, Long id) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement =connection.prepareStatement("Select * from lectors where id = ?");
            preparedStatement.setLong(1,id);
            resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                lectors.setId(resultSet.getLong("id"));
                lectors.setName(resultSet.getString("name"));
                lectors.setSurname(resultSet.getString("surname"));
                lectors.setAge(resultSet.getDate("age"));
                lectors.setPhone_number(resultSet.getInt("phone_number"));
                lectors.setAddress(resultSet.getString("address"));
                lectors.setEmail(resultSet.getString("email"));
                lectors.setUniversitiesId(resultSet.getLong("Universities_id"));
            }


        }catch (SQLException e){
            LOGGER.error(e);
        }finally {
           try {
               preparedStatement.close();
               resultSet.close();
           }catch (SQLException e){
               LOGGER.error(e);
           }
           ConnectionPool.getInstance().putback(connection);
        }
        return lectors;
    }

    @Override
    public void remove(Long id) {
        PreparedStatement preparedStatement =null;
        try {
            preparedStatement = connection.prepareStatement("Delete From lectors where id = ?");
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();


        }catch (SQLException e){
            LOGGER.error(e);
        }finally {
            try {
                preparedStatement.close();
            }catch (SQLException e){
                LOGGER.error(e);
            }
            ConnectionPool.getInstance().putback(connection);
        }
    }

    @Override
    public void update(String setParameter, Lectors lectors, Long id) {
        try {

            switch (setParameter){
                case "name":PreparedStatement preparedStatementName =connection.prepareStatement("update lectors set name = ? where id = ?");
                    preparedStatementName.setString(1,lectors.getName());
                    preparedStatementName.setLong(2,id);
                    preparedStatementName.executeUpdate();
                    preparedStatementName.close();
                    break;
                case "surname":PreparedStatement preparedStatementSurname = connection.prepareStatement("update lectors set surname = ? where id = ?");
                    preparedStatementSurname.setString(1,lectors.getSurname());
                    preparedStatementSurname.setLong(2,id);
                    preparedStatementSurname.executeUpdate();
                    preparedStatementSurname.close();
                    break;
                case "age":PreparedStatement preparedStatementAge = connection.prepareStatement("update lectors set age = ? where id = ?");
                    preparedStatementAge.setDate(1,lectors.getAge());
                    preparedStatementAge.setLong(2,id);
                    preparedStatementAge.executeUpdate();
                    preparedStatementAge.close();
                    break;
                case "phone_number":PreparedStatement preparedStatementPhoneNumber = connection.prepareStatement("update lectors set phone_number = ? where id = ?");
                    preparedStatementPhoneNumber.setInt(1,lectors.getPhone_number());
                    preparedStatementPhoneNumber.setLong(2,id);
                    preparedStatementPhoneNumber.executeUpdate();
                    preparedStatementPhoneNumber.close();
                    break;
                case "address":PreparedStatement preparedStatementAddress = connection.prepareStatement("update lectors set address = ? where id = ?");
                    preparedStatementAddress.setString(1,lectors.getAddress());
                    preparedStatementAddress.setLong(2,id);
                    preparedStatementAddress.executeUpdate();
                    preparedStatementAddress.close();
                    break;
                case "email":PreparedStatement preparedStatementEmail = connection.prepareStatement("update lectors set email = ? where id = ?");
                    preparedStatementEmail.setString(1,lectors.getEmail());
                    preparedStatementEmail.setLong(2,id);
                    preparedStatementEmail.executeUpdate();
                    preparedStatementEmail.close();
                    break;
                case "Universities_id":
                    PreparedStatement preparedStatementUniversitiesId = connection.prepareStatement("Update lectors SET Universities_id = ? WHERE id = ?");
                    preparedStatementUniversitiesId.setLong(1, lectors.getUniversitiesId());
                    preparedStatementUniversitiesId.setLong(2, id);
                    preparedStatementUniversitiesId.executeUpdate();
                    preparedStatementUniversitiesId.close();
                    break;
                case "all":PreparedStatement preparedStatementAll = connection.prepareStatement("update lectors set name = ? , surname = ?, age = ?, phone_number= ?, address = ?, email = ?, Universities_id= ? where id = ?");
                    preparedStatementAll.setString(1,lectors.getName());
                    preparedStatementAll.setString(2,lectors.getSurname());
                    preparedStatementAll.setDate(3,lectors.getAge());
                    preparedStatementAll.setInt(4,lectors.getPhone_number());
                    preparedStatementAll.setString(5,lectors.getAddress());
                    preparedStatementAll.setString(6,lectors.getEmail());
                    preparedStatementAll.setLong(7,lectors.getUniversitiesId());
                    preparedStatementAll.setLong(8,id);
                    preparedStatementAll.executeUpdate();
                    preparedStatementAll.close();
                    break;
                default:
                    LOGGER.error("Parameter don't exist");
            }


        }catch (SQLException e){
            LOGGER.error(e);
        }finally {
            ConnectionPool.getInstance().putback(connection);
        }
    }

    @Override
    public List<Lectors> getAllLectors() {
        List<Lectors> lectorsList = new ArrayList<>();
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select * from lectors");
            while (resultSet.next()){
                Lectors lectors = new Lectors();

                lectors.setId(resultSet.getLong("id"));
                lectors.setName(resultSet.getString("name"));
                lectors.setSurname(resultSet.getString("surname"));
                lectors.setAge(resultSet.getDate("age"));
                lectors.setPhone_number(resultSet.getInt("phone_number"));
                lectors.setAddress(resultSet.getString("address"));
                lectors.setEmail(resultSet.getString("email"));
                lectors.setUniversitiesId(resultSet.getLong("Universities_id"));

                lectorsList.add(lectors);
            }

        }catch (SQLException e){
            LOGGER.error(e);
        }finally {
            try {
                statement.close();
                resultSet.close();
            }catch (SQLException e){
                LOGGER.error(e);
            }
            ConnectionPool.getInstance().putback(connection);
        }
        return lectorsList;
    }
}
