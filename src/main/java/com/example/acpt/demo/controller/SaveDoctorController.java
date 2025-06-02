package com.example.acpt.demo.controller;

import com.example.acpt.demo.dto.DoctorDto;
import com.example.acpt.demo.service.DoctorService;
import com.example.acpt.demo.service.impl.DoctorServiceIMPL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class SaveDoctorController {


    @FXML
    private TextField txtAge;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSpecillaity;

    @FXML
    void cancel(ActionEvent event) {

    }

    @FXML
    void save(ActionEvent event) {
        String name = txtName.getText();
        int age = Integer.parseInt(txtAge.getText());
        String email = txtEmail.getText();
        String specillaity = txtSpecillaity.getText();

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
