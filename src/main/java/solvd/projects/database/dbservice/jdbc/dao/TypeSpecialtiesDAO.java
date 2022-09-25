package solvd.projects.database.dbservice.jdbc.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.dbservice.jdbc.dao.interfaces.ITypeSpecialtiesDAO;
import solvd.projects.database.dbservice.jdbc.AbstractMySqlDAO;
import solvd.projects.database.dbservice.jdbc.connectionpool.ConnectionPool;
import solvd.projects.database.tableclasses.TypeSpecialties;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TypeSpecialtiesDAO extends AbstractMySqlDAO implements ITypeSpecialtiesDAO {
    private static final Logger LOGGER = LogManager.getLogger(TypeSpecialtiesDAO.class);



    @Override
    public void create(TypeSpecialties typeSpecialties) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement=null;
       try {
           preparedStatement = connection.prepareStatement("Insert into type_specialties (type, Specialties_id,Students_id) values (?,?,?)");
           preparedStatement.setString(1,typeSpecialties.getType());
           preparedStatement.setLong(2,typeSpecialties.getSpecialtiesId());
           preparedStatement.setLong(3,typeSpecialties.getStudentsId());
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
    public TypeSpecialties getBy(TypeSpecialties typeSpecialties, Long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet =null;
        try {
            preparedStatement = connection.prepareStatement("select * from type_specialties where id = ?");
            preparedStatement.setLong(1,id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                typeSpecialties.setId(resultSet.getLong("id"));
                typeSpecialties.setType(resultSet.getString("type"));
                typeSpecialties.setSpecialtiesId(resultSet.getLong("Specialties_id"));
                typeSpecialties.setStudentsId(resultSet.getLong("Students_id"));

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
        return typeSpecialties;
    }

    @Override
    public void remove(Long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement =null;
        try {
            preparedStatement = connection.prepareStatement("delete from type_specialties where id = ?");
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
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
    public void update(String setParameter, TypeSpecialties typeSpecialties, Long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        try {
            switch (setParameter) {
                case "type" -> {
                    PreparedStatement preparedStatementType = connection.prepareStatement("Update type_specialties Set type= ? where id = ?");
                    preparedStatementType.setString(1, typeSpecialties.getType());
                    preparedStatementType.setLong(2, id);
                    preparedStatementType.executeUpdate();
                    preparedStatementType.close();
                }
                case "Specialties_id" -> {
                    PreparedStatement preparedStatementSpecialtiesId = connection.prepareStatement("Update type_specialties Set Specialties_id= ? where id = ?");
                    preparedStatementSpecialtiesId.setLong(1, typeSpecialties.getSpecialtiesId());
                    preparedStatementSpecialtiesId.setLong(2, id);
                    preparedStatementSpecialtiesId.executeUpdate();
                    preparedStatementSpecialtiesId.close();
                }
                case "Students_id" -> {
                    PreparedStatement preparedStatementStudentsId = connection.prepareStatement("Update type_specialties Set Students_id= ? where id = ?");
                    preparedStatementStudentsId.setLong(1, typeSpecialties.getStudentsId());
                    preparedStatementStudentsId.setLong(2, id);
                    preparedStatementStudentsId.executeUpdate();
                    preparedStatementStudentsId.close();
                }
                case "all" -> {
                    PreparedStatement preparedStatementAll = connection.prepareStatement("Update type_specialties Set type= ? , Specialties_id = ? , Students_id = ? where id = ?");
                    preparedStatementAll.setString(1, typeSpecialties.getType());
                    preparedStatementAll.setLong(2, typeSpecialties.getSpecialtiesId());
                    preparedStatementAll.setLong(3, typeSpecialties.getStudentsId());
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
    public List<TypeSpecialties> getAllTypeSpecialties() {
        Connection connection = ConnectionPool.getInstance().retrieve();
        List<TypeSpecialties> typeSpecialtiesList = new ArrayList<>();
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from type_specialties");
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
        return typeSpecialtiesList;
    }
}
