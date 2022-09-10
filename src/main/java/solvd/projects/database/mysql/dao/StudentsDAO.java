package solvd.projects.database.mysql.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.interfaces.IStudentsDAO;
import solvd.projects.database.mysql.AbstractMySqlDAO;
import solvd.projects.database.mysql.connectionpool.ConnectionPool;
import solvd.projects.database.tableclasses.Students;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentsDAO extends AbstractMySqlDAO implements IStudentsDAO {
    private static final Logger LOGGER = LogManager.getLogger(StudentsDAO.class);
    @Override
    public void create(Students students) {
        try {
            Connection connection = ConnectionPool.getInstance().retrieve();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into students (name,surname,age,phone_number,course,email,Universities_id,Faculties_id)  values ( ?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1,students.getName());
            preparedStatement.setString(2,students.getSurname());
            preparedStatement.setDate(3, students.getAge());
            preparedStatement.setInt(4,students.getPhone_number());
            preparedStatement.setInt(5,students.getCourse());
            preparedStatement.setString(6,students.getEmail());
            preparedStatement.setLong(7,students.getUniversitiesId());
            preparedStatement.setLong(8,students.getFacultiesId());
            preparedStatement.executeUpdate();

            connection.close();
            preparedStatement.close();
        } catch (SQLException e){
            LOGGER.error(e);
        }
    }

    @Override
    public Students getBy(Students students, Long id) {
        try {
            Connection connection = ConnectionPool.getInstance().retrieve();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from students Where id = ?");
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                students.setId(resultSet.getLong("id"));
                students.setName(resultSet.getString("name"));
                students.setSurname(resultSet.getString("surname"));
                students.setAge(resultSet.getDate("age"));
                students.setPhone_number(resultSet.getInt("phone_number"));
                students.setCourse(resultSet.getInt("course"));
                students.setEmail(resultSet.getString("email"));
                students.setUniversitiesId(resultSet.getLong("Universities_id"));
                students.setFacultiesId(resultSet.getLong("Faculties_id"));
            }
            connection.close();
            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return students;
    }



    @Override
    public void remove(Long id) {
        try {
            Connection connection = ConnectionPool.getInstance().retrieve();
            PreparedStatement preparedStatement = connection.prepareStatement("Delete from students Where id = ?");
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();

            connection.close();
            preparedStatement.close();
        }catch (SQLException e){
            LOGGER.error(e);
        }

    }

    @Override
    public void update(String setParameter,Students object, Long id) {
        try {
            Connection connection = ConnectionPool.getInstance().retrieve();
            switch (setParameter) {
                case "name":PreparedStatement preparedStatementName = connection.prepareStatement("Update students SET name = ? WHERE id = ?");
                    preparedStatementName.setString(1, object.getName());
                    preparedStatementName.setLong(2, id);
                    preparedStatementName.executeUpdate();
                    preparedStatementName.close();
                    break;
                case "surname":
                    PreparedStatement preparedStatementSurname = connection.prepareStatement("Update students SET surname = ? WHERE id = ?");
                    preparedStatementSurname.setString(1, object.getSurname());
                    preparedStatementSurname.setLong(2, id);
                    preparedStatementSurname.executeUpdate();
                    preparedStatementSurname.close();
                    break;
                case "age":
                    PreparedStatement preparedStatementAge = connection.prepareStatement("Update students SET age = ? WHERE id = ?");
                    preparedStatementAge.setDate(1, object.getAge());
                    preparedStatementAge.setLong(2, id);
                    preparedStatementAge.executeUpdate();
                    preparedStatementAge.close();
                    break;
                case "phone_number":
                    PreparedStatement preparedStatementPhoneNumber = connection.prepareStatement("Update students SET phone_number = ? WHERE id = ?");
                    preparedStatementPhoneNumber.setInt(1, object.getPhone_number());
                    preparedStatementPhoneNumber.setLong(2, id);
                    preparedStatementPhoneNumber.executeUpdate();
                    preparedStatementPhoneNumber.close();
                    break;
                case "course":
                    PreparedStatement preparedStatementCourse = connection.prepareStatement("Update students SET course = ? WHERE id = ?");
                    preparedStatementCourse.setInt(1, object.getCourse());
                    preparedStatementCourse.setLong(2, id);
                    preparedStatementCourse.executeUpdate();
                    preparedStatementCourse.close();
                    break;
                case "email":
                    PreparedStatement preparedStatementEmail = connection.prepareStatement("Update students SET email = ? WHERE id = ?");
                    preparedStatementEmail.setString(1, object.getEmail());
                    preparedStatementEmail.setLong(2, id);
                    preparedStatementEmail.executeUpdate();
                    preparedStatementEmail.close();
                    break;
                case "Universities_id":
                    PreparedStatement preparedStatementUniversitiesId = connection.prepareStatement("Update students SET Universities_id = ? WHERE id = ?");
                    preparedStatementUniversitiesId.setLong(1, object.getUniversitiesId());
                    preparedStatementUniversitiesId.setLong(2, id);
                    preparedStatementUniversitiesId.executeUpdate();
                    preparedStatementUniversitiesId.close();
                    break;
                case "Faculties_id":
                    PreparedStatement preparedStatementFacultiesId = connection.prepareStatement("Update students SET Faculties_id = ? WHERE id = ?");
                    preparedStatementFacultiesId.setLong(1, object.getFacultiesId());
                    preparedStatementFacultiesId.setLong(2, id);
                    preparedStatementFacultiesId.executeUpdate();
                    preparedStatementFacultiesId.close();
                    break;
                case "all":
                    PreparedStatement preparedStatementAll = connection.prepareStatement("Update students SET name = ?, surname = ?, age = ?, phone_number = ?, course = ?, email = ?, Universities_id = ?, Faculties_id = ?  WHERE id = ?");
                    preparedStatementAll.setString(1, object.getName());
                    preparedStatementAll.setString(2, object.getSurname());
                    preparedStatementAll.setDate(3, object.getAge());
                    preparedStatementAll.setInt(4,object.getPhone_number());
                    preparedStatementAll.setInt(5,object.getCourse());
                    preparedStatementAll.setString(6,object.getEmail());
                    preparedStatementAll.setLong(7,object.getUniversitiesId());
                    preparedStatementAll.setLong(8,object.getFacultiesId());
                    preparedStatementAll.setLong(9, id);
                    preparedStatementAll.executeUpdate();
                    preparedStatementAll.close();
                    break;
                default:
                    LOGGER.error("Not exist this parameter");
            }
            connection.close();

        }catch (SQLException e){
            LOGGER.error(e);
        }
    }

    @Override
    public List<Students> getAllStudents() {
        List<Students> students = new ArrayList<>();
        try {
            Connection connection = ConnectionPool.getInstance().retrieve();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * From students");
            while (resultSet.next()){
                Students s =new Students();
                s.setId(resultSet.getLong("id"));
                s.setName(resultSet.getString("name"));
                s.setSurname(resultSet.getString("surname"));
                s.setAge(resultSet.getDate("age"));
                s.setPhone_number(resultSet.getInt("phone_number"));
                s.setCourse(resultSet.getInt("course"));
                s.setEmail(resultSet.getString("email"));
                s.setUniversitiesId(resultSet.getLong("Universities_id"));
                s.setFacultiesId(resultSet.getLong("Faculties_id"));

                students.add(s);
            }
           connection.close();
            statement.close();
            resultSet.close();

        }catch (SQLException e){
            LOGGER.error(e);
        }
        return students;
    }

}
