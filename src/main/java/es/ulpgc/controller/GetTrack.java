package es.ulpgc.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import es.ulpgc.api.SpotifyAccessor;
import es.ulpgc.model.Track;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetTrack {
    public static List<Track> GetTracks(String artistId) throws Exception {
        SpotifyAccessor accessor = new SpotifyAccessor();
        String response = accessor.get("/artists/" + artistId + "/albums", Map.of());
        JsonObject jsonObject = new Gson().fromJson(response, JsonObject.class);
        List<String> albums = new ArrayList<>();
        JsonArray items = jsonObject.get("items").getAsJsonArray();
        for (JsonElement item : items) {
            albums.add(item.getAsJsonObject().get("id").getAsString());
        }
        List<Track> tracks = new ArrayList<>();
        for (String album : albums){
            String res = accessor.get("/albums/" + album + "/tracks", Map.of());
            JsonObject jsonObj = new Gson().fromJson(res, JsonObject.class);
            JsonArray items1 = jsonObj.get("items").getAsJsonArray();
            for (JsonElement item : items1) {
                String id = item.getAsJsonObject().get("id").getAsString();
                String name = item.getAsJsonObject().get("name").getAsString();
                int duration_ms = item.getAsJsonObject().get("duration_ms").getAsInt();
                int track_number  = item.getAsJsonObject().get("track_number").getAsInt();
                int disc_number  = item.getAsJsonObject().get("disc_number").getAsInt();
                Track track = new Track(id, name,duration_ms, track_number,disc_number);
                tracks.add(track);
            }

        }
        return tracks;
    }
}
