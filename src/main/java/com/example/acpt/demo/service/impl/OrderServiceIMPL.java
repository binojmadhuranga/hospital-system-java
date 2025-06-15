package com.example.acpt.demo.service.impl;

import com.example.acpt.demo.db.DBConnection;
import com.example.acpt.demo.dto.AppoinmentDto;
import com.example.acpt.demo.service.OrderService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class OrderServiceIMPL implements OrderService {

    @Override
    public boolean makeAppointment(AppoinmentDto appoinmentDto) {


        try {
            // Get a connection to the database
            Connection connection = DBConnection.getDbconnection().getConnection();

            connection.setAutoCommit(false);

            // Prepare the SQL statement
            String sql = "INSERT INTO appointments (date, total_amount) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // Set the parameters for the prepared statement
            preparedStatement.setString(1, appoinmentDto.getData());
            preparedStatement.setDouble(2, appoinmentDto.getTotalAmount());


            // Execute the statement
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {

                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int appointmentId = generatedKeys.getInt(1);
                    PreparedStatement stm2 = connection.prepareStatement("INSERT INTO appointment_doctor_details (appointment_id, doctor_id, fee) VALUES(?,?,?)");
                    stm2.setObject(1, appointmentId);
                    stm2.setObject(2, appoinmentDto.getDoctorId());
                    stm2.setObject(3, appoinmentDto.getDocFee());
                    int appointmentDocDetailTableUpdated = stm2.executeUpdate();

                } else {
                    connection.rollback();
                    return false;
                }

            } else {
                connection.rollback();
                return false;
            }


        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return false;
    }


}
