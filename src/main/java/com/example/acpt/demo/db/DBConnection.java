package com.example.acpt.demo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.Class.forName;




public class DBConnection {

    private Connection connection;
    private static DBConnection dbconnection;




    private DBConnection() throws ClassNotFoundException, SQLException {

        forName("com.mysql.cj.jdbc.Driver");

        // Establish a connection to the database
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/afsd_hospital", "root", "1235");


    }





    public static DBConnection getDbconnection() throws SQLException, ClassNotFoundException {

        if (dbconnection == null) {
            dbconnection = new DBConnection();
        }
        return dbconnection;
    }



    public Connection getConnection() {

        return connection;
    }


}
