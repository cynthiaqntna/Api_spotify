package es.ulpgc.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import es.ulpgc.api.SpotifyAccessor;
import es.ulpgc.model.Album;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetAlbum {
    public static List<Album> GetAlbums(String artistId) throws Exception {
        SpotifyAccessor accessor = new SpotifyAccessor();
        String response = accessor.get("/artists/" + artistId + "/albums", Map.of());
        JsonObject jsonObject = new Gson().fromJson(response, JsonObject.class);
        JsonArray items = jsonObject.get("items").getAsJsonArray();
        List<Album> albums = new ArrayList<>();
        for (JsonElement item : items) {
            String album_type =item.getAsJsonObject().get("album_type").getAsString();
            String name = item.getAsJsonObject().get("name").getAsString();
            int total_tracks = item.getAsJsonObject().get("total_tracks").getAsInt();
            String release_date = item.getAsJsonObject().get("release_date").getAsString();
            Album album = new Album(album_type,name,total_tracks,release_date);
            albums.add(album);
        }
    return albums;
    }
}


