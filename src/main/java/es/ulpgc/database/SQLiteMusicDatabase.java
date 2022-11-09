package es.ulpgc.database;

import es.ulpgc.model.Album;
import es.ulpgc.model.Artist;
import es.ulpgc.model.Track;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteMusicDatabase implements MusicDatabase{
    private Connection conn;
    public Statement init() throws SQLException {
        String dbPath = "C:/Users/cynth/IdeaProjects/Api_spotify/src/main/java/es/ulpgc/database/table.db";
        conn = connect(dbPath);
        Statement statement = conn.createStatement();
        createTable(statement);
        return statement;
    }

    private Connection connect(String dbPath) {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:" + dbPath;
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insertArtist(Artist artist) throws  SQLException{
        Statement statement = conn.createStatement();
        statement.execute(DMLtranslate.insertArtist(artist));
    }

    public void insertAlbums(Album album) throws  SQLException{
        Statement statement = conn.createStatement();
        statement.execute(DMLtranslate.insertAlbum(album));
    }

    public void insertTracks(Track track) throws  SQLException{
        Statement statement = conn.createStatement();
        statement.execute(DMLtranslate.insertTrack(track));
    }

    private void createTable(Statement statement) throws SQLException {
        statement.execute("CREATE TABLE IF NOT EXISTS artists (" +
                "name TEXT," +
                "id TEXT," +
                "uri TEXT," +
                "popularity NUMBER," +
                "type TEXT" +
                ");");
        statement.execute("CREATE TABLE IF NOT EXISTS albums (" +
                "name TEXT," +
                "album_type TEXT," +
                "release_date TEXT," +
                "total_tracks NUMBER" +
                ");");
        statement.execute("CREATE TABLE IF NOT EXISTS tracks (" +
                "name TEXT," +
                "id TEXT," +
                "track_number NUMBER," +
                "duration_ms NUMBER," +
                "disc_number NUMBER" +
                ");");
    }
}
