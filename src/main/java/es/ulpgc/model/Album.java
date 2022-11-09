package es.ulpgc.model;

import com.google.gson.JsonArray;

public class Album {
    public String album_type;
    public String name;
    public int total_tracks;
    public String release_date;

    public Album(String album_type, String name, int total_tracks, String release_date){
        this.album_type = album_type;
        this.name = name;
        this.total_tracks = total_tracks;
        this.release_date = release_date;
    }
}
