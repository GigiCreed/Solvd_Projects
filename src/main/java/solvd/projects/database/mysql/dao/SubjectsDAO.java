package solvd.projects.database.mysql.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.interfaces.ISubjectsDAO;
import solvd.projects.database.mysql.AbstractMySqlDAO;
import solvd.projects.database.mysql.connectionpool.ConnectionPool;
import solvd.projects.database.tableclasses.Subjects;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectsDAO extends AbstractMySqlDAO implements ISubjectsDAO {
    private static final Logger LOGGER = LogManager.getLogger(SubjectsDAO.class);

    private Connection connection = ConnectionPool.getInstance().retrieve();

    @Override
    public void create(Subjects subjects) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("Insert into subjects (name,course,Specialties_id) values (?,?,?)");
            preparedStatement.setString(1,subjects.getName());
            preparedStatement.setInt(2,subjects.getCourse());
            preparedStatement.setLong(3,subjects.getSpecialtiesId());
            preparedStatement.executeUpdate();

            preparedStatement.close();
        }catch (SQLException e){
            LOGGER.error(e);
        }
    }

    @Override
    public Subjects getBy(Subjects subjects, Long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from subjects Where id = ?");
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                subjects.setId(resultSet.getLong("id"));
                subjects.setName(resultSet.getString("name"));
                subjects.setCourse(resultSet.getInt("course"));
                subjects.setSpecialtiesId(resultSet.getLong("Specialties_id"));
            }

            preparedStatement.close();
            resultSet.close();
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return subjects;
    }

    @Override
    public void remove(Long id) {
       try {
           PreparedStatement preparedStatement = connection.prepareStatement("Delete from subjects where id = ?");
           preparedStatement.setLong(1,id);
           preparedStatement.executeUpdate();
           preparedStatement.close();
       }catch (SQLException e){
           LOGGER.error(e);
       }
    }

    @Override
    public void update(String setParameter, Subjects subjects, Long id) {
          try {
              switch (setParameter){
                  case "name":
                      PreparedStatement preparedStatementName = connection.prepareStatement("Update subjects Set name = ? where id = ?");
                      preparedStatementName.setString(1,subjects.getName());
                      preparedStatementName.setLong(2,id);
                      preparedStatementName.executeUpdate();
                      preparedStatementName.close();
                      break;
                  case "course":
                      PreparedStatement preparedStatementCourse = connection.prepareStatement("Update subjects Set course = ? where id = ?");
                      preparedStatementCourse.setInt(1,subjects.getCourse());
                      preparedStatementCourse.setLong(2,id);
                      preparedStatementCourse.executeUpdate();
                      preparedStatementCourse.close();
                      break;
                  case "Specialties_id":
                      PreparedStatement preparedStatementSpecialtiesId = connection.prepareStatement("Update subjects Set Specialties_id = ? where id = ?");
                      preparedStatementSpecialtiesId.setLong(1,subjects.getSpecialtiesId());
                      preparedStatementSpecialtiesId.setLong(2,id);
                      preparedStatementSpecialtiesId.executeUpdate();
                      preparedStatementSpecialtiesId.close();
                      break;
                  case "all":
                      PreparedStatement preparedStatementAll = connection.prepareStatement("Update subjects Set name = ?, course = ?, Specialties_id = ? where id = ?");
                      preparedStatementAll.setString(1,subjects.getName());
                      preparedStatementAll.setInt(2,subjects.getCourse());
                      preparedStatementAll.setLong(3,subjects.getSpecialtiesId());
                      preparedStatementAll.setLong(4,id);
                      preparedStatementAll.executeUpdate();
                      preparedStatementAll.close();
                      break;
                  default:
                      LOGGER.error("Parameter not exist");
              }

              connection.close();
          }catch (SQLException e){
              LOGGER.error(e);
          }
    }

    @Override
    public List<Subjects> getAllSubjects() {
        List<Subjects> subjectsList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from subjects");
            while (resultSet.next()){
                Subjects subjects = new Subjects();

                subjects.setId(resultSet.getLong("id"));
                subjects.setName(resultSet.getString("name"));
                subjects.setCourse(resultSet.getInt("course"));
                subjects.setSpecialtiesId(resultSet.getLong("Specialties_id"));

                subjectsList.add(subjects);
            }

            statement.close();
            resultSet.close();
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return subjectsList;
    }
}
