package org.geekhub.taras;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TableBuilder {

    public static void main(String[] args) {
        String sqlCreateTableCat = "CREATE TABLE CAT" + "(id INTEGER not NULL, " + "name VARCHAR(30), " + "age INTEGER not NULL)";
        String sqlCreateTableUser = "CREATE TABLE \"user\"" + "(id INTEGER not NULL, " + "name VARCHAR(30), " + "age INTEGER not NULL,"
                + "admin BOOLEAN not NULL," + "balance DOUBLE PRECISION not NULL)";

        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbForHw12", "postgres", "451111");
            statement = connection.createStatement();
            statement.executeUpdate(sqlCreateTableCat);
            statement.executeUpdate(sqlCreateTableUser);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (statement != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
