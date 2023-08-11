module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires java.sql;


    exports bank;
    opens bank to javafx.fxml;
}