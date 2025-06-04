package com.example.acpt.demo.controller;

import com.example.acpt.demo.dto.DoctorDto;
import com.example.acpt.demo.service.DoctorService;
import com.example.acpt.demo.service.impl.DoctorServiceIMPL;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class loadAllController implements Initializable {


//    @FXML
//    private Button loadAll;
//
//    @FXML
//    private AnchorPane tbl1;

    @FXML
    private TableView<DoctorDto> tblDoctor;



//    @FXML
//    void load(ActionEvent event) {
//
//        DoctorService service = new DoctorServiceIMPL();
//        List<DoctorDto> allDoctors = service.getAllDoctors();
//
//        //table config
//        tblDoctor.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
//        tblDoctor.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
//        tblDoctor.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("age"));
//        tblDoctor.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("email"));
//        tblDoctor.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("specialization"));
//
//        tblDoctor.setItems(FXCollections.observableArrayList(allDoctors));
//
//
//
//    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Load all doctors when the controller is initialized
        DoctorService service = new DoctorServiceIMPL();
        List<DoctorDto> allDoctors = service.getAllDoctors();

        //table config
        tblDoctor.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblDoctor.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblDoctor.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("age"));
        tblDoctor.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("email"));
        tblDoctor.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("specialization"));

        tblDoctor.setItems(FXCollections.observableArrayList(allDoctors));

    }
}
