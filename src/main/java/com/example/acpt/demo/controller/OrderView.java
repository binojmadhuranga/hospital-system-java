package com.example.acpt.demo.controller;

import com.example.acpt.demo.dto.AppoinmentDetailDto;
import com.example.acpt.demo.dto.DoctorDto;
import com.example.acpt.demo.dto.MedicineDto;
import com.example.acpt.demo.service.DoctorService;
import com.example.acpt.demo.service.MedicineService;
import com.example.acpt.demo.service.impl.DoctorServiceIMPL;
import com.example.acpt.demo.service.impl.MedicineServiceImpl;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;


import java.util.ArrayList;

public class OrderView {

    @FXML
    private TextField txtMedcineNo;

    @FXML
    private TableView<AppoinmentDetailDto> table;

    @FXML
    private Label total;

    @FXML
    private TextField txtDocId;

    @FXML
    private TextField txtDocName;

    @FXML
    private TextField txtFee;

    @FXML
    private TextField txtMedicine;

    @FXML
    private TextField txtPatient;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtQty;

    @FXML
    private TextField txtQtyAv;

    @FXML
    private TextField txtSpecial;

    private ArrayList<AppoinmentDetailDto> appoinmentDetailDtos;



    @FXML
    void addCart(ActionEvent event) {

       double id = Double.parseDouble(txtMedcineNo.getText());
       String medicineName = txtMedicine.getText();
        int qty = Integer.parseInt(txtQty.getText());
        double unitPrice  = Integer.parseInt(txtPrice.getText());
        double totalPrice = qty * unitPrice;


        AppoinmentDetailDto appoinmentDetailDto = new AppoinmentDetailDto(id, medicineName, qty, unitPrice, totalPrice);
        appoinmentDetailDtos.add(appoinmentDetailDto);
        table.setItems(FXCollections.observableArrayList(appoinmentDetailDtos));


    }

    @FXML
    void complete(ActionEvent event) {

    }

    @FXML
    void docSearch(ActionEvent  event) {

        int id = Integer.parseInt(txtDocId.getText());
        DoctorService service = new DoctorServiceIMPL();
        DoctorDto doctorDto = service.getDoctorById(id);
        txtDocName.setText(doctorDto.getName());
        txtSpecial.setText(doctorDto.getSpecialization());

    }

    @FXML
    void medSearch(ActionEvent  event) {

        int id = Integer.parseInt(txtMedcineNo.getText());

        MedicineService medicineService = new MedicineServiceImpl();
        MedicineDto medicineDto = medicineService.getMedicineById(id);
        txtPrice.setText(String.valueOf(medicineDto.getUnitPrice()));
        txtQtyAv.setText(String.valueOf(medicineDto.getQuantity()));
        txtMedicine.setText(medicineDto.getName());


    }




}



