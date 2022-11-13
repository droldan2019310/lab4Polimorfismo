/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import interfaces.ICarC;
import interfaces.ISong;
import java.util.ArrayList;

/**
 *
 * @author Silvia
 */
public class CarC implements ICarC {
    int volume;
    boolean frequency;
    ArrayList<Float> stations = new ArrayList();
    float actualStation;
    int repType;
    ArrayList<ISong> songsMP3 = new ArrayList();
    ArrayList<ISong> songsCD = new ArrayList();
    ArrayList<ISong> songsSPOTIFY = new ArrayList();
    int currentIndex;
    boolean phoneConnectionStatus;
    ArrayList<String> contacts = new ArrayList();
    int callStatus;
    String weather;
    boolean radioStatus;
    String actualNameCall;

    public CarC(int volume, boolean frequency, float actualStation, int repType, int currentIndex, boolean phoneConnectionStatus, int callStatus, String weather, boolean radioStatus, String actualNameCall) {
        this.volume = volume;
        this.frequency = frequency;
        this.actualStation = actualStation;
        this.repType = repType;
        this.currentIndex = currentIndex;
        this.phoneConnectionStatus = phoneConnectionStatus;
        this.callStatus = callStatus;
        this.weather = weather;
        this.radioStatus = radioStatus;
        this.actualNameCall = actualNameCall;
    }
    
    

    
    
    
    
    
    @Override
    public boolean SwitchRadioONOFF() {
        this.radioStatus = !this.radioStatus;
        return this.radioStatus;
    }

    @Override
    public boolean getRadioStatus() {
        return radioStatus;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int Volume) {
        this.volume = volume;
    }

    @Override
    public boolean SwitchFrequency() {
        this.frequency = !this.frequency;
        
        return this.frequency;
    }

    @Override
    public boolean getFrequency() {
       return this.frequency;
    }

    @Override
    public void setStation(float stationChange) {
        this.actualStation = stationChange;
    }

    @Override
    public float getStation() {
        return actualStation;
    }

    @Override
    public void SaveStation(float _station) {
        this.stations.add(_station);
    }

    @Override
    public float SelectSpecificStation(int _StationIndex) {
        return this.stations.get(_StationIndex);
    }

    @Override
    public int getAudioRepType() {
        return this.repType;
    }

    @Override
    public void setAudioRepType(int repType) {
        this.repType = repType;
    }

    @Override
    public ArrayList<ISong> getAListOfSongs(int TypeOfAudioReproduction) {
        if(TypeOfAudioReproduction ==1){
            return songsCD;
        }else if(TypeOfAudioReproduction==2){
            return songsSPOTIFY;
        }else{
            return songsMP3;
        }
    }

    @Override
    public void NextSong(int CurrentIndex, int TypeOfAudioReproduction) {
        if(TypeOfAudioReproduction ==1){
            if(CurrentIndex+1>songsCD.size()){
                this.currentIndex=0;
            }else{
                this.currentIndex=this.currentIndex+1;
            }
        }else if(TypeOfAudioReproduction==2){
            if(CurrentIndex+1>songsSPOTIFY.size()){
                this.currentIndex=0;
            }else{
                this.currentIndex=this.currentIndex+1;
            }
        }else{
            if(CurrentIndex+1>songsMP3.size()){
                this.currentIndex=0;
            }else{
                this.currentIndex=this.currentIndex+1;
            }
        }
           
    }

    @Override
    public void PrevSong(int CurrentIndex, int TypeOfAudioReproduction) {
         if(TypeOfAudioReproduction ==1){
            if(CurrentIndex-1<0){
                this.currentIndex=songsCD.size();
            }else{
                this.currentIndex=this.currentIndex-1;
            }
        }else if(TypeOfAudioReproduction==2){
            if(CurrentIndex-1<0){
                this.currentIndex=songsSPOTIFY.size();
            }else{
                this.currentIndex=this.currentIndex-1;
            }
        }else{
            if(CurrentIndex-1<0){
                this.currentIndex=songsMP3.size();
            }else{
                this.currentIndex=this.currentIndex-1;
            }
        }
    }

    @Override
    public String PlaySong(int TypeOfAudioReproduction) {
        if(TypeOfAudioReproduction ==1){
            return this.songsCD.get(this.currentIndex).getTitle();
        }else if(TypeOfAudioReproduction==2){
            return this.songsSPOTIFY.get(this.currentIndex).getTitle();
        }else{
            return this.songsMP3.get(this.currentIndex).getTitle();
        }
    }

    @Override
    public boolean Connect_DisconnectPhone() {
        this.phoneConnectionStatus = !this.phoneConnectionStatus;
        return this.phoneConnectionStatus;
    }

    @Override
    public boolean getPhoneConnectionStatus() {
        return this.phoneConnectionStatus;

    }

    @Override
    public ArrayList<String> getListofContacts() {
        return this.contacts;
    }

    @Override
    public int getCallStatus() {
        return this.callStatus;
    }

    @Override
    public String makeCall(String NameforCall) {
        boolean flag=false;
        for(String name: this.contacts){
            if(name==NameforCall){
               flag=true;
            }
        }
        
        if(flag){
            this.callStatus=1;
            this.actualNameCall = NameforCall;
            return NameforCall;
        }else{
            return "no es posible llamar a esta persona";
        }
    }

    @Override
    public String PlaceCallOnHold() {
        this.callStatus=2;
        return this.actualNameCall;
        
    }

    @Override
    public String endCall() {
        this.callStatus=0;
        this.actualNameCall="";
        return "LLAMADA FINALIZADA";
    }

    @Override
    public String getWeatherForCast() {
        return "TEMPLADO";
    }
    
}
