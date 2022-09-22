package com.niit.jukebox;

import com.niit.jukebox.implementation.JukeboxImpl;
import com.niit.jukebox.model.Playlist;
import com.niit.jukebox.repository.PlaylistRepository;
import com.niit.jukebox.repository.SongRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PlaylistRepository playlistRepository = new PlaylistRepository();
        JukeboxImpl jukebox = new JukeboxImpl();
        SongRepository songRepository = new SongRepository();
        List<Playlist> playlists = playlistRepository.displayPlaylist("tony");
        System.out.println(playlists);


    }
}