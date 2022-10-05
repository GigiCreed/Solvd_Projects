package solvd.projects.database.dao.jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.dao.interfaces.ITypeSpecialtiesDAO;
import solvd.projects.database.dao.connectionpool.ConnectionPool;
import solvd.projects.database.models.TypeSpecialties;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TypeSpecialtiesDAO extends AbstractMySqlDAO implements ITypeSpecialtiesDAO {
    private static final Logger LOGGER = LogManager.getLogger(TypeSpecialtiesDAO.class);


    @Override
    public TypeSpecialties getById(Long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet =null;
        TypeSpecialties typeSpecialties = new TypeSpecialties();
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
    public void insert(TypeSpecialties object) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement = connection.prepareStatement("Insert into type_specialties (type, Specialties_id,Students_id) values (?,?,?)");
            preparedStatement.setString(1,object.getType());
            preparedStatement.setLong(2,object.getSpecialtiesId());
            preparedStatement.setLong(3,object.getStudentsId());
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
    public void update(TypeSpecialties object) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement =null;
        try {
            preparedStatement = connection.prepareStatement("Update type_specialties Set type= ? , Specialties_id = ? , Students_id = ? where id = ?");
            preparedStatement.setString(1, object.getType());
            preparedStatement.setLong(2, object.getSpecialtiesId());
            preparedStatement.setLong(3, object.getStudentsId());
            preparedStatement.setLong(4, object.getId());
            preparedStatement.executeUpdate();

            LOGGER.info("Update Completed!!!!");
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
            preparedStatement = connection.prepareStatement("delete from type_specialties where id = ?");
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();

            LOGGER.info("Delete Completed!!!!");
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
