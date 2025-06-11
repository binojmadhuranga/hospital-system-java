package com.example.acpt.demo.service.impl;


import com.example.acpt.demo.db.DBConnection;
import com.example.acpt.demo.dto.DoctorDto;
import com.example.acpt.demo.service.DoctorService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.Class.forName;

public class DoctorServiceIMPL implements DoctorService {

//    DBConnection dbconnection = DBConnection.getDbconnection();
//    DBConnection dbConnection1 = DBConnection.getDbconnection();
//    DBConnection dbConnection2 = DBConnection.getDbconnection();

    @Override
    public boolean saveDoctor(DoctorDto doctorDto) {
        try {

            Connection connection = DBConnection.getDbconnection().getConnection();

            // Prepare the SQL statement
            String sql = "INSERT INTO doctors (name, age, email, specility) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Set the parameters for the prepared statement
            preparedStatement.setString(1, doctorDto.getName());
            preparedStatement.setInt(2, doctorDto.getAge());
            preparedStatement.setString(3, doctorDto.getEmail());
            preparedStatement.setString(4, doctorDto.getSpecialization());

            // Execute the statement
            int i = preparedStatement.executeUpdate();

            // Close the connection
            preparedStatement.close();
            connection.close();

            return i > 0; // Return true if at least one row was inserted

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }

    @Override
    public DoctorDto getDoctorById(int id) {

        try {

            Connection connection = DBConnection.getDbconnection().getConnection();

            // Prepare the SQL Quary
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM doctors WHERE id = ?");
            stm.setObject(1, id);


            // Execute the query
            ResultSet resultSet = stm.executeQuery();
            // Check if a doctor with the given ID exists
            if (resultSet.next()) {
                return new DoctorDto(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("email"),
                        resultSet.getString("specility")
                );
            }


        } catch (Exception e) {
            e.printStackTrace();
            // Return null in case of an error
        }
        return null;

    }


    @Override
    public boolean updateDoctor(int id, DoctorDto doctorDto) {

        try {
            // Load the JDBC driver
            Connection connection = DBConnection.getDbconnection().getConnection();
            // Prepare the SQL statement

            PreparedStatement stm = connection.prepareStatement("update doctors set name = ?, age = ?,email=?,specility=? where id = ?");

            stm.setObject(1, doctorDto.getName());
            stm.setObject(2, doctorDto.getAge());
            stm.setObject(3, doctorDto.getEmail());
            stm.setObject(4, doctorDto.getSpecialization());
            stm.setObject(5, doctorDto.getId());

            // Execute the statement
            int i = stm.executeUpdate();

            // Close the connection
            stm.close();
            connection.close();

            return i > 0; // Return true if at least one row was inserted

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }


    @Override
    public boolean deleteDoctor(int id) {
        try {
            // Load the JDBC driver
            Connection connection = DBConnection.getDbconnection().getConnection();

            // Prepare the SQL statement
            String sql = "DELETE FROM doctors WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            // Execute the statement
            int rowsAffected = preparedStatement.executeUpdate();

            // Close the connection
            preparedStatement.close();
            connection.close();

            return rowsAffected > 0; // Return true if at least one row was deleted

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }


    @Override
    public List<DoctorDto> getAllDoctors() {
        //create arraylist
        ArrayList<DoctorDto> doctorDtos = new ArrayList<>();

        try {

            forName("com.mysql.cj.jdbc.Driver");


            // Establish a connection to the database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/afsd_hospital", "root", "1235");

            // Prepare the SQL Quary
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM doctors");


            // Execute the query
            ResultSet resultSet = stm.executeQuery();

            while (resultSet.next()) {
                doctorDtos.add(new DoctorDto(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4),
                        resultSet.getString(5)));
            }

            return doctorDtos;


        } catch (Exception e) {
            e.printStackTrace();
            return null; // Return null in case of an error
        }


    }


}
