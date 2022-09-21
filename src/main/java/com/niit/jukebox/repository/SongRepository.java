/*
 * Author Name : Jaswanth Sai
 * Date : 9/20/2022
 * Created With: INTELLIJ IDEA COMMUNITY EDITION
 */
package com.niit.jukebox.repository;

import com.niit.jukebox.comparator.ArtistComparator;
import com.niit.jukebox.comparator.GenreComparator;
import com.niit.jukebox.model.Song;
import com.niit.jukebox.service.DatabaseService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SongRepository {
    List<Song> songsList;
    DatabaseService databaseService;

    public SongRepository() {
        songsList = new ArrayList<>();
        databaseService = new DatabaseService();
    }

    public List<Song> displayAllSongs() {
        // get the connection
        databaseService.connect();
        Connection connection = databaseService.getConnection();
        // write the query
        String displayQuery = "SELECT * FROM `jukebox`.`song`;";
        // create a statement object
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(displayQuery);
            // create a song object
            Song song = new Song();
            // use the while loop to iterate over result set
            while (resultSet.next()) {
                // get all the values of the result set and set to song
                song.setSongId(resultSet.getInt("song_id"));
                song.setSongName(resultSet.getString("song_name"));
                song.setGenre(resultSet.getString("genre"));
                song.setArtist(resultSet.getString("artist"));
                song.setAlbum(resultSet.getString("album"));
                song.setDuration(resultSet.getString("duration"));
                songsList.add(song);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return songsList;
    }

    public List<Song> sortByGenre(List<Song> songsList) {
        // use the genre comparator
        GenreComparator genreComparator = (o1, o2) -> String.CASE_INSENSITIVE_ORDER.compare(o1.getGenre(), o2.getGenre());
        // sort the songs list according to genre
        songsList.sort(genreComparator);
        // return the list
        return songsList;
    }

    public List<Song> sortByArtist(List<Song> songsList) {
        // use the Artist comparator
        ArtistComparator artistComparator = (o1, o2) -> String.CASE_INSENSITIVE_ORDER.compare(o1.getArtist(), o2.getArtist());
        // sort the songs according to artist name
        songsList.sort(artistComparator);
        // return the list
        return songsList;
    }
}
