package com.example.itog.Controller;

import com.example.itog.HelloApplication;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InterfaceController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button check_assortiment;

    @FXML
    private Button personal_client;


    @FXML
    void initialize() {
        check_assortiment.setOnAction(actionEvent -> {
            Stage stage = new Stage();
            check_assortiment.getScene().getWindow().hide();

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("assortiment.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 866, 551);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setTitle("Товары");
            stage.setScene(scene);
            stage.show();
            Stage stageNow = (Stage) check_assortiment.getScene().getWindow();
            stageNow.close();
        });


    }

}
