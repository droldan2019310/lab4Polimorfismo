/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author Davis
 */
public interface ISong {
    public void setTitle(String _title);
	
    public String getTitle();

    public void setArtist(String _artist);

    public String getArtist();

    public void setAlbum(String _album);

    public String getAlbum();

    public void setDuration(String _duration);

    public String getDuration();

    public void setGenre(String _genre);

    public String getGenre();
}
