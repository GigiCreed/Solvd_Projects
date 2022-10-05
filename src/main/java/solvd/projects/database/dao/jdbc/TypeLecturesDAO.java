package solvd.projects.database.dao.jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.database.dao.interfaces.ITypeLecturesDAO;
import solvd.projects.database.dao.connectionpool.ConnectionPool;
import solvd.projects.database.models.TypeLectures;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TypeLecturesDAO extends AbstractMySqlDAO implements ITypeLecturesDAO {

    private static final Logger LOGGER = LogManager.getLogger(TypeLecturesDAO.class);


    @Override
    public TypeLectures getById(Long id) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        TypeLectures typeLectures = new TypeLectures();
        try {
            preparedStatement = connection.prepareStatement("Select * from type_lectures where id = ?");
            preparedStatement.setLong(1,id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                typeLectures.setId(resultSet.getLong("id"));
                typeLectures.setType(resultSet.getString("type"));
                typeLectures.setLectorsId(resultSet.getLong("Lectors_id"));
                typeLectures.setSubjectsId(resultSet.getLong("Subjects_id"));
            }

        }catch (SQLException e){
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
        return typeLectures;
    }

    @Override
    public void insert(TypeLectures object) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement = connection.prepareStatement("Insert into type_lectures (type, Lectors_id, Subjects_id) values (?,?,?)");
            preparedStatement.setString(1,object.getType());
            preparedStatement.setLong(2,object.getLectorsId());
            preparedStatement.setLong(3,object.getSubjectsId());
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
    public void update(TypeLectures object) {
        Connection connection = ConnectionPool.getInstance().retrieve();
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement = connection.prepareStatement("Update type_lectures Set type = ?,Lectors_id = ? , Subjects_id = ? where id = ?");
            preparedStatement.setString(1, object.getType());
            preparedStatement.setLong(2, object.getLectorsId());
            preparedStatement.setLong(3, object.getSubjectsId());
            preparedStatement.setLong(4, object.getId());
            preparedStatement.executeUpdate();

            LOGGER.info("Update Completed");

        }catch (SQLException e){
            LOGGER.info(e);
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
            preparedStatement = connection.prepareStatement("Delete from type_lectures where id = ?");
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();

            LOGGER.info("Delete Completed!!!!");

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
    public List<TypeLectures> getAllTypeLectures() {
        Connection connection = ConnectionPool.getInstance().retrieve();
        List<TypeLectures> typeLecturesList = new ArrayList<>();
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select * from type_lectures");
            while (resultSet.next()){
                TypeLectures typeLectures = new TypeLectures();

                typeLectures.setId(resultSet.getLong("id"));
                typeLectures.setType(resultSet.getString("type"));
                typeLectures.setLectorsId(resultSet.getLong("Lectors_id"));
                typeLectures.setSubjectsId(resultSet.getLong("Subjects_id"));

                typeLecturesList.add(typeLectures);
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
        return typeLecturesList;
    }
}
