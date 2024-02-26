module org.example.f1app {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.f1app to javafx.fxml;
    exports org.example.f1app;
}