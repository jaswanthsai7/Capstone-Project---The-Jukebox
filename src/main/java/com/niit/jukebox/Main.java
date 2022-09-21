package com.niit.jukebox;

import com.niit.jukebox.model.Song;
import com.niit.jukebox.repository.PlaylistRepository;
import com.niit.jukebox.repository.SongRepository;

public class Main {
    public static void main(String[] args) {
        SongRepository songRepository = new SongRepository();
        PlaylistRepository playlistRepository = new PlaylistRepository();
        Song songById = songRepository.getSongById(2);
        playlistRepository.displayPlaylist("Jaswanth");
    }
}