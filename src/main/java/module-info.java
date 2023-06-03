module com.example.assigement {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.assigement to javafx.fxml;
    exports com.example.assigement;
}