/*
 * Author Name : Jaswanth Sai
 * Date : 9/20/2022
 * Created With: INTELLIJ IDEA COMMUNITY EDITION
 */
package com.niit.jukebox.repository;

import com.niit.jukebox.model.Song;
import com.niit.jukebox.service.DatabaseService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SongRepository implements Repository {
    List<Song> songsList;
    DatabaseService databaseService;

    public SongRepository() {
        songsList = new ArrayList<>();
        databaseService = new DatabaseService();
    }

    @Override
    // This method is used to display all the songs in the database.
    public List<Song> displayAllSongs() {
        List<Song> allSongs = new ArrayList<>();
        // get the connection
        databaseService.connect();
        Connection connection = databaseService.getConnection();
        // write the query
        String displayQuery = "SELECT * FROM `jukebox`.`song`;";
        // create a statement object
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(displayQuery);
            // create a song object
            // use the while loop to iterate over result set
            while (resultSet.next()) {
                Song song = new Song();
                // get all the values of the result set and set to song
                song.setSongId(resultSet.getInt("song_id"));
                song.setSongName(resultSet.getString("song_name"));
                song.setGenre(resultSet.getString("genre"));
                song.setArtist(resultSet.getString("artist"));
                song.setAlbum(resultSet.getString("album"));
                song.setDuration(resultSet.getString("duration"));
                song.setSongPath(resultSet.getString("song_path"));
                allSongs.add(song);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return allSongs;
    }

    @Override
    // This method is used to search the songs by genre.
    public List<Song> searchByGenre(List<Song> songsList, String genreName) {
        return songsList.stream().filter(songsGenre -> songsGenre.getGenre().equals(genreName)).collect(Collectors.toList());
    }

    @Override
    // This method is used to search the songs by artist.
    public List<Song> searchByArtist(List<Song> songsList, String artist) {
        return songsList.stream().filter(artistSongs -> artistSongs.getArtist().equals(artist)).collect(Collectors.toList());
    }

    @Override
    // This method is used to search the songs by name.
    public List<Song> searchByName(List<Song> songsList, String songName) {
        return songsList.stream().filter(songByName -> songByName.getSongName().equals(songName)).collect(Collectors.toList());
    }

    @Override
    // This method is used to get the song by id.
    public Song getSongById(int songId) {
        if (songId <= 0) {
            return null;
        } else {
            databaseService.connect();
            Connection connection = databaseService.getConnection();
            Song song = new Song();
            String getQuery = "SELECT * FROM `jukebox`.`song` WHERE `song_id`=?;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(getQuery)) {
                preparedStatement.setInt(1, songId);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    song.setSongId(resultSet.getInt("song_id"));
                    song.setSongName(resultSet.getString("song_name"));
                    song.setGenre(resultSet.getString("genre"));
                    song.setArtist(resultSet.getString("artist"));
                    song.setAlbum(resultSet.getString("album"));
                    song.setDuration(resultSet.getString("duration"));
                    song.setSongPath(resultSet.getString("song_path"));
                }
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
            return song;
        }
    }
}
