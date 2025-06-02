package com.example.acpt.demo.controller;

import com.example.acpt.demo.dto.DoctorDto;
import com.example.acpt.demo.service.DoctorService;
import com.example.acpt.demo.service.impl.DoctorServiceIMPL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class UpdateDoctorController {

    @FXML
    private TextField txtAge;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSpecial;

    @FXML
    void cancel(ActionEvent event) {

    }

    @FXML
    void search(ActionEvent event) {

        int id = Integer.parseInt(txtId.getText());

        DoctorService service = new DoctorServiceIMPL();
        DoctorDto doctorDto = service.getDoctorById(id);

        txtName.setText(doctorDto.getName());
        txtAge.setText(String.valueOf(doctorDto.getAge()));
        txtSpecial.setText(doctorDto.getSpecialization());
        txtSpecial.setText(doctorDto.getSpecialization());


    }

    @FXML
    void update(ActionEvent event) {

        String name = txtName.getText();
        int age = Integer.parseInt(txtAge.getText());
      //  String email = txtEmail.getText();
        String specillaity = txtSpecial.getText();

        DoctorDto doctorDto = new DoctorDto();

        DoctorService service = new DoctorServiceIMPL();

        boolean save = service.saveDoctor(doctorDto);

        if (save) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("This is a JavaFX Alert");
            alert.setContentText("Doctor Save Successfully.");
            alert.showAndWait();

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("This is a JavaFX Alert");
            alert.setContentText("Doctor Save failed.");
            alert.showAndWait();
        }





    }


}
