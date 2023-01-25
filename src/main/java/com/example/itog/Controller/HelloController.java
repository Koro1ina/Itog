package com.example.itog.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.example.itog.Client;
import com.example.itog.DatabaseHandler;
import com.example.itog.HelloApplication;
import com.example.itog.Shake.Shake;
import com.example.itog.Sotr;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_field;

    @FXML
    private Button login_signup;

    @FXML
    private PasswordField password_field;


    @FXML
    private Button registr;


    @FXML
    void initialize() {

        registr.setOnAction(actionEvent -> {
            registr.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HelloApplication.class.getResource("Registr.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Регистрация");
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

        login_signup.setOnAction(actionEvent -> {
            String loginText = login_field.getText().trim();
            String passText = password_field.getText().trim();

            if (!loginText.equals("") && !passText.equals("")) {
                loginClient(loginText, passText);
                loginSotr(loginText, passText);
            } else {
                System.out.println("Login and password is empty");
                Shake userLoginAnim = new Shake(login_field);
                Shake userPassAnim = new Shake(password_field);
                userLoginAnim.playAnim();
                userPassAnim.playAnim();
            }
        });
    }

    private void loginSotr(String loginText, String passText) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        Sotr user = new Sotr();
        user.setLOGIN_SOTR(loginText);
        user.setPASSWORD_SOTR(passText);
        ResultSet result = dbHandler.getSotr(user);

        int counter = 0;

        try {
            while (result.next()){
                counter++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (counter >= 1) {
            System.out.println("Success!");
            login_signup.getScene().getWindow().hide();

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
        } else {
            Shake userLoginAnim = new Shake(login_field);
            Shake userPassAnim = new Shake(password_field);
            userLoginAnim.playAnim();
            userPassAnim.playAnim();
        }
    }

    private void loginClient(String loginText, String passText) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        Client user = new Client();
        user.setLOGIN_CLIENT(loginText);
        user.setPASSWORD_CLIENT(passText);
        ResultSet result = dbHandler.getUser(user);

        int counter = 0;

        try {
            while (result.next()){
                counter++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (counter >= 1) {
            System.out.println("Success!");
            login_signup.getScene().getWindow().hide();

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
        } else {
            Shake userLoginAnim = new Shake(login_field);
            Shake userPassAnim = new Shake(password_field);
            userLoginAnim.playAnim();
            userPassAnim.playAnim();
        }
    }


}