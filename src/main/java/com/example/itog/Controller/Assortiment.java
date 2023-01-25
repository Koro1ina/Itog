package com.example.itog.Controller;

import com.example.itog.DatabaseHandler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class Assortiment implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox filtr;

    @FXML
    private ScrollPane scrol;

    @FXML
    private GridPane gridPane;

    @FXML
    private ComboBox sort;

    DatabaseHandler db = new DatabaseHandler();

    int root = 0;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {

        gridPane.getChildren().clear();

        ArrayList<String> zakaz = null;

        try {
            zakaz = db.getBook();
            createPanel(zakaz);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
             ArrayList<String> zakazStatus= db.getAutor();
             zakazStatus.add("Все");
             filtr.getItems().addAll(zakazStatus);
             sort.getItems().addAll("Дата по возрастанию", "Дата по убыванию", "По цене (от большей)", "По цене (от меньшей)");
        } catch (SQLException e) {
             throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
             throw new RuntimeException(e);
        }

    }

    public void clickFilter1(ActionEvent event) throws SQLException, ClassNotFoundException {

        gridPane.getChildren().clear();

        root = 0;

        String zakazStatus = (String) filtr.getValue();

        if(zakazStatus.equals("Все")){
            ArrayList<String> zakaz = db.getBook();
            createPanel(zakaz);
        }else{
            ArrayList<String> zakaz = db.getfiltr(zakazStatus);
            createPanel(zakaz);
        }
    }

    public void clickSortirovca1(ActionEvent event) throws SQLException, ClassNotFoundException {

        gridPane.getChildren().clear();

        String NameBook = "NameBook";
        String cell = "Cell";

        root = 0;

        String zakazStatus = (String) sort.getValue();

        if(zakazStatus.equals("Дата по возрастанию")){
            ArrayList<String> zakaz = db.getSortirovcaAZ(NameBook);
            createPanel(zakaz);
        }else if (zakazStatus.equals("Дата по убыванию")){
            ArrayList<String> zakaz = db.getSortirovcaZA(NameBook);
            createPanel(zakaz);
        }else if (zakazStatus.equals("По цене (от большей)")){
            ArrayList<String> zakaz = db.getSortirovcaZA(cell);
            createPanel(zakaz);
        }else if (zakazStatus.equals("По цене (от меньшей)")){
            ArrayList<String> zakaz = db.getSortirovcaAZ(cell);
            createPanel(zakaz);
        }
    }

    public void createPanel(ArrayList<String> zakaz) throws SQLException, ClassNotFoundException {
        for(int i = 0; i < zakaz.size(); i++){
            Label NameBook = new Label();
            Label Autor = new Label();
            Label Bookcol = new Label();
            Label Cell = new Label();
            NameBook.setText("Наименование: "+zakaz.get(i++));
            NameBook.setMinHeight(30);
            NameBook.setAlignment(Pos.CENTER);
            NameBook.setFont(new Font("Italic", 15));
            NameBook.setTextFill(Color.web("#41a4a7"));
            Autor.setText("Автор: "+zakaz.get(i++));
            Autor.setMinHeight(30);
            Autor.setFont(new Font("Italic", 15));
            Bookcol.setText("Количество: "+zakaz.get(i++));
            Bookcol.setMinHeight(30);
            Bookcol.setFont(new Font("Italic", 15));
            Bookcol.setTextFill(Color.web("#2338fc"));
            Cell.setText("Стоимость: "+zakaz.get(i));
            Cell.setMinHeight(30);
            Cell.setFont(new Font("Italic", 15));
            Cell.setTextFill(Color.web("#2338fc"));

            gridPane.setHalignment(NameBook, HPos.CENTER);
            gridPane.add(NameBook, 0, root);
            gridPane.add(Autor, 1, root);
            gridPane.add(Bookcol, 2, root);
            gridPane.add(Cell, 3, root);
            root++;
        }

    }

}

