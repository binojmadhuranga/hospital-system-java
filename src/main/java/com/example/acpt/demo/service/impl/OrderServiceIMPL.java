package com.example.acpt.demo.service.impl;

import com.example.acpt.demo.db.DBConnection;
import com.example.acpt.demo.dto.AppoinmentDetailDto;
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
            String sql = "INSERT INTO appointments ( appointment_date, amount) VALUES (?, ?)";
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
                    PreparedStatement stm2 = connection.prepareStatement("INSERT INTO appointment_doc_details (appointment_id, doctor_id, fee) VALUES(?,?,?)");
                    stm2.setObject(1, appointmentId);
                    stm2.setObject(2, appoinmentDto.getDoctorId());
                    stm2.setObject(3, appoinmentDto.getDocFee());
                    int appointmentDocDetailTableUpdated = stm2.executeUpdate();


                    if (appointmentDocDetailTableUpdated > 0) {
                        for (AppoinmentDetailDto apdtail : appoinmentDto.getAppoinmentDetailDtos()) {
                            PreparedStatement stm3 = connection.prepareStatement("insert into appointment_medicine_details (appointment_id,medicine_id , quantity,price) VALUES (?,?,?,?)");
                            stm3.setObject(1, appointmentId);
                            stm3.setObject(2, apdtail.getId());
                            stm3.setObject(3, apdtail.getQty());
                            stm3.setObject(4, apdtail.getTotalPrice());

                            int medicineDetailSaved = stm3.executeUpdate();


                            if (medicineDetailSaved > 0) {
                                PreparedStatement stm4 = connection.prepareStatement("update medicines set quantity = quantity - ? where id = ? ");
                                stm4.setObject(1, apdtail.getQty());
                                stm4.setObject(2, apdtail.getId());

                                int medicineQtysaved = stm4.executeUpdate();

                                if (medicineQtysaved >= 0) {
                                    connection.rollback();
                                    connection.setAutoCommit(true);
                                }
                            }

                        } connection.setAutoCommit(true);

                    } else {
                        connection.rollback();
                        connection.setAutoCommit(true);
                        return false;
                    }


                } else {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }

            } else {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }


        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return false;
    }


}
