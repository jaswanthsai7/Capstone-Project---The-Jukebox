/*
 * Author Name : Jaswanth Sai
 * Date : 9/20/2022
 * Created With: INTELLIJ IDEA COMMUNITY EDITION
 */
package com.niit.jukebox.repository;

import com.niit.jukebox.model.Playlist;
import com.niit.jukebox.model.Song;
import com.niit.jukebox.service.DatabaseService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PlaylistRepository {
    DatabaseService databaseService;

    public PlaylistRepository() {
        databaseService = new DatabaseService();
    }

    public void createPlaylist(String playlistName) {
        // get the database connection
        databaseService.connect();
        Connection connection = databaseService.getConnection();
        // write the query
        String createQuery = "CREATE TABLE IF NOT EXISTS `jukebox`. ? (`playlist_id` INT PRIMARY KEY AUTO_INCREMENT,`song_id` INT ,`song_name` VARCHAR(50),`genre` VARCHAR(45),`artist` VARCHAR(45),`album` VARCHAR(45),`duration` VARCHAR(20));";
        // create an object of prepared statement
        try (PreparedStatement preparedStatement = connection.prepareStatement(createQuery)) {
            preparedStatement.setString(1, playlistName);
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
        Connection connection = databaseService.getConnection();
        // write the query
        String addQuery = "INSERT INTO `jukebox`.? (`song_id`, `song_name`, `genre`, `artist`, `album`, `duration`) VALUES (?,?,?,?,?,?);";
        // create an object of prepared statement
        try (PreparedStatement preparedStatement = connection.prepareStatement(addQuery)) {
            preparedStatement.setString(1, playlistName);
            preparedStatement.setInt(2, song.getSongId());
            preparedStatement.setString(3, song.getSongName());
            preparedStatement.setString(4, song.getGenre());
            preparedStatement.setString(5, song.getArtist());
            preparedStatement.setString(6, song.getAlbum());
            preparedStatement.setString(7, song.getDuration());
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

    public void removePlaylist(Playlist playlistName) {
        // get the database connection
        databaseService.connect();
        Connection connection = databaseService.getConnection();
        // write the query
        String removeQuery = "";
    }

    public void displayPlaylist(Playlist playlistName) {
        // to display the playlist
    }
}
