import es.ulpgc.controller.GetAlbum;
import es.ulpgc.controller.GetArtist;
import es.ulpgc.controller.GetTrack;
import es.ulpgc.database.SQLiteMusicDatabase;
import es.ulpgc.model.Album;
import es.ulpgc.model.Artist;
import es.ulpgc.model.Track;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        SQLiteMusicDatabase sqLiteMusicDatabase = new SQLiteMusicDatabase();
        sqLiteMusicDatabase.init();

        List<String> ArtistId = new ArrayList();
        ArtistId.add("4F4pp8NUW08JuXwnoxglpN");
        ArtistId.add("1EXjXQpDx2pROygh8zvHs4");
        ArtistId.add("52iwsT98xCoGgiGntTiR7K");
        ArtistId.add("0jeYkqwckGJoHQhhXwgzk3");
        ArtistId.add("5Uox3n7m4W2CoM9MmHPJwQ");

        List<Artist> artists = new ArrayList<>();
        for (String id : ArtistId){
            artists.add(GetArtist.GetArtists(id));
        }
        for (Artist artist : artists){
            sqLiteMusicDatabase.insertArtist(artist);
        }
        List<Album> albums;
        for (String id: ArtistId) {
            albums = GetAlbum.GetAlbums(id);
            for (Album album : albums) {
                sqLiteMusicDatabase.insertAlbums(album);
            }
        }
        List<Track> tracks;
        for (String id: ArtistId){
            tracks = GetTrack.GetTracks(id);
            for (Track track:tracks){
                sqLiteMusicDatabase.insertTracks(track);
                }

            }
    }
}



