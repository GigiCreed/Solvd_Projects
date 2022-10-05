package solvd.projects.database.dao.jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.dao.interfaces.IUniversitiesDAO;
import solvd.projects.database.dao.connectionpool.ConnectionPool;
import solvd.projects.database.models.Universities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UniversitiesDAO extends AbstractMySqlDAO implements IUniversitiesDAO {
    private static final Logger LOGGER = LogManager.getLogger(UniversitiesDAO.class);


    @Override
    public Universities getById(Long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        Universities universities = new Universities();
        try {
            preparedStatement = connection.prepareStatement("select * from universities Where id = ?");
            preparedStatement.setLong(1,id);
            resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                universities.setId(resultSet.getLong("id"));
                universities.setName(resultSet.getString("name"));
                universities.setAddress(resultSet.getString("address"));
                universities.setSiteAddress(resultSet.getString("site_address"));
                universities.setEmail(resultSet.getString("email"));

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
        return universities;
    }

    @Override
    public void insert(Universities object) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement = null;
        try {

            preparedStatement =connection.prepareStatement("insert into universities (name,address,site_address,email) Values (?,?,?,?)");
            preparedStatement.setString(1,object.getName());
            preparedStatement.setString(2,object.getAddress());
            preparedStatement.setString(3,object.getSiteAddress());
            preparedStatement.setString(4,object.getEmail());
            preparedStatement.executeUpdate();

            LOGGER.info("Insert Completed!!!!");

        } catch (SQLException e){
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
    public void update(Universities object) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("Update universities Set name = ?, address = ?, site_address = ?, email = ? Where id = ?");
            preparedStatement.setString(1, object.getName());
            preparedStatement.setString(2, object.getAddress());
            preparedStatement.setString(3, object.getSiteAddress());
            preparedStatement.setString(4, object.getEmail());
            preparedStatement.setLong(5, object.getId());
            preparedStatement.executeUpdate();

            LOGGER.info("Update completed!!!!");

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
            preparedStatement = connection.prepareStatement("Delete From universities where id = ?");
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();

             LOGGER.info("Delete completed!!!!");
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
    public List<Universities> getAllUniversities() {
        Connection connection = ConnectionPool.getInstance().retrieve();
        List<Universities> universitiesList = new ArrayList<>();
        Statement statement=null;
        ResultSet resultSet=null;

        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select * from universities");
            while (resultSet.next()){
                Universities universities = new Universities();
                universities.setId(resultSet.getLong("id"));
                universities.setName(resultSet.getString("name"));
                universities.setAddress(resultSet.getString("address"));
                universities.setSiteAddress(resultSet.getString("site_address"));
                universities.setEmail(resultSet.getString("email"));

                universitiesList.add(universities);
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
        return universitiesList;
    }
}
