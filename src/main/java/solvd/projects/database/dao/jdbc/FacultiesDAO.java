package solvd.projects.database.dao.jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.dao.interfaces.IFacultiesDAO;
import solvd.projects.database.dao.connectionpool.ConnectionPool;
import solvd.projects.database.models.Faculties;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacultiesDAO extends AbstractMySqlDAO implements IFacultiesDAO {
    private static final Logger LOGGER = LogManager.getLogger(FacultiesDAO.class);


    @Override
    public Faculties getById(Long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet =null;
        Faculties faculties = new Faculties();
        try {
            preparedStatement = connection.prepareStatement("Select * from faculties Where id = ?");
            preparedStatement.setLong(1,id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                faculties.setId(resultSet.getLong("id"));
                faculties.setName(resultSet.getString("name"));
                faculties.setUniversitiesId(resultSet.getLong("Universities_id"));
                faculties.setDeccansId(resultSet.getLong("Deccans_id"));
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
        return faculties;
    }

    @Override
    public void insert(Faculties object) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement =null;
        try {
            preparedStatement = connection.prepareStatement("insert into faculties (name,Universities_id,Deccans_id) Values (?,?,?)");
            preparedStatement.setString(1,object.getName());
            preparedStatement.setLong(2,object.getUniversitiesId());
            preparedStatement.setLong(3,object.getDeccansId());
            preparedStatement.executeUpdate();

            LOGGER.info("Insert Completed");

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
    public void update(Faculties object) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("Update faculties Set name = ?, Universities_id = ?, Deccans_id = ? where id = ?");
            preparedStatement.setString(1, object.getName());
            preparedStatement.setLong(2, object.getUniversitiesId());
            preparedStatement.setLong(3,object.getDeccansId());
            preparedStatement.setLong(4, object.getId());
            preparedStatement.executeUpdate();


            LOGGER.info("Update Completed");
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
    public void delete(Long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("delete from faculties where id = ?");
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
    public List<Faculties> getAllFaculties() {
        Connection connection = ConnectionPool.getInstance().retrieve();
        List<Faculties> facultiesList = new ArrayList<>();
        Statement statement =null;
        ResultSet resultSet =null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select * from faculties");
            while (resultSet.next()) {
                Faculties faculties = new Faculties();
                faculties.setId(resultSet.getLong("id"));
                faculties.setName(resultSet.getString("name"));
                faculties.setUniversitiesId(resultSet.getLong("Universities_id"));
                faculties.setDeccansId(resultSet.getLong("Deccans_id"));

                facultiesList.add(faculties);
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

        return facultiesList;
    }
}
