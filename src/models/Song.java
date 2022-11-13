/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import interfaces.ISong;

/**
 *
 * @author Silvia
 */
public class Song implements ISong {
    String title;
    String artist;
    String album;
    String duration;
    String genre;
    
    @Override
    public void setTitle(String _title) {
        this.title = _title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setArtist(String _artist) {
        this.artist = _artist;
    }

    @Override
    public String getArtist() {
        return artist;
    }

    @Override
    public void setAlbum(String _album) {
        this.album =_album;
    }

    @Override
    public String getAlbum() {
        return this.album;
    }

    @Override
    public void setDuration(String _duration) {
        this.duration =_duration;
    }

    @Override
    public String getDuration() {
        return this.duration;
    }

    @Override
    public void setGenre(String _genre) {
        this.genre = _genre;
    }

    @Override
    public String getGenre() {
        return this.genre;
    }
    
}
