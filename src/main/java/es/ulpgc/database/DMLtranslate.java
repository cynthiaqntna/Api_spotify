package es.ulpgc.database;
import es.ulpgc.model.Album;
import es.ulpgc.model.Artist;
import es.ulpgc.model.Track;

public class DMLtranslate {
    private static final String INSERT_ARTIST =
            "INSERT INTO artists(name, id,uri, popularity, type) VALUES('%s', '%s','%s', '%d', '%s');";

    public static String insertArtist(Artist artist) {
        return String.format(INSERT_ARTIST,
                artist.name,
                artist.id,
                artist.uri,
                artist.popularity,
                artist.type);
    }



    private static final String INSERT_ALBUM =
            "INSERT INTO albums(album_type,name,total_tracks, release_date) VALUES('%s', '%s', '%d', '%s')";

    public static String insertAlbum(Album album){
        return String.format(INSERT_ALBUM,
                album.album_type,
                album.name,
                album.total_tracks,
                album.release_date
        );
    }

    private static final String INSERT_TRACK =
            "INSERT INTO tracks(id,name, duration_ms,track_number,disc_number) VALUES('%s', '%s', '%d','%d','%d')";
    public static String insertTrack(Track track){
        return String.format(INSERT_TRACK,
                track.id,
                track.name,
                track.duration_ms,
                track.track_number,
                track.disc_number
        );
    }

}

