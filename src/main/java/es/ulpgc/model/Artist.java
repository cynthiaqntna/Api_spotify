package es.ulpgc.model;

public class Artist {
    public String id;
    public String name;
    public int popularity;
    public String uri;
    public String type;


    public Artist(String name, String id, int popularity, String type,String uri) {
        this.name = name;
        this.id = id;
        this.popularity = popularity;
        this.type = type;
        this.uri = uri;


    }
}
