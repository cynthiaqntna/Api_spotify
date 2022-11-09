package es.ulpgc.model;

public class Track {

    public String name;
    public int disc_number;
    public int duration_ms;

    public String id;
    public int track_number;


    public Track(String id, String name, int track_number, int disc_number, int duration_ms) {
        this.id = id;
        this.name = name;
        this.track_number = track_number;
        this.disc_number = disc_number;
        this.duration_ms = duration_ms;
    }


}



