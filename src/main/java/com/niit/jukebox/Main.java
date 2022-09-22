package com.niit.jukebox;

import com.niit.jukebox.implementation.JukeboxImpl;
import com.niit.jukebox.model.Song;
import com.niit.jukebox.repository.PlaylistRepository;
import com.niit.jukebox.repository.SongRepository;

public class Main {
    public static void main(String[] args) {
        PlaylistRepository playlistRepository = new PlaylistRepository();
        JukeboxImpl jukebox = new JukeboxImpl();
        SongRepository songRepository = new SongRepository();
        Song songById = songRepository.getSongById(1);
        System.out.println(songById);

    }
}