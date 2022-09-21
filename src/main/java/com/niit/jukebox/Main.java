package com.niit.jukebox;

import com.niit.jukebox.implementation.JukeboxImpl;
import com.niit.jukebox.model.Song;
import com.niit.jukebox.repository.SongRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        JukeboxImpl jukebox = new JukeboxImpl();
        SongRepository songRepository = new SongRepository();
        List<Song> songs = songRepository.displayAllSongs();
        jukebox.jukeboxImpl();

    }
}