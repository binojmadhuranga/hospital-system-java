package com.example.acpt.demo.db;

public class DBConnection {

    private DBConnection() {
    }

    private static DBConnection dbconnection;

    public static DBConnection getDbconnection() {

        if (dbconnection == null) {
            dbconnection = new DBConnection();
        }


        return dbconnection;
    }


}
