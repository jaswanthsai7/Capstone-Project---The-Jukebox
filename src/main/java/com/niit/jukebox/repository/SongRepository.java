/*
 * Author Name : Jaswanth Sai
 * Date : 9/20/2022
 * Created With: INTELLIJ IDEA COMMUNITY EDITION
 */
package com.niit.jukebox.repository;

import com.niit.jukebox.model.Song;

import java.util.ArrayList;
import java.util.List;

public class SongRepository {
    List<Song> songsList;

    public SongRepository() {
        songsList = new ArrayList<>();
    }
}
