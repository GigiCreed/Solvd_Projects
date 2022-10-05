package solvd.projects.database.dao.jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.dao.interfaces.IViceRectorsDAO;
import solvd.projects.database.dao.connectionpool.ConnectionPool;
import solvd.projects.database.models.ViceRectors;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ViceRectorsDAO extends AbstractMySqlDAO implements IViceRectorsDAO {
    private static final Logger LOGGER = LogManager.getLogger(ViceRectorsDAO.class);


    @Override
    public ViceRectors getById(Long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        ViceRectors viceRectors = new ViceRectors();
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
    public void insert(ViceRectors object) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement =connection.prepareStatement("insert into vice_rectors (name,surname,age,phone_number,address,email,Universities_id)  values ( ?,?,?,?,?,?,?)");
            preparedStatement.setString(1,object.getName());
            preparedStatement.setString(2,object.getSurname());
            preparedStatement.setDate(3,object.getAge());
            preparedStatement.setInt(4,object.getPhoneNumber());
            preparedStatement.setString(5,object.getAddress());
            preparedStatement.setString(6, object.getEmail());
            preparedStatement.setLong(7,object.getUniversitiesId());
            preparedStatement.executeUpdate();

            LOGGER.info("Insert Completed!!!!!");

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
    public void update(ViceRectors object) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("update vice_rectors set name = ? , surname = ?, age = ?, phone_number= ?, address = ?, email = ?, Universities_id = ? where id = ?");
            preparedStatement.setString(1, object.getName());
            preparedStatement.setString(2, object.getSurname());
            preparedStatement.setDate(3, object.getAge());
            preparedStatement.setInt(4, object.getPhoneNumber());
            preparedStatement.setString(5, object.getAddress());
            preparedStatement.setString(6, object.getEmail());
            preparedStatement.setLong(7, object.getUniversitiesId());
            preparedStatement.setLong(8, object.getId());
            preparedStatement.executeUpdate();

            LOGGER.info("Update Completed!!!!!");

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
            preparedStatement = connection.prepareStatement("Delete From vice_rectors where id = ?");
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();

            LOGGER.info("Delete completed");

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
