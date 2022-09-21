/*
 * Author Name : Jaswanth Sai
 * Date : 9/20/2022
 * Created With: INTELLIJ IDEA COMMUNITY EDITION
 */
package com.niit.jukebox.repository;

import com.niit.jukebox.model.Playlist;
import com.niit.jukebox.model.Song;
import com.niit.jukebox.service.DatabaseService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistRepository {
    DatabaseService databaseService;
    Connection connection;

    public PlaylistRepository() {
        databaseService = new DatabaseService();
        connection = databaseService.getConnection();
    }

    public void createPlaylist(String playlistName) {
        // get the database connection
        databaseService.connect();
        connection = databaseService.getConnection();
        // write the query
        String createQuery = "CREATE TABLE IF NOT EXISTS `jukebox`. ? (? INT PRIMARY KEY ,`song_id` INT ,`song_name` VARCHAR(50),`genre` VARCHAR(45),`artist` VARCHAR(45),`album` VARCHAR(45),`duration` VARCHAR(20));";
        // create an object of prepared statement
        try (PreparedStatement preparedStatement = connection.prepareStatement(createQuery)) {
            preparedStatement.setString(1, playlistName);
            preparedStatement.setString(2, playlistName);
            // execute the query
            boolean execute = preparedStatement.execute();
            // check if the query is successful or not
            if (execute) {
                System.out.println("Playlist created");
            } else {
                System.out.println("Playlist not created");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }

    public void addSongToPlaylist(String playlistName, Song song) {
        // get the database connection
        databaseService.connect();
        connection = databaseService.getConnection();
        // write the query
        String addQuery = "INSERT INTO `jukebox`.? (?,`song_id`, `song_name`, `genre`, `artist`, `album`, `duration`) VALUES (?,?,?,?,?,?);";
        // create an object of prepared statement
        try (PreparedStatement preparedStatement = connection.prepareStatement(addQuery)) {
            preparedStatement.setString(1, playlistName);
            preparedStatement.setString(2, playlistName);
            preparedStatement.setInt(3, song.getSongId());
            preparedStatement.setString(4, song.getSongName());
            preparedStatement.setString(5, song.getGenre());
            preparedStatement.setString(6, song.getArtist());
            preparedStatement.setString(7, song.getAlbum());
            preparedStatement.setString(8, song.getDuration());
            // execute the query
            int executeUpdate = preparedStatement.executeUpdate();
            if (executeUpdate > 0) {
                System.out.println("Successfully added the song to playlist");
            } else {
                System.out.println("unable to add the song to playlist");
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void removePlaylist(String playlistName) {
        // get the database connection
        databaseService.connect();
        connection = databaseService.getConnection();
        // write the query
        String removeQuery = "DROP TABLE IF EXISTS `jukebox`. ?;";
        // create an object of prepared statement
        try (PreparedStatement preparedStatement = connection.prepareStatement(removeQuery)) {
            preparedStatement.setString(1, playlistName);
            // execute the query
            boolean executeRemove = preparedStatement.execute();
            if (executeRemove) {
                System.out.println("Successfully deleted the playlist");
            } else {
                System.out.println(" unable to delete the playlist, please check the playlist name");
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void displayPlaylist(String playlistName) {
        // create a list object
        List<Song> songsList = new ArrayList<>();
        List<Playlist> songsInPlaylist = new ArrayList<>();
        // get the database connection
        databaseService.connect();
        connection = databaseService.getConnection();
        // write the query
        String displayQuery = "SELECT * FROM `jukebox`." + playlistName + ";";
        // create an object of prepared statement
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(displayQuery);
            // create a song object
            Song song = new Song();
            // use the while loop to iterate over result set
            Playlist playlist = new Playlist();
            while (resultSet.next()) {
                // get all the values of the result set and set to song
                song.setSongId(resultSet.getInt("song_id"));
                song.setSongName(resultSet.getString("song_name"));
                song.setGenre(resultSet.getString("genre"));
                song.setArtist(resultSet.getString("artist"));
                song.setAlbum(resultSet.getString("album"));
                song.setDuration(resultSet.getString("duration"));
                songsList.add(song);
                // set all to the playlist
                playlist.setPlaylistName(resultSet.getString("playlist_Name"));
                playlist.setSongDetails(songsList);
                songsInPlaylist.add(playlist);
            }
            // loop to print all the songs
            for (Playlist playlistSongs : songsInPlaylist) {
                System.out.println(playlistSongs);
            }
        } catch (SQLException exception) {
            System.out.println("unable to get the playlist");
            exception.printStackTrace();
        }
    }
}
