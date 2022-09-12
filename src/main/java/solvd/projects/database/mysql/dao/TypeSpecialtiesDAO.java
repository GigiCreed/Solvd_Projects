package solvd.projects.database.mysql.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.interfaces.ITypeSpecialtiesDAO;
import solvd.projects.database.mysql.AbstractMySqlDAO;
import solvd.projects.database.mysql.connectionpool.ConnectionPool;
import solvd.projects.database.tableclasses.TypeSpecialties;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TypeSpecialtiesDAO extends AbstractMySqlDAO implements ITypeSpecialtiesDAO {
    private static final Logger LOGGER = LogManager.getLogger(TypeSpecialtiesDAO.class);

    private Connection connection = ConnectionPool.getInstance().retrieve();


    @Override
    public void create(TypeSpecialties typeSpecialties) {
       try {
           PreparedStatement preparedStatement = connection.prepareStatement("Insert into type_specialties (type, Specialties_id,Students_id) values (?,?,?)");
           preparedStatement.setString(1,typeSpecialties.getType());
           preparedStatement.setLong(2,typeSpecialties.getSpecialtiesId());
           preparedStatement.setLong(3,typeSpecialties.getStudentsId());
           preparedStatement.executeUpdate();
           preparedStatement.close();
       }catch (SQLException e){
           LOGGER.error(e);
       }
    }

    @Override
    public TypeSpecialties getBy(TypeSpecialties typeSpecialties, Long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from type_specialties where id = ?");
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                typeSpecialties.setId(resultSet.getLong("id"));
                typeSpecialties.setType(resultSet.getString("type"));
                typeSpecialties.setSpecialtiesId(resultSet.getLong("Specialties_id"));
                typeSpecialties.setStudentsId(resultSet.getLong("Students_id"));

            }
            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return typeSpecialties;
    }

    @Override
    public void remove(Long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from type_specialties where id = ?");
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void update(String setParameter, TypeSpecialties typeSpecialties, Long id) {
        try {
            switch (setParameter){
                case "type":
                    PreparedStatement preparedStatementType =connection.prepareStatement("Update type_specialties Set type= ? where id = ?");
                    preparedStatementType.setString(1,typeSpecialties.getType());
                    preparedStatementType.setLong(2,id);
                    preparedStatementType.executeUpdate();
                    preparedStatementType.close();
                    break;
                case "Specialties_id":
                    PreparedStatement preparedStatementSpecialtiesId =connection.prepareStatement("Update type_specialties Set Specialties_id= ? where id = ?");
                    preparedStatementSpecialtiesId.setLong(1,typeSpecialties.getSpecialtiesId());
                    preparedStatementSpecialtiesId.setLong(2,id);
                    preparedStatementSpecialtiesId.executeUpdate();
                    preparedStatementSpecialtiesId.close();
                    break;
                case "Students_id":
                    PreparedStatement preparedStatementStudentsId =connection.prepareStatement("Update type_specialties Set Students_id= ? where id = ?");
                    preparedStatementStudentsId.setLong(1,typeSpecialties.getStudentsId());
                    preparedStatementStudentsId.setLong(2,id);
                    preparedStatementStudentsId.executeUpdate();
                    preparedStatementStudentsId.close();
                    break;
                case "all":
                    PreparedStatement preparedStatementAll =connection.prepareStatement("Update type_specialties Set type= ? , Specialties_id = ? , Students_id = ? where id = ?");
                    preparedStatementAll.setString(1,typeSpecialties.getType());
                    preparedStatementAll.setLong(2,typeSpecialties.getSpecialtiesId());
                    preparedStatementAll.setLong(3,typeSpecialties.getStudentsId());
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
    public List<TypeSpecialties> getAllTypeSpecialties() {
        List<TypeSpecialties> typeSpecialtiesList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from type_specialties");
            while (resultSet.next()){
                TypeSpecialties typeSpecialties = new TypeSpecialties();

                typeSpecialties.setId(resultSet.getLong("id"));
                typeSpecialties.setType(resultSet.getString("type"));
                typeSpecialties.setSpecialtiesId(resultSet.getLong("Specialties_id"));
                typeSpecialties.setStudentsId(resultSet.getLong("Students_id"));

                typeSpecialtiesList.add(typeSpecialties);
            }

        }catch (SQLException e){
            LOGGER.error(e);
        }
        return typeSpecialtiesList;
    }
}
