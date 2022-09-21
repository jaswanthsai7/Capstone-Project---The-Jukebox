/*
 * Author Name : Jaswanth Sai
 * Date : 9/20/2022
 * Created With: INTELLIJ IDEA COMMUNITY EDITION
 */
package com.niit.jukebox.repository;

import com.niit.jukebox.model.Playlist;
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
        databaseService.connect();
        Connection connection = databaseService.getConnection();
        // write the query
        String createQuery = "CREATE TABLE IF NOT EXISTS `jukebox`. ? (`playlist_id` INT AUTO_INCREMENT,`song_id` INT ,`song_name` VARCHAR(50),`genre` VARCHAR(45),`artist` VARCHAR(45),`album` VARCHAR(45),`duration` VARCHAR(20));";
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

    public void addSongToPlaylist(Playlist playlistName) {
        // to add songs to playlist
    }

    public void removePlaylist(Playlist playlistName) {
        // to remove the songs from playlist
    }

    public void displayPlaylist(Playlist playlistName) {
        // to display the playlist
    }
}
