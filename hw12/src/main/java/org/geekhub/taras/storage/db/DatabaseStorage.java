package org.geekhub.taras.storage.db;


import org.geekhub.taras.storage.Entity;
import org.geekhub.taras.storage.Storage;
import org.geekhub.taras.storage.StorageException;

import javax.sql.DataSource;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class DatabaseStorage implements Storage {

    private final DataSource dataSource;

    public DatabaseStorage(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public <T extends Entity> T get(Class<T> clazz, Integer id) throws StorageException {
        //this method is fully implemented, no need to do anything, it's just an example
        String sql = "SELECT * FROM \"" + clazz.getSimpleName().toLowerCase() + "\" WHERE id = " + id;
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            List<T> result = extractResult(clazz, statement.executeQuery(sql));
            return result.isEmpty() ? null : result.get(0);
        } catch (StorageException e) {
            throw e;
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public <T extends Entity> List<T> list(Class<T> clazz) throws StorageException {
        String sql = "SELECT * FROM \"" + clazz.getSimpleName().toLowerCase() + "\"";
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            List<T> result = extractResult(clazz, statement.executeQuery(sql));
            return result;
        } catch (StorageException e) {
            throw e;
        } catch (Exception e) {
            throw new StorageException(e);
        }

        //TODO: Implement me
        //return null;
    }

    @Override
    public <T extends Entity> boolean delete(T entity) throws StorageException {
        String selectId = "SELECT id FROM \"" + entity.getClass() + "\"";
        List<?> idList;
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            idList = (List<?>) statement.executeQuery(selectId);
        } catch (Exception e) {
            throw new StorageException(e);
        }

        String sql = "DELETE * FROM \"" + entity.getClass() + "\" WHERE id = " + entity.getId();

        for (int i = 0; i < idList.size(); i++) {
            if (idList.get(i) == entity.getId()) {
                try {
                    Connection connection = dataSource.getConnection();
                    Statement statement = connection.createStatement();
                    statement.executeQuery(sql);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                return true;
            }
        }
        return false;

        //TODO: Implement me
    }

    @Override
    public <T extends Entity> void save(T entity) throws StorageException {
        Field[] fields = entity.getClass().getDeclaredFields();
        StringJoiner joinerFields = new StringJoiner(", ");
        StringJoiner joinerValues = new StringJoiner(", ");
        for (int i = 0; i < fields.length; i++) {
            joinerFields.add(fields[i].toString());
            try {
                joinerValues.add(entity.getClass().getField(fields[i].toString()).toString());
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
        }

        String sql = "INSERT INTO \"" + entity.getClass() + "\"" + "(" + joinerFields + ")" + "VALUES" + "(" + joinerValues + ")";
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeQuery(sql);
        } catch (Exception e) {
            throw new StorageException(e);
        }

        //TODO: Implement me
        /*
        Use StringJoiner if you need to concat a string of ?
         */
    }

    //creates list of new instances of clazz by using data from the result set
    private <T extends Entity> List<T> extractResult(Class<T> clazz, ResultSet resultSet) throws Exception {
        List<T> result = null;
        Field[] fields = clazz.getDeclaredFields();
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        while (resultSet.next()) {
            Object o = null;
            for (Constructor<?> con : constructors) {
                o = (Object) con.newInstance(resultSet.getInt(fields[0].toString()), resultSet.getString(fields[1].toString()), resultSet.getInt(fields[2].toString()));
            }
            result.add((T) o);
        }
        return result;

        /*
        This method must a create a resulting list of entities. Fill objects with data from the results set.
        Use reflection to create an instance of given class. Extract data from result set by class' field name.
         */
    }

    //converts object to map, could be helpful in save method
    private <T extends Entity> Map<String, Object> prepareEntity(T entity) throws StorageException {
        //TODO: Implement me and use in the save method
        return null;
    }

}
