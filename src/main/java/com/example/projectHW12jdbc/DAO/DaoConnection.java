package com.example.projectHW12jdbc.DAO;

import java.sql.*;

public class DaoConnection {
    public static Connection connection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                "postgres", "olenkasql");
        return connection;
    }
}
