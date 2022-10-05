package solvd.projects.database.dao.jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.dao.interfaces.ILectorsDAO;
import solvd.projects.database.dao.connectionpool.ConnectionPool;
import solvd.projects.database.models.Lectors;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LectorsDAO extends AbstractMySqlDAO implements ILectorsDAO {
    private static final Logger LOGGER = LogManager.getLogger(LectorsDAO.class);


    @Override
    public Lectors getById(Long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Lectors lectors = new Lectors();
        try {
            preparedStatement =connection.prepareStatement("Select * from lectors where id = ?");
            preparedStatement.setLong(1,id);
            resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                lectors.setId(resultSet.getLong("id"));
                lectors.setName(resultSet.getString("name"));
                lectors.setSurname(resultSet.getString("surname"));
                lectors.setAge(resultSet.getDate("age"));
                lectors.setPhoneNumber(resultSet.getInt("phone_number"));
                lectors.setAddress(resultSet.getString("address"));
                lectors.setEmail(resultSet.getString("email"));
                lectors.setUniversitiesId(resultSet.getLong("Universities_id"));
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
        return lectors;
    }

    @Override
    public void insert(Lectors object) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement=null;
        try {

            preparedStatement = connection.prepareStatement("insert into lectors (name,surname,age,phone_number,address,email,Universities_id)  values ( ?,?,?,?,?,?,?)");
            preparedStatement.setString(1,object.getName());
            preparedStatement.setString(2,object.getSurname());
            preparedStatement.setDate(3,object.getAge());
            preparedStatement.setInt(4,object.getPhoneNumber());
            preparedStatement.setString(5,object.getAddress());
            preparedStatement.setString(6, object.getEmail());
            preparedStatement.setLong(7,object.getUniversitiesId());
            preparedStatement.executeUpdate();

            LOGGER.info("Insert Completed !!!!!");

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
    public void update(Lectors object) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("update lectors set name = ? , surname = ?, age = ?, phone_number= ?, address = ?, email = ?, Universities_id= ? where id = ?");
            preparedStatement.setString(1, object.getName());
            preparedStatement.setString(2, object.getSurname());
            preparedStatement.setDate(3, object.getAge());
            preparedStatement.setInt(4, object.getPhoneNumber());
            preparedStatement.setString(5, object.getAddress());
            preparedStatement.setString(6, object.getEmail());
            preparedStatement.setLong(7, object.getUniversitiesId());
            preparedStatement.setLong(8, object.getId());
            preparedStatement.executeUpdate();

            LOGGER.info("Update Completed!!!");
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
        PreparedStatement preparedStatement =null;
        try {
            preparedStatement = connection.prepareStatement("Delete From lectors where id = ?");
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();

            LOGGER.info("Delete Completed!!!!");

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
    public List<Lectors> getAllLectors() {
        Connection connection = ConnectionPool.getInstance().retrieve();
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
                lectors.setPhoneNumber(resultSet.getInt("phone_number"));
                lectors.setAddress(resultSet.getString("address"));
                lectors.setEmail(resultSet.getString("email"));
                lectors.setUniversitiesId(resultSet.getLong("Universities_id"));

                lectorsList.add(lectors);
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
        return lectorsList;
    }
}
