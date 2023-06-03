package com.example.assigement;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Duration;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Button bntCopyItems;

    @FXML
    private Button btnCopyOneItem;

    @FXML
    private Button btnCopyTwo;

    @FXML
    private Button btnCopyone;
    @FXML
    private Button btnClear;

    @FXML
    private Label lblListviewTwo;

    @FXML
    private Label lblTitlte;

    @FXML
    private Label lbllistviewOne;

    @FXML
    private ListView<String> lisView2;

    @FXML
    private ListView<String> listView1;
    @FXML
    private Label lblCounter1;

    @FXML
    private Label lblCounter2;

    @FXML

    private Button btnAdditems;
    @FXML
    private TextField txtFiled;
    @FXML
    private Label dateTimeLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalDateTime currentDateTime = LocalDateTime.now();
//            String formattedDateTime = currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            String formattedTime = currentDateTime.format((DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            dateTimeLabel.setText(formattedTime);
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();


        listView1.getItems().addAll("Omar jibril", "Hassan Ali", "Ifrax", "Bahja", "Rowda",
                "Abdulkhadir", "Abdullahi Ali Khaliifa", "Ramlo Mohamed Huseen", "Mahamed Ali" +
                        "", "Cadnan Ali", "Osman Adan", "Asma Jibril Abdullkadir", "Fatima Ali Osman", "Qali Osman jamac", "Sheceyb Da'uud");
        lblCounter1.setText("Count: " + listView1.getItems().size());
        listView1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        lisView2.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    public void handleRemoveButtonAction(ActionEvent event) {
        String selectedItem = listView1.getSelectionModel().getSelectedItem();

        if (selectedItem.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No item selected");
            alert.setContentText("Please select an item to copy.");
            alert.showAndWait();
        } else {

            lisView2.getItems().addAll(selectedItem);
            lblCounter2.setText("Count: " + lisView2.getItems().size());

            listView1.getItems().removeAll(selectedItem);
            lblCounter1.setText("Count: " + listView1.getItems().size());

        }


    }

    public void clearItems(ActionEvent event) {
        lisView2.getItems().clear();
        lblCounter2.setText("Count: " + lisView2.getItems().size());
    }


    public void handleRemoveAllItems(ActionEvent event) {
        listView1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        lblCounter1.setText("Count: " + listView1.getItems().size());

        ObservableList<String> selectedItems = listView1.getSelectionModel().getSelectedItems();

        if (selectedItems.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No item selected");
            alert.setContentText("Please select an item to copy.");
            alert.showAndWait();
        } else {

            lisView2.getItems().addAll(selectedItems);
            lblCounter2.setText("Count: " + lisView2.getItems().size());

            listView1.getItems().removeAll(selectedItems);
            lblCounter1.setText("Count: " + listView1.getItems().size());



        }

    }

    public void handleBackOriganalListView(ActionEvent event) {
        ObservableList<String> selectedItems = lisView2.getSelectionModel().getSelectedItems();

        if (selectedItems.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No item selected");
            alert.setContentText("Please select an item to copy.");
            alert.showAndWait();
        } else {

            listView1.getItems().addAll(selectedItems);
            lblCounter1.setText("Count: " + listView1.getItems().size());

            lisView2.getItems().removeAll(selectedItems);
            lblCounter2.setText("Count: " + lisView2.getItems().size());

        }
    }



    public void handleReadButtonAction(ActionEvent event) {
    }


    public void handleRemoveAllItems2(ActionEvent event) {
        listView1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//        lblCounter1.setText("Count: " + listView1.getItems().size());

        ObservableList<String> selectedItems = lisView2.getSelectionModel().getSelectedItems();

        if (selectedItems.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No item selected");
            alert.setContentText("Please select an item to copy.");
            alert.showAndWait();
        } else {

            listView1.getItems().addAll(selectedItems);
            lblCounter1.setText("Count: " + listView1.getItems().size());

            lisView2.getItems().removeAll(selectedItems);
            lblCounter2.setText("Count: " + lisView2.getItems().size());



        }

    }

}
