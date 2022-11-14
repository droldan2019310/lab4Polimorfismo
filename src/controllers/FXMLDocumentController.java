/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import interfaces.ISong;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.CarC;
import models.Song;

/**
 *
 * @author Davis
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private TextField actualVolume;
    @FXML
    private ComboBox<String> modeRadio;
    @FXML
    private ComboBox<String> cmbModeRepro;
    @FXML
    private ComboBox<String> cmbModePhone;
    @FXML
    private TableView<Song> tableCD;
    @FXML
    private TableColumn<Song, String> titleCD;
    @FXML
    private TableColumn<Song, String> artistCD;
    @FXML
    private TableView<Song> tableMP3;
    @FXML
    private TableColumn<Song, String> songMP3;
    @FXML
    private TableColumn<Song, String> artistMP3;
    @FXML
    private TableView<Song> tableSPOTIFY;
    @FXML
    private TableColumn<Song, String> songSpotify;
    @FXML
    private TableColumn<Song, String> artistSpotify;
    private TableView<Float> tableStation;
    @FXML
    private TextField actualSong;
    @FXML
    private Button prevSongButton;
    @FXML
    private Button nextSongButton;
    @FXML
    private TextField climaTxt;
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
    
    CarC carC;
    @FXML
    private Button downVolumeButton;
    @FXML
    private Button upVolumeButton;
    
    private boolean status=true;
    @FXML
    private Button onOffAllButton;
    
    private ObservableList<String>modePhoneList;
    
    private ObservableList<String>modeRepTypeList;

    private ObservableList<String>modeRadioList;
    
    private ObservableList<Song> listSongsCD;
    private ObservableList<Song> listSongsMP3;
    private ObservableList<Song> listSongsSPOTIFY;
    private ObservableList<Float> listStations;
    private ObservableList<String> listContacts;
    
    int currentIndex=0;
    @FXML
    private ComboBox<Float> stationsCmb;
    @FXML
    private ComboBox<String> contactCmb; 
   @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        carC = new CarC();
        carC.setAudioRepType(1);
        actualVolume.setText(String.valueOf(carC.getVolume()));
        setStatus();
        fillModePhone();
        fillModeRadio();
        fillModeRep();
        fillStations();
        fillContacts();
        uploadDatatableCD();
        uploadDatatableMP3();        
        uploadDatatableSPOTIFY();
        
        cmbModeRepro.setValue("CD");        
        cmbModePhone.setValue("APAGADO");
        onOffRadioButton.setText("APAGADO RADIO");
        onOffReproButton.setText("ENCENDIDO REPRODUCTOR");
        modeRadio.setValue("FM");
        stationsCmb.setDisable(true);
        this.actualSong.setText(carC.PlaySong(carC.getAudioRepType()));
        climaTxt.setText("TEMPLADO");
        
    }    
    
   
    
    
    public void uploadDatatableCD(){
        
        listSongsCD = FXCollections.observableList(carC.getAListOfSongs(1));
        tableCD.setItems(listSongsCD);
        titleCD.setCellValueFactory(new PropertyValueFactory("title"));
        artistCD.setCellValueFactory(new PropertyValueFactory("artist"));
    }
    
    
    public void uploadDatatableMP3(){
        //configura la table de programas en ejecución
        listSongsMP3 = FXCollections.observableList(carC.getAListOfSongs(3));
        tableMP3.setItems(listSongsMP3);
        songMP3.setCellValueFactory(new PropertyValueFactory("title"));
        artistMP3.setCellValueFactory(new PropertyValueFactory("artist"));
    }
    
    
    public void uploadDatatableSPOTIFY(){
        //configura la table de programas en ejecución
        listSongsSPOTIFY = FXCollections.observableList(carC.getAListOfSongs(2));
        tableSPOTIFY.setItems(listSongsSPOTIFY);
        songSpotify.setCellValueFactory(new PropertyValueFactory("title"));
        artistSpotify.setCellValueFactory(new PropertyValueFactory("artist"));
    }
    
    
   
    
    public void setStatus(){
        if(status){
            onOffAllButton.setText("ENCENDIDO");
        }else{
            onOffAllButton.setText("APAGADO");
        }
    }
    
    
    public void fillModePhone(){
        ArrayList<String> list = new ArrayList();
        list.add(0,"CONECTADO");
        list.add(1,"DESCONECTADO");
        modePhoneList = FXCollections.observableList(list);
        cmbModePhone.setItems(modePhoneList);
    }
    
    
    public void fillModeRadio(){
        ArrayList<String> list = new ArrayList();
        list.add(0,"AM");
        list.add(1,"FM");
        modeRadioList = FXCollections.observableList(list);
        modeRadio.setItems(modeRadioList);
    }
    
    
    public void fillModeRep(){
        ArrayList<String> list = new ArrayList();
        list.add(0,"CD");
        list.add(1,"MP3");
        list.add(2,"SPOTIFY");
        modeRepTypeList = FXCollections.observableList(list);
        cmbModeRepro.setItems(modeRepTypeList);
    }
    
    public void fillStations(){
        
        listStations = FXCollections.observableList(carC.getStations());
        stationsCmb.setItems(listStations);
    }
    
    
    public void fillContacts(){
        
        listContacts = FXCollections.observableList(carC.getListofContacts());
        contactCmb.setItems(listContacts);
    }
    
    
    @FXML
    private void onOffRadio(ActionEvent event) {
        
        
        if(carC.getStatusRep()){
        
        }else{
            carC.SwitchRadioONOFF();
            if(carC.getRadioStatus()){
                onOffRadioButton.setText("RADIO ENCENDIDO");
                
                stationsCmb.setDisable(false);
            }else{
                stationsCmb.setDisable(true);
                onOffRadioButton.setText("RADIO APAGADO");
            }
        }
        
        
    }

    @FXML
    private void changeModeRadio(ActionEvent event) {
        
    }

    @FXML
    private void changeModeRepro(ActionEvent event) {
        carC.setCurrentIndex(0);
        if(cmbModeRepro.getValue().equals("MP3")){
            carC.setAudioRepType(3);
        }else if(cmbModeRepro.getValue().equals("CD")){
            carC.setAudioRepType(1);
        }else if(cmbModeRepro.getValue().equals("SPOTIFY")){
            carC.setAudioRepType(2);
        }
        
        this.actualSong.setText(carC.PlaySong(carC.getAudioRepType()));

    }

    @FXML
    private void changeModePhone(ActionEvent event) {
        carC.Connect_DisconnectPhone();
    }

    @FXML
    private void prevSong(ActionEvent event) {
        
        if(carC.getStatusRep()){
            carC.PrevSong(carC.getCurrentIndex(), carC.getAudioRepType());
            this.actualSong.setText(carC.PlaySong(carC.getAudioRepType()));
        }else{
        
        }
        
    }

    @FXML
    private void nextSong(ActionEvent event) {
        
        if(carC.getStatusRep()){
            carC.NextSong(carC.getCurrentIndex(), carC.getAudioRepType());
            this.actualSong.setText(carC.PlaySong(carC.getAudioRepType()));
        }else{
            
        }
    }


    @FXML
    private void call(ActionEvent event) {
        
        String value = carC.makeCall(contactCmb.getValue());
        
        txtresponseCall.setText(value);
    }

    @FXML
    private void onOffRepro(ActionEvent event) {
        
        if(carC.getRadioStatus()){
            
        }else{
            this.carC.switchStatusRep();
            if(this.carC.getStatusRep()){
                prevSongButton.setDisable(false);
                nextSongButton.setDisable(false);
                onOffReproButton.setText("ENCENDIDO REPRODUCTOR");
            }else{
                 prevSongButton.setDisable(true);
                nextSongButton.setDisable(true);
                onOffReproButton.setText("APAGADO REPRODUCTOR");
            }
        }
        
    }

    @FXML
    private void endCall(ActionEvent event) {
        String value = carC.endCall();
        
        txtresponseCall.setText(value);
        
    }

    @FXML
    private void waitCall(ActionEvent event) {
        String value = carC.PlaceCallOnHold();
        
        txtresponseCall.setText(value);
    }

    @FXML
    private void downVolume(ActionEvent event) {
        int volume = carC.getVolume();
        
        if(volume-1<0){
            carC.setVolume(0);
        }else{
            carC.setVolume(volume-1);
        }
        
        actualVolume.setText(String.valueOf(carC.getVolume()));
    }

    @FXML
    private void upVolume(ActionEvent event) {
        int volume = carC.getVolume()+1;
        carC.setVolume(volume);
        actualVolume.setText(String.valueOf(carC.getVolume()));
    }

    @FXML
    private void onOffAll(ActionEvent event) {
        status = !status;
        
        setStatus();
    }

    @FXML
    private void changeStations(ActionEvent event) {
    }

    @FXML
    private void changeContact(ActionEvent event) {
    }
    
}
