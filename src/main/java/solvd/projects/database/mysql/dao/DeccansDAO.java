package solvd.projects.database.mysql.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.mysql.dao.interfaces.IDeccansDAO;
import solvd.projects.database.mysql.AbstractMySqlDAO;
import solvd.projects.database.mysql.connectionpool.ConnectionPool;
import solvd.projects.database.tableclasses.Deccans;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeccansDAO extends AbstractMySqlDAO implements IDeccansDAO {
    private static final Logger LOGGER = LogManager.getLogger(DeccansDAO.class);

    private Connection connection = ConnectionPool.getInstance().retrieve();
    @Override
    public void create(Deccans deccans) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into deccans (name,surname,age,address,phone_number,email,Faculties_id,Universities_id)  values ( ?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1,deccans.getName());
            preparedStatement.setString(2,deccans.getSurname());
            preparedStatement.setDate(3,deccans.getAge());
            preparedStatement.setString(4,deccans.getAddress());
            preparedStatement.setInt(5,deccans.getPhone_number());
            preparedStatement.setString(6, deccans.getEmail());
            preparedStatement.setLong(7,deccans.getFacultiesId());
            preparedStatement.setLong(8,deccans.getUniversitiesId());
            preparedStatement.executeUpdate();


            connection.close();
            preparedStatement.close();

        }catch (SQLException e){
            LOGGER.error(e);
        }
    }

    @Override
    public Deccans getBy(Deccans deccans, Long id) {
        try {
            PreparedStatement preparedStatement =connection.prepareStatement("Select * from deccans where id = ?");
            preparedStatement.setLong(1,id);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                deccans.setId(resultSet.getLong("id"));
                deccans.setName(resultSet.getString("name"));
                deccans.setSurname(resultSet.getString("surname"));
                deccans.setAge(resultSet.getDate("age"));
                deccans.setAddress(resultSet.getString("address"));
                deccans.setPhone_number(resultSet.getInt("phone_number"));
                deccans.setEmail(resultSet.getString("email"));
                deccans.setFacultiesId(resultSet.getLong("Faculties_id"));
                deccans.setUniversitiesId(resultSet.getLong("Universities_id"));
            }

            connection.close();
            preparedStatement.close();
            resultSet.close();
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return deccans;
    }

    @Override
    public void remove(Long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("Delete From deccans where id = ?");
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();

            connection.close();
            preparedStatement.close();
        }catch (SQLException e){
            LOGGER.error(e);
        }
    }

    @Override
    public void update(String setParameter, Deccans deccans, Long id) {
        try {
            switch (setParameter){
                case "name":PreparedStatement preparedStatementName =connection.prepareStatement("update deccans set name = ? where id = ?");
                    preparedStatementName.setString(1,deccans.getName());
                    preparedStatementName.setLong(2,id);
                    preparedStatementName.executeUpdate();
                    preparedStatementName.close();
                    break;
                case "surname":PreparedStatement preparedStatementSurname = connection.prepareStatement("update deccans set surname = ? where id = ?");
                    preparedStatementSurname.setString(1,deccans.getSurname());
                    preparedStatementSurname.setLong(2,id);
                    preparedStatementSurname.executeUpdate();
                    preparedStatementSurname.close();
                    break;
                case "age":PreparedStatement preparedStatementAge = connection.prepareStatement("update deccans set age = ? where id = ?");
                    preparedStatementAge.setDate(1,deccans.getAge());
                    preparedStatementAge.setLong(2,id);
                    preparedStatementAge.executeUpdate();
                    preparedStatementAge.close();
                    break;
                case "phone_number":PreparedStatement preparedStatementPhoneNumber = connection.prepareStatement("update deccans set phone_number = ? where id = ?");
                    preparedStatementPhoneNumber.setInt(1,deccans.getPhone_number());
                    preparedStatementPhoneNumber.setLong(2,id);
                    preparedStatementPhoneNumber.executeUpdate();
                    preparedStatementPhoneNumber.close();
                    break;
                case "address":PreparedStatement preparedStatementAddress = connection.prepareStatement("update deccans set address = ? where id = ?");
                    preparedStatementAddress.setString(1,deccans.getAddress());
                    preparedStatementAddress.setLong(2,id);
                    preparedStatementAddress.executeUpdate();
                    preparedStatementAddress.close();
                    break;
                case "email":PreparedStatement preparedStatementEmail = connection.prepareStatement("update deccans set email = ? where id = ?");
                    preparedStatementEmail.setString(1,deccans.getEmail());
                    preparedStatementEmail.setLong(2,id);
                    preparedStatementEmail.executeUpdate();
                    preparedStatementEmail.close();
                    break;
                case "Faculties_id":
                    PreparedStatement preparedStatementFacultiesId = connection.prepareStatement("Update deccans SET Faculties_id = ? WHERE id = ?");
                    preparedStatementFacultiesId.setLong(1, deccans.getFacultiesId());
                    preparedStatementFacultiesId.setLong(2, id);
                    preparedStatementFacultiesId.executeUpdate();
                    preparedStatementFacultiesId.close();
                    break;
                case "Universities_id":
                    PreparedStatement preparedStatementUniversitiesId = connection.prepareStatement("Update deccans SET Universities_id = ? WHERE id = ?");
                    preparedStatementUniversitiesId.setLong(1, deccans.getUniversitiesId());
                    preparedStatementUniversitiesId.setLong(2, id);
                    preparedStatementUniversitiesId.executeUpdate();
                    preparedStatementUniversitiesId.close();
                    break;
                case "all":PreparedStatement preparedStatementAll = connection.prepareStatement("update deccans set name = ? , surname = ?, age = ?, address = ?, phone_number= ?, email = ?, Faculties_id = ?, Universities_id= ? where id = ?");
                    preparedStatementAll.setString(1,deccans.getName());
                    preparedStatementAll.setString(2,deccans.getSurname());
                    preparedStatementAll.setDate(3,deccans.getAge());
                    preparedStatementAll.setString(4,deccans.getAddress());
                    preparedStatementAll.setInt(5,deccans.getPhone_number());
                    preparedStatementAll.setString(6,deccans.getEmail());
                    preparedStatementAll.setLong(7,deccans.getFacultiesId());
                    preparedStatementAll.setLong(8,deccans.getUniversitiesId());
                    preparedStatementAll.setLong(9,id);
                    preparedStatementAll.executeUpdate();
                    preparedStatementAll.close();
                    break;
                default:
                    LOGGER.error("Parameter don't exist");
            }
            connection.close();

        }catch (SQLException e){
            LOGGER.error(e);
        }
    }

    @Override
    public List<Deccans> getAllDeccans() {
        List<Deccans> deccansList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from deccans");
            while (resultSet.next()){
                Deccans deccans = new Deccans();

                deccans.setId(resultSet.getLong("id"));
                deccans.setName(resultSet.getString("name"));
                deccans.setSurname(resultSet.getString("surname"));
                deccans.setAge(resultSet.getDate("age"));
                deccans.setAddress(resultSet.getString("address"));
                deccans.setPhone_number(resultSet.getInt("phone_number"));
                deccans.setEmail(resultSet.getString("email"));
                deccans.setFacultiesId(resultSet.getLong("Faculties_id"));
                deccans.setUniversitiesId(resultSet.getLong("Universities_id"));

                deccansList.add(deccans);
            }
            connection.close();
            statement.close();
            resultSet.close();
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return deccansList;
    }
}
