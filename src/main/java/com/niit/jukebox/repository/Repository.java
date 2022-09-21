package com.niit.jukebox.repository;

import com.niit.jukebox.model.Song;

import java.util.List;

public interface Repository {
    List<Song> displayAllSongs();

    List<Song> searchByGenre(List<Song> songsList, String genreName);

    List<Song> searchByArtist(List<Song> songsList, String artist);

    Song getSongById(int songId);
}
