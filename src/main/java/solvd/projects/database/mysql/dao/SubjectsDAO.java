package solvd.projects.database.mysql.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.mysql.dao.interfaces.ISubjectsDAO;
import solvd.projects.database.mysql.AbstractMySqlDAO;
import solvd.projects.database.mysql.connectionpool.ConnectionPool;
import solvd.projects.database.tableclasses.Subjects;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectsDAO extends AbstractMySqlDAO implements ISubjectsDAO {
    private static final Logger LOGGER = LogManager.getLogger(SubjectsDAO.class);

    private final Connection connection = ConnectionPool.getInstance().retrieve();

    @Override
    public void create(Subjects subjects) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("Insert into subjects (name,course,Specialties_id) values (?,?,?)");
            preparedStatement.setString(1,subjects.getName());
            preparedStatement.setInt(2,subjects.getCourse());
            preparedStatement.setLong(3,subjects.getSpecialtiesId());
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
    public Subjects getBy(Subjects subjects, Long id) {
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
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
    public void remove(Long id) {
        PreparedStatement preparedStatement=null;
       try {
           preparedStatement = connection.prepareStatement("Delete from subjects where id = ?");
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
    public void update(String setParameter, Subjects subjects, Long id) {
          try {
              switch (setParameter) {
                  case "name" -> {
                      PreparedStatement preparedStatementName = connection.prepareStatement("Update subjects Set name = ? where id = ?");
                      preparedStatementName.setString(1, subjects.getName());
                      preparedStatementName.setLong(2, id);
                      preparedStatementName.executeUpdate();
                      preparedStatementName.close();
                  }
                  case "course" -> {
                      PreparedStatement preparedStatementCourse = connection.prepareStatement("Update subjects Set course = ? where id = ?");
                      preparedStatementCourse.setInt(1, subjects.getCourse());
                      preparedStatementCourse.setLong(2, id);
                      preparedStatementCourse.executeUpdate();
                      preparedStatementCourse.close();
                  }
                  case "Specialties_id" -> {
                      PreparedStatement preparedStatementSpecialtiesId = connection.prepareStatement("Update subjects Set Specialties_id = ? where id = ?");
                      preparedStatementSpecialtiesId.setLong(1, subjects.getSpecialtiesId());
                      preparedStatementSpecialtiesId.setLong(2, id);
                      preparedStatementSpecialtiesId.executeUpdate();
                      preparedStatementSpecialtiesId.close();
                  }
                  case "all" -> {
                      PreparedStatement preparedStatementAll = connection.prepareStatement("Update subjects Set name = ?, course = ?, Specialties_id = ? where id = ?");
                      preparedStatementAll.setString(1, subjects.getName());
                      preparedStatementAll.setInt(2, subjects.getCourse());
                      preparedStatementAll.setLong(3, subjects.getSpecialtiesId());
                      preparedStatementAll.setLong(4, id);
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
    public List<Subjects> getAllSubjects() {
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
