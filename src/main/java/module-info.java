module com.example.itog {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mybatis;


    opens com.example.itog to javafx.fxml;
    exports com.example.itog;
    exports com.example.itog.Controller;
    opens com.example.itog.Controller to javafx.fxml;
    exports com.example.itog.Shake;
    opens com.example.itog.Shake to javafx.fxml;
}