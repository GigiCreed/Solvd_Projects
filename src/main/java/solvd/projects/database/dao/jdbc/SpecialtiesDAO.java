package solvd.projects.database.dao.jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.dao.interfaces.ISpecialtiesDAO;
import solvd.projects.database.dao.connectionpool.ConnectionPool;
import solvd.projects.database.models.Specialties;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SpecialtiesDAO extends AbstractMySqlDAO implements ISpecialtiesDAO {

    private static final Logger LOGGER = LogManager.getLogger(SpecialtiesDAO.class);


    @Override
    public Specialties getById(Long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        Specialties specialties = new Specialties();
        try {
            preparedStatement = connection.prepareStatement("Select * from specialties Where id = ?");
            preparedStatement.setLong(1,id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                specialties.setId(resultSet.getLong("id"));
                specialties.setName(resultSet.getString("name"));
                specialties.setFacultiesId(resultSet.getLong("Faculties_id"));
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
        return specialties;
    }

    @Override
    public void insert(Specialties object) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement =null;
        try {
            preparedStatement = connection.prepareStatement("insert into specialties (name,Faculties_id) Values (?,?)");
            preparedStatement.setString(1,object.getName());
            preparedStatement.setLong(2,object.getFacultiesId());
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
    public void update(Specialties object) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("Update specialties Set name = ?, Faculties_id = ? where id = ?");
            preparedStatement.setString(1, object.getName());
            preparedStatement.setLong(2, object.getFacultiesId());
            preparedStatement.setLong(3, object.getId());
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
        PreparedStatement preparedStatement= null;
        try {
            preparedStatement = connection.prepareStatement("delete from specialties where id = ?");
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();

           LOGGER.info("Delete Completed!!!!!");
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
    public List<Specialties> getAllSpecialties() {
        Connection connection = ConnectionPool.getInstance().retrieve();
        List<Specialties> specialtiesList = new ArrayList<>();
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select * from specialties");
            while (resultSet.next()) {
                Specialties specialties = new Specialties();
                specialties.setId(resultSet.getLong("id"));
                specialties.setName(resultSet.getString("name"));
                specialties.setFacultiesId(resultSet.getLong("Faculties_id"));

                specialtiesList.add(specialties);
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
        return specialtiesList;
    }
}
