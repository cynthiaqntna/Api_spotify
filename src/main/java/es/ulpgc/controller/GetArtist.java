package es.ulpgc.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import es.ulpgc.api.SpotifyAccessor;
import es.ulpgc.model.Artist;

import java.util.Map;

public class GetArtist {
    public static Artist GetArtists(String artistId) throws Exception {
        SpotifyAccessor accessor = new SpotifyAccessor();
        String json = accessor.get("/artists/" + artistId, Map.of());
        Gson gson = new Gson();
        JsonObject object = gson.fromJson(json, JsonObject.class);
        String name = object.getAsJsonObject().get("name").getAsString();
        int popularity = object.getAsJsonObject().get("popularity").getAsInt();
        String type = object.getAsJsonObject().get("type").getAsString();
        String id = object.getAsJsonObject().get("id").getAsString();
        String uri = object.getAsJsonObject().get("uri").getAsString();
        return new Artist(name,id,popularity,type,uri);
    }

}
