package com.example.itog.Controller;

import com.example.itog.Client;
import com.example.itog.DatabaseHandler;
import com.example.itog.HelloApplication;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegistrController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField reg_FIO;

    @FXML
    private TextField reg_dateBD;

    @FXML
    private TextField reg_login;

    @FXML
    private TextField reg_passport;

    @FXML
    private PasswordField reg_password;

    @FXML
    private Button reg_button;

    @FXML
    void initialize() {
        reg_button.setOnAction(event -> {

            signUpNewClient();

            reg_button.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HelloApplication.class.getResource("Interface.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Главное меню");
            stage.setScene(new Scene(root));
            stage.showAndWait();

        });
    }

    private void signUpNewClient() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        String FIO_CLIENT = reg_FIO.getText().trim();
        String PASSPORT_CLIENT = reg_passport.getText();
        String DATEBD_CLIENT = reg_dateBD.getText().trim();
        String LOGIN_CLIENT = reg_login.getText().trim();
        String PASSWORD_CLIENT = reg_password.getText().trim();

        Client client = new Client(FIO_CLIENT, PASSPORT_CLIENT, DATEBD_CLIENT, LOGIN_CLIENT, PASSWORD_CLIENT);

        dbHandler.signUpUser(client);

    }
}



