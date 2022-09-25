package solvd.projects.database.service.jdbc.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.service.jdbc.dao.interfaces.ISpecialtiesDAO;
import solvd.projects.database.service.jdbc.AbstractMySqlDAO;
import solvd.projects.database.service.jdbc.connectionpool.ConnectionPool;
import solvd.projects.database.tableclasses.Specialties;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SpecialtiesDAO extends AbstractMySqlDAO implements ISpecialtiesDAO {

    private static final Logger LOGGER = LogManager.getLogger(SpecialtiesDAO.class);

    @Override
    public void create(Specialties specialties) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement =null;
        try {
            preparedStatement = connection.prepareStatement("insert into specialties (name,Faculties_id) Values (?,?)");
            preparedStatement.setString(1,specialties.getName());
            preparedStatement.setLong(2,specialties.getFacultiesId());
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
    public Specialties getBy(Specialties specialties, Long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
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
    public void remove(Long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement= null;
        try {
            preparedStatement = connection.prepareStatement("delete from specialties where id = ?");
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
    public void update(String setParameter, Specialties specialties, Long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        try {
            switch (setParameter) {
                case "name" -> {
                    PreparedStatement preparedStatementName = connection.prepareStatement("Update specialties Set name = ? where id = ?");
                    preparedStatementName.setString(1, specialties.getName());
                    preparedStatementName.setLong(2, id);
                    preparedStatementName.executeUpdate();
                    preparedStatementName.close();
                }
                case "Faculties_id" -> {
                    PreparedStatement preparedStatementFacultiesId = connection.prepareStatement("Update specialties Set Faculties_id = ? where id = ?");
                    preparedStatementFacultiesId.setLong(1, specialties.getFacultiesId());
                    preparedStatementFacultiesId.setLong(2, id);
                    preparedStatementFacultiesId.executeUpdate();
                    preparedStatementFacultiesId.close();
                }
                case "all" -> {
                    PreparedStatement preparedStatementAll = connection.prepareStatement("Update specialties Set name = ?, Faculties_id = ? where id = ?");
                    preparedStatementAll.setString(1, specialties.getName());
                    preparedStatementAll.setLong(2, specialties.getFacultiesId());
                    preparedStatementAll.setLong(3, id);
                    preparedStatementAll.executeUpdate();
                    preparedStatementAll.close();
                }
                default -> LOGGER.error("Parameter not exist");
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }finally {
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
