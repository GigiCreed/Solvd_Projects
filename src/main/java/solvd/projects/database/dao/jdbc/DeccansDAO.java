package solvd.projects.database.dao.jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.dao.interfaces.IDeccansDAO;
import solvd.projects.database.dao.connectionpool.ConnectionPool;
import solvd.projects.database.models.Deccans;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeccansDAO extends AbstractMySqlDAO implements IDeccansDAO {
    private static final Logger LOGGER = LogManager.getLogger(DeccansDAO.class);


    @Override
    public Deccans getById(Long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet =null;
        Deccans deccans = new Deccans();
        try {
            preparedStatement = connection.prepareStatement("Select * from deccans Where id = ?");
            preparedStatement.setLong(1,id);
            resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                deccans.setId(resultSet.getLong("id"));
                deccans.setName(resultSet.getString("name"));
                deccans.setSurname(resultSet.getString("surname"));
                deccans.setAge(resultSet.getDate("age"));
                deccans.setAddress(resultSet.getString("address"));
                deccans.setPhoneNumber(resultSet.getInt("phone_number"));
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
            }catch (SQLException e){
                LOGGER.error(e);
            }
            ConnectionPool.getInstance().putback(connection);
        }
         return deccans;
    }

    @Override
    public void insert(Deccans object) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement
            ("Insert into deccans (name,surname,age,address,phone_number,email,Universities_id) Values (?,?,?,?,?,?,?)");
            preparedStatement.setString(1,object.getName());
            preparedStatement.setString(2,object.getSurname());
            preparedStatement.setDate(3,object.getAge());
            preparedStatement.setString(4,object.getAddress());
            preparedStatement.setInt(5,object.getPhoneNumber());
            preparedStatement.setString(6,object.getEmail());
            preparedStatement.setLong(7,object.getUniversitiesId());

            preparedStatement.executeUpdate();

            LOGGER.info("Insert Completed");

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
    public void update(Deccans object) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement
                    ("update deccans set name = ? , surname = ?, age = ?, address = ?, phone_number= ?, email = ?, Universities_id= ? where id = ?");
            preparedStatement.setString(1, object.getName());
            preparedStatement.setString(2, object.getSurname());
            preparedStatement.setDate(3, object.getAge());
            preparedStatement.setString(4, object.getAddress());
            preparedStatement.setInt(5, object.getPhoneNumber());
            preparedStatement.setString(6, object.getEmail());
            preparedStatement.setLong(7, object.getUniversitiesId());
            preparedStatement.setLong(8, object.getId());
            preparedStatement.executeUpdate();

            LOGGER.info("Update Completed !!!!!");
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
    public void delete(Long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("Delete From deccans where id = ?");
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();

            LOGGER.info("Delete Completed");
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
                deccans.setPhoneNumber(resultSet.getInt("phone_number"));
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
