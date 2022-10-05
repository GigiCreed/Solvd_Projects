package solvd.projects.database.dao.jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.dao.interfaces.ISubjectsDAO;
import solvd.projects.database.dao.connectionpool.ConnectionPool;
import solvd.projects.database.models.Subjects;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectsDAO extends AbstractMySqlDAO implements ISubjectsDAO {
    private static final Logger LOGGER = LogManager.getLogger(SubjectsDAO.class);

    @Override
    public Subjects getById(Long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        Subjects subjects = new Subjects();
        try {
            preparedStatement = connection.prepareStatement("Select * from subjects Where id = ?");
            preparedStatement.setLong(1,id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                subjects.setId(resultSet.getLong("id"));
                subjects.setName(resultSet.getString("name"));
                subjects.setCourse(resultSet.getInt("course"));
                subjects.setSpecialtiesId(resultSet.getLong("Specialties_id"));
            }

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
        return subjects;
    }

    @Override
    public void insert(Subjects object) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("Insert into subjects (name,course,Specialties_id) values (?,?,?)");
            preparedStatement.setString(1,object.getName());
            preparedStatement.setInt(2,object.getCourse());
            preparedStatement.setLong(3,object.getSpecialtiesId());
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
    public void update(Subjects object) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("Update subjects Set name = ?, course = ?, Specialties_id = ? where id = ?");
            preparedStatement.setString(1, object.getName());
            preparedStatement.setInt(2, object.getCourse());
            preparedStatement.setLong(3, object.getSpecialtiesId());
            preparedStatement.setLong(4, object.getId());
            preparedStatement.executeUpdate();

            LOGGER.info("Update Completed");
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
            preparedStatement = connection.prepareStatement("Delete from subjects where id = ?");
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
    public List<Subjects> getAllSubjects() {
        Connection connection = ConnectionPool.getInstance().retrieve();
        List<Subjects> subjectsList = new ArrayList<>();
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from subjects");
            while (resultSet.next()){
                Subjects subjects = new Subjects();

                subjects.setId(resultSet.getLong("id"));
                subjects.setName(resultSet.getString("name"));
                subjects.setCourse(resultSet.getInt("course"));
                subjects.setSpecialtiesId(resultSet.getLong("Specialties_id"));

                subjectsList.add(subjects);
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
        return subjectsList;
    }
}
