package com.example.acpt.demo.service.impl;

import com.example.acpt.demo.db.DBConnection;
import com.example.acpt.demo.dto.MedicineDto;
import com.example.acpt.demo.service.MedicineService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Class.forName;

public class MedicineServiceImpl implements MedicineService {


    public MedicineDto getMedicineById(int id) {
        MedicineDto medicineDto = null;

        try {
            Connection connection = DBConnection.getDbconnection().getConnection();

            String sql = "SELECT * FROM medicines WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                medicineDto = new MedicineDto(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("quantity"),
                        resultSet.getDouble("unit_price")
                );
            }

            resultSet.close();
            preparedStatement.close();
          //  connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return medicineDto;
    }


//
//    @Override
//    public boolean saveMedicine(MedicineDto medicineDto) {
//        try {
//            Connection connection = DBConnection.getDbconnection().getConnection();
//
//            String sql = "INSERT INTO medicines (name, quantity, unit_price) VALUES (?, ?, ?)";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//
//            preparedStatement.setString(1, medicineDto.getName());
//            preparedStatement.setInt(2, medicineDto.getQuantity());
//            preparedStatement.setDouble(3, medicineDto.getUnitPrice());
//
//            int result = preparedStatement.executeUpdate();
//
//            preparedStatement.close();
//            connection.close();
//
//            return result > 0;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//


//    @Override
//    public boolean updateMedicine(int id, MedicineDto medicineDto) {
//        try {
//            Connection connection = DBConnection.getDbconnection().getConnection();
//
//            String sql = "UPDATE medicines SET name = ?, quantity = ?, unit_price = ? WHERE id = ?";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//
//            preparedStatement.setString(1, medicineDto.getName());
//            preparedStatement.setInt(2, medicineDto.getQuantity());
//            preparedStatement.setDouble(3, medicineDto.getUnitPrice());
//            preparedStatement.setInt(4, id);
//
//            int result = preparedStatement.executeUpdate();
//
//            preparedStatement.close();
//            connection.close();
//
//            return result > 0;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//


//    @Override
//    public boolean deleteMedicine(int id) {
//        try {
//            Connection connection = DBConnection.getDbconnection().getConnection();
//
//            String sql = "DELETE FROM medicines WHERE id = ?";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setInt(1, id);
//
//            int result = preparedStatement.executeUpdate();
//
//            preparedStatement.close();
//            connection.close();
//
//            return result > 0;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }


//    @Override
//    public List<MedicineDto> getAllMedicines() {
//        List<MedicineDto> medicineList = new ArrayList<>();
//
//        try {
//            forName("com.mysql.cj.jdbc.Driver");
//
//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/afsd_hospital", "root", "1235");
//
//            String sql = "SELECT * FROM medicines";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                MedicineDto medicine = new MedicineDto(
//                        resultSet.getInt("id"),
//                        resultSet.getString("name"),
//                        resultSet.getInt("quantity"),
//                        resultSet.getDouble("unit_price")
//                );
//                medicineList.add(medicine);
//            }
//
//            preparedStatement.close();
//            connection.close();
//
//            return medicineList;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
}
