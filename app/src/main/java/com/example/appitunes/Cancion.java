package com.example.appitunes;

public class Cancion {
    private int artistId;
    private String artistName;
    private String trackName;


    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public Cancion() {
    }

    public Cancion( int artistId, String artistName, String trackName) {
        this.artistId = artistId;
        this.artistName = artistName;
        this.trackName = trackName;
    }
}
