package com.nguonchhay.galleryapp.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLService {

    private String connectionString;
    private String dbHost;
    private String dbUser;
    private String dbPassword;
    private String dbName;
    private Connection connection;

    public MySQLService() {
        connectionString = "com.mysql.cj.jdbc.Driver";
        dbHost = "localhost:3306";
        dbUser = "root";
        dbPassword = "";
        dbName = "injava2022";
        connection = null;
    }

    public Statement getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(this.connectionString);
        connection = DriverManager.getConnection(
            "jdbc:mysql://" + this.dbHost + "/" + this.dbName, this.dbUser, this.dbPassword
        );

        return connection.createStatement();
    }

    public void closeConnection() throws SQLException {
        if (this.connection != null) {
            this.connection.close();
        }
    }
}
