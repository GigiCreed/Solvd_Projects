package solvd.projects.database.dao.jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.dao.interfaces.IStudentsDAO;
import solvd.projects.database.dao.connectionpool.ConnectionPool;
import solvd.projects.database.models.Students;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentsDAO extends AbstractMySqlDAO implements IStudentsDAO {
    private static final Logger LOGGER = LogManager.getLogger(StudentsDAO.class);

    @Override
    public Students getById(Long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement =null;
        ResultSet resultSet=null;
        Students students = new Students();
        try {
            preparedStatement = connection.prepareStatement("select * from students Where id = ?");
            preparedStatement.setLong(1,id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                students.setId(resultSet.getLong("id"));
                students.setName(resultSet.getString("name"));
                students.setSurname(resultSet.getString("surname"));
                students.setAge(resultSet.getDate("age"));
                students.setPhoneNumber(resultSet.getInt("phone_number"));
                students.setCourse(resultSet.getInt("course"));
                students.setEmail(resultSet.getString("email"));
                students.setUniversitiesId(resultSet.getLong("Universities_id"));
                students.setFacultiesId(resultSet.getLong("Faculties_id"));
            }

        } catch (SQLException e) {
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
        return students;
    }

    @Override
    public void insert(Students object) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement = null;
        try {

            preparedStatement = connection.prepareStatement("insert into students (name,surname,age,phone_number,course,email,Universities_id,Faculties_id)  values ( ?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1,object.getName());
            preparedStatement.setString(2,object.getSurname());
            preparedStatement.setDate(3, object.getAge());
            preparedStatement.setInt(4,object.getPhoneNumber());
            preparedStatement.setInt(5,object.getCourse());
            preparedStatement.setString(6,object.getEmail());
            preparedStatement.setLong(7,object.getUniversitiesId());
            preparedStatement.setLong(8,object.getFacultiesId());
            preparedStatement.executeUpdate();

            LOGGER.info("Insert Completed!!!!");


        } catch (SQLException e){
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
    public void update(Students object) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("Update students SET name = ?, surname = ?, age = ?, phone_number = ?, course = ?, email = ?, Universities_id = ?, Faculties_id = ?  WHERE id = ?");
            preparedStatement.setString(1, object.getName());
            preparedStatement.setString(2, object.getSurname());
            preparedStatement.setDate(3, object.getAge());
            preparedStatement.setInt(4, object.getPhoneNumber());
            preparedStatement.setInt(5, object.getCourse());
            preparedStatement.setString(6, object.getEmail());
            preparedStatement.setLong(7, object.getUniversitiesId());
            preparedStatement.setLong(8, object.getFacultiesId());
            preparedStatement.setLong(9, object.getId());
            preparedStatement.executeUpdate();

            LOGGER.info("Update completed!!!!!");

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
            preparedStatement = connection.prepareStatement("Delete from students Where id = ?");
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
    public List<Students> getAllStudents() {
        Connection connection = ConnectionPool.getInstance().retrieve();
        List<Students> students = new ArrayList<>();
        Statement statement=null;
        ResultSet resultSet=null;
        try {

            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select * From students");
            while (resultSet.next()){
                Students s =new Students();
                s.setId(resultSet.getLong("id"));
                s.setName(resultSet.getString("name"));
                s.setSurname(resultSet.getString("surname"));
                s.setAge(resultSet.getDate("age"));
                s.setPhoneNumber(resultSet.getInt("phone_number"));
                s.setCourse(resultSet.getInt("course"));
                s.setEmail(resultSet.getString("email"));
                s.setUniversitiesId(resultSet.getLong("Universities_id"));
                s.setFacultiesId(resultSet.getLong("Faculties_id"));

                students.add(s);
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
        return students;
    }

}
