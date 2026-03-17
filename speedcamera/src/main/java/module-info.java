module com.code {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.code to javafx.fxml;
    opens com.models to javafx.base;
    
    exports com.code;
    exports com.models;
}
