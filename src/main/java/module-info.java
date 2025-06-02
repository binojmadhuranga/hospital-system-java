module com.example.acpt.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.example.acpt.demo to javafx.fxml;
    exports com.example.acpt.demo;
    exports com.example.acpt.demo.controller;
    opens com.example.acpt.demo.controller to javafx.fxml;
    opens com.example.acpt.demo.dto to javafx.base;
}