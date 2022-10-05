package solvd.projects.database.dao.jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.dao.interfaces.IRectorsDAO;
import solvd.projects.database.dao.connectionpool.ConnectionPool;
import solvd.projects.database.models.Rectors;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RectorsDAO extends AbstractMySqlDAO implements IRectorsDAO {
    private static final Logger LOGGER = LogManager.getLogger(RectorsDAO.class);

    @Override
    public Rectors getById(Long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        Rectors rectors = new Rectors();
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
                rectors.setUniversitiesId(resultSet.getLong("Universities_id"));
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
    public void insert(Rectors object) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement =connection.prepareStatement("insert into rectors (name,surname,age,phone_number,address,email,Universities_id)  values ( ?,?,?,?,?,?,?)");
            preparedStatement.setString(1,object.getName());
            preparedStatement.setString(2,object.getSurname());
            preparedStatement.setDate(3,object.getAge());
            preparedStatement.setInt(4,object.getPhoneNumber());
            preparedStatement.setString(5,object.getAddress());
            preparedStatement.setString(6, object.getEmail());
            preparedStatement.setLong(7,object.getUniversitiesId());
            preparedStatement.executeUpdate();

            LOGGER.info("Insert Completed!!!!");

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
    public void update(Rectors object) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("update rectors set name = ? , surname = ?, age = ?, phone_number= ?, address = ?, email = ?, Universities_id = ? where id = ?");
            preparedStatement.setString(1, object.getName());
            preparedStatement.setString(2, object.getSurname());
            preparedStatement.setDate(3, object.getAge());
            preparedStatement.setInt(4, object.getPhoneNumber());
            preparedStatement.setString(5, object.getAddress());
            preparedStatement.setString(6, object.getEmail());
            preparedStatement.setLong(7, object.getUniversitiesId());
            preparedStatement.setLong(8, object.getId());
            preparedStatement.executeUpdate();

            LOGGER.info("Update Completed!!!!");
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
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement = connection.prepareStatement("Delete From rectors where id = ?");
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();

            LOGGER.info("Delete Completed");

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
                rectors.setUniversitiesId(resultSet.getLong("Universities_id"));

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
