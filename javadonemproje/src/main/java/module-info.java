module com.example.javadonemproje {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javadonemproje to javafx.fxml;
    exports com.example.javadonemproje;
}