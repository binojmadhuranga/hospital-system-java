package com.example.acpt.demo.controller;

import com.example.acpt.demo.dto.AppoinmentDetailDto;
import com.example.acpt.demo.dto.DoctorDto;
import com.example.acpt.demo.dto.MedicineDto;
import com.example.acpt.demo.service.DoctorService;
import com.example.acpt.demo.service.MedicineService;
import com.example.acpt.demo.service.impl.DoctorServiceIMPL;
import com.example.acpt.demo.service.impl.MedicineServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.cell.PropertyValueFactory;


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

    @FXML
    private TextField txtSum;


    @FXML
    private TableColumn<AppoinmentDetailDto, Number> colId;
    @FXML
    private TableColumn<AppoinmentDetailDto, String> colName;
    @FXML
    private TableColumn<AppoinmentDetailDto, Integer> colQty;
    @FXML
    private TableColumn<AppoinmentDetailDto, Double> colUnitPrice;
    @FXML
    private TableColumn<AppoinmentDetailDto, Double> colTotal;

    private ObservableList<AppoinmentDetailDto> appoinmentDetailDtos;


    @FXML
    public void initialize() {
        appoinmentDetailDtos = FXCollections.observableArrayList();
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        table.setItems(appoinmentDetailDtos);


    }


    @FXML
    void docSearch(ActionEvent event) {
        int id = Integer.parseInt(txtDocId.getText());
        DoctorService service = new DoctorServiceIMPL();
        DoctorDto doctorDto = service.getDoctorById(id);
        if (doctorDto == null) {
            txtDocName.setText("Not found");
            txtSpecial.setText("");
            return;
        }
        txtDocName.setText(doctorDto.getName());
        txtSpecial.setText(doctorDto.getSpecialization());
    }

    @FXML
    void medSearch(ActionEvent event) {

        int id = Integer.parseInt(txtMedcineNo.getText());

        MedicineService medicineService = new MedicineServiceImpl();
        MedicineDto medicineDto = medicineService.getMedicineById(id);
        txtPrice.setText(String.valueOf(medicineDto.getUnitPrice()));
        txtQtyAv.setText(String.valueOf(medicineDto.getQuantity()));
        txtMedicine.setText(medicineDto.getName());

    }

    double sum = 0.0;  // Initialize sum to 0

    @FXML
    void addCart(ActionEvent event) {
        double id = Double.parseDouble(txtMedcineNo.getText());
        String medicineName = txtMedicine.getText();
        int qty = Integer.parseInt(txtQty.getText());
        double unitPrice = Double.parseDouble(txtPrice.getText());
        double totalPrice = qty * unitPrice;


        sum += totalPrice;  // Add the new total price to the sum

        txtSum.setText(String.valueOf(sum));

        AppoinmentDetailDto appoinmentDetailDto = new AppoinmentDetailDto(id, medicineName, qty, unitPrice, totalPrice);
        appoinmentDetailDtos.add(appoinmentDetailDto);


    }

    @FXML
    void complete(ActionEvent event) {


    }


}

