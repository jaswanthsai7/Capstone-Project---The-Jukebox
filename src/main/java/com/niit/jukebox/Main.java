package com.niit.jukebox;

import com.niit.jukebox.repository.PlaylistRepository;

public class Main {
    public static void main(String[] args) {
        PlaylistRepository playlistRepository = new PlaylistRepository();
        playlistRepository.displayPlaylist("playlist");
    }
}