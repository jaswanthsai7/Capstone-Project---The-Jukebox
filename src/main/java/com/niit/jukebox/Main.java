package com.niit.jukebox;

import com.niit.jukebox.model.Playlist;
import com.niit.jukebox.repository.PlaylistRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PlaylistRepository playlistRepository = new PlaylistRepository();
        List<Playlist> playlists = playlistRepository.displayAllPlaylists();
        System.out.println(playlists);
    }
}