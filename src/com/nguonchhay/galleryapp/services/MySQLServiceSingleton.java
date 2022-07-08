package com.nguonchhay.galleryapp.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLServiceSingleton {
    private static Connection connection = null;

    private MySQLServiceSingleton() {}

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "com.mysql.cj.jdbc.Driver";
        String dbHost = "localhost:3306";
        String dbUser = "root";
        String dbPassword = "";
        String dbName = "injava2022";
        Class.forName(connectionString);
        if (connection == null) {
            connection = DriverManager.getConnection(
                "jdbc:mysql://" + dbHost + "/" + dbName, dbUser, dbPassword
            );
        }
        return connection;
    }
}
