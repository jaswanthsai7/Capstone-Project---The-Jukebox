/*
 * Author Name : Jaswanth Sai
 * Date : 9/20/2022
 * Created With: INTELLIJ IDEA COMMUNITY EDITION
 */
package com.niit.jukebox.repository;

import com.niit.jukebox.exception.InvalidSongNumberException;
import com.niit.jukebox.model.Playlist;
import com.niit.jukebox.model.Song;
import com.niit.jukebox.service.DatabaseService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistRepository {
    DatabaseService databaseService;
    Connection connection;
    SongRepository songRepository = new SongRepository();

    public PlaylistRepository() {
        databaseService = new DatabaseService();
        connection = databaseService.getConnection();
    }

    public void createPlaylist(String playlistName, String playlistSongs) {
        // get the database connection
        databaseService.connect();
        connection = databaseService.getConnection();
        // write the query
        String createQuery = "INSERT INTO `jukebox`.`playlist` (`playlist_id`,`playlist_name`, `song_id`) VALUES (0,?,?);";
        // create an object of prepared statement
        try (PreparedStatement preparedStatement = connection.prepareStatement(createQuery)) {
            preparedStatement.setString(1, playlistName);
            preparedStatement.setString(2, playlistSongs);
            // execute the query
            boolean execute = preparedStatement.execute();
            // check if the query is successful or not
            if (execute) {
                System.out.println("Playlist not created");
            } else {
                System.out.println("Playlist created");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }

    public void addSongToPlaylist(int playlistId, String playlistSongs) throws InvalidSongNumberException {
        String[] checkNumber = playlistSongs.split(",");
        for (int i = 0; i < checkNumber.length; i++) {
            if (Integer.parseInt(checkNumber[i]) < 20) {
                try {
                    // get the database connection
                    databaseService.connect();
                    connection = databaseService.getConnection();
                    // write the query
                    String getQuery = "SELECT `song_id` FROM `jukebox`.`playlist` WHERE `playlist_id`='" + playlistId + "';";
                    String addQuery = "UPDATE `jukebox`.`playlist` SET `song_id` = ? WHERE (`playlist_id` = ?);";
                    // create an object of prepared statement
                    try (Statement statement = connection.createStatement(); PreparedStatement preparedStatement1 = connection.prepareStatement(addQuery)) {
                        ResultSet resultSet = statement.executeQuery(getQuery);
                        while (resultSet.next()) {
                            playlistSongs += "," + resultSet.getString("song_id");
                        }
                        preparedStatement1.setInt(2, playlistId);
                        preparedStatement1.setString(1, playlistSongs);
                        // execute the query
                        int executeUpdate = preparedStatement1.executeUpdate();
                        if (executeUpdate > 0) {
                            System.out.println("Successfully added the song to playlist");
                        } else {
                            System.out.println("unable to add the song to playlist");
                        }
                    }

                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            } else {
                throw new InvalidSongNumberException("Enter a valid number");
            }
        }
    }

    public void removePlaylist(String playlistName) {
        // get the database connection
        databaseService.connect();
        connection = databaseService.getConnection();
        // write the query
        String removeQuery = "Delete FROM `jukebox`.`playlist` WHERE `playlist_name`=?;";
        // create an object of prepared statement
        try (PreparedStatement preparedStatement = connection.prepareStatement(removeQuery)) {
            preparedStatement.setString(1, playlistName);
            // execute the query
            int executeRemove = preparedStatement.executeUpdate();
            if (executeRemove > 0) {
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
        String displayQuery = "SELECT * FROM `jukebox`.`playlist` WHERE `playlist_name`=?";
        // create an object of prepared statement
        try (PreparedStatement preparedStatement = connection.prepareStatement(displayQuery)) {
            preparedStatement.setString(1, playlistName);
            ResultSet resultSet = preparedStatement.executeQuery();
            // use the while loop to iterate over result set
            Playlist playlist = new Playlist();
            while (resultSet.next()) {
                playlist.setPlaylistId(resultSet.getInt("playlist_id"));
                playlist.setPlaylistName(resultSet.getString("playlist_Name"));
                String songIds = resultSet.getString("song_id");
                //String songs = songIds.trim().replace("\\[\\]", "");
                String[] songs = songIds.split(",");
                for (int i = 0; i < songs.length - 1; i++) {
                    //String[] split = songs.split(",");
                    Song songById = songRepository.getSongById(Integer.parseInt(songs[i].trim()));
                    songsList.add(songById);
                    playlist.setSongDetails(songsList);
                }
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
