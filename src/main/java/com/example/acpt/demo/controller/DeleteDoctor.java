package com.example.acpt.demo.controller;

import com.example.acpt.demo.service.DoctorService;
import com.example.acpt.demo.service.impl.DoctorServiceIMPL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class DeleteDoctor {



    @FXML
    private TextField txtId;

    @FXML
    void Delete(ActionEvent event) {

        int id = Integer.parseInt(txtId.getText());

        DoctorService service = new DoctorServiceIMPL();

        boolean delete = service.deleteDoctor(id);

        if (delete) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("This is a JavaFX Alert");
            alert.setContentText("Doctor Deleted Successfully.");
            alert.showAndWait();

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("This is a JavaFX Alert");
            alert.setContentText("Doctor Delete failed.");
            alert.showAndWait();
        }


    }



















}
