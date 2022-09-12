package solvd.projects.database.mysql.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.interfaces.ISpecialtiesDAO;
import solvd.projects.database.mysql.AbstractMySqlDAO;
import solvd.projects.database.mysql.connectionpool.ConnectionPool;
import solvd.projects.database.tableclasses.Faculties;
import solvd.projects.database.tableclasses.Specialties;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SpecialtiesDAO extends AbstractMySqlDAO implements ISpecialtiesDAO {

    private static final Logger LOGGER = LogManager.getLogger(SpecialtiesDAO.class);

    private Connection connection = ConnectionPool.getInstance().retrieve();
    @Override
    public void create(Specialties specialties) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into specialties (name,Faculties_id) Values (?,?)");
            preparedStatement.setString(1,specialties.getName());
            preparedStatement.setLong(2,specialties.getFacultiesId());
            preparedStatement.executeUpdate();

            connection.close();
            preparedStatement.close();
        }catch (SQLException e){
            LOGGER.error(e);
        }

    }

    @Override
    public Specialties getBy(Specialties specialties, Long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from specialties Where id = ?");
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                specialties.setId(resultSet.getLong("id"));
                specialties.setName(resultSet.getString("name"));
                specialties.setFacultiesId(resultSet.getLong("Faculties_id"));
            }

            connection.close();
            preparedStatement.close();
            resultSet.close();
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return specialties;
    }

    @Override
    public void remove(Long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from specialties where id = ?");
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();

            preparedStatement.close();
        }catch (SQLException e){
            LOGGER.error(e);
        }
    }

    @Override
    public void update(String setParameter, Specialties specialties, Long id) {
        try {
            switch (setParameter){
                case "name":
                    PreparedStatement preparedStatementName = connection.prepareStatement("Update specialties Set name = ? where id = ?");
                    preparedStatementName.setString(1,specialties.getName());
                    preparedStatementName.setLong(2,id);
                    preparedStatementName.executeUpdate();
                    preparedStatementName.close();
                    break;
                case "Faculties_id":
                    PreparedStatement preparedStatementFacultiesId = connection.prepareStatement("Update specialties Set Faculties_id = ? where id = ?");
                    preparedStatementFacultiesId.setLong(1,specialties.getFacultiesId());
                    preparedStatementFacultiesId.setLong(2,id);
                    preparedStatementFacultiesId.executeUpdate();
                    preparedStatementFacultiesId.close();
                    break;
                case "all":
                    PreparedStatement preparedStatementAll = connection.prepareStatement("Update specialties Set name = ?, Faculties_id = ? where id = ?");
                    preparedStatementAll.setString(1,specialties.getName());
                    preparedStatementAll.setLong(2,specialties.getFacultiesId());
                    preparedStatementAll.setLong(3,id);
                    preparedStatementAll.executeUpdate();
                    preparedStatementAll.close();
                    break;
                default:
                    LOGGER.error("Parameter not exist");
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }
    }

    @Override
    public List<Specialties> getAllSpecialties() {
        List<Specialties> specialtiesList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from specialties");
            while (resultSet.next()) {
                Specialties specialties = new Specialties();
                specialties.setId(resultSet.getLong("id"));
                specialties.setName(resultSet.getString("name"));
                specialties.setFacultiesId(resultSet.getLong("Faculties_id"));

                specialtiesList.add(specialties);
            }
            statement.close();
            resultSet.close();
            connection.close();
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return specialtiesList;
    }
}
