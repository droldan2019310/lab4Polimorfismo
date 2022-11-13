/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author Davis
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private TextField actualVolume;
    @FXML
    private Button downVolume;
    @FXML
    private Button upVolume;
    @FXML
    private ComboBox<?> modeRadio;
    @FXML
    private ComboBox<?> cmbModeRepro;
    @FXML
    private ComboBox<?> cmbModePhone;
    @FXML
    private TextField actualStation;
    @FXML
    private TableView<?> tableCD;
    @FXML
    private TableColumn<?, ?> titleCD;
    @FXML
    private TableColumn<?, ?> artistCD;
    @FXML
    private TableView<?> tableMP3;
    @FXML
    private TableColumn<?, ?> songMP3;
    @FXML
    private TableColumn<?, ?> artistMP3;
    @FXML
    private TableView<?> tableSPOTIFY;
    @FXML
    private TableColumn<?, ?> songSpotify;
    @FXML
    private TableColumn<?, ?> artistSpotify;
    @FXML
    private TableView<?> tableStation;
    @FXML
    private TableColumn<?, ?> station;
    @FXML
    private TextField actualSong;
    @FXML
    private Button prevSongButton;
    @FXML
    private Button nextSongButton;
    @FXML
    private TextField climaTxt;
    @FXML
    private Button nextStationButton;
    @FXML
    private Button prevStationButton;
    @FXML
    private TableView<?> tableContacts;
    @FXML
    private TableColumn<?, ?> contact;
    @FXML
    private Button callButton;
    @FXML
    private Button onOffRadioButton;
    @FXML
    private Button onOffReproButton;
    @FXML
    private TextField txtresponseCall;
    @FXML
    private Button endCallButton;
    @FXML
    private Button waitCallButton;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onOffRadio(ActionEvent event) {
    }

    @FXML
    private void changeModeRadio(ActionEvent event) {
    }

    @FXML
    private void changeModeRepro(ActionEvent event) {
    }

    @FXML
    private void changeModePhone(ActionEvent event) {
    }

    @FXML
    private void prevSong(ActionEvent event) {
    }

    @FXML
    private void nextSong(ActionEvent event) {
    }

    @FXML
    private void nextStation(ActionEvent event) {
    }

    @FXML
    private void prevStation(ActionEvent event) {
    }

    @FXML
    private void call(ActionEvent event) {
    }

    @FXML
    private void onOffRepro(ActionEvent event) {
    }

    @FXML
    private void endCall(ActionEvent event) {
    }

    @FXML
    private void waitCall(ActionEvent event) {
    }
    
}
