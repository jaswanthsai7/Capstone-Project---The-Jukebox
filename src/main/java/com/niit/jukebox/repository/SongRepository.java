/*
 * Author Name : Jaswanth Sai
 * Date : 9/20/2022
 * Created With: INTELLIJ IDEA COMMUNITY EDITION
 */
package com.niit.jukebox.repository;

import com.niit.jukebox.model.Song;
import com.niit.jukebox.service.DatabaseService;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class SongRepository {
    List<Song> songsList;

    public SongRepository() {
        songsList = new ArrayList<>();
    }

    DatabaseService databaseService = new DatabaseService();

    public List<Song> displayAllSongs() {
        databaseService.connect();
        Connection connection = databaseService.getConnection();
        // write the query
        String displayQuery = "";
        return songsList;
    }
}
