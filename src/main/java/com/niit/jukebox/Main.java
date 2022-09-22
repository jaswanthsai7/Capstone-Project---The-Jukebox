package com.niit.jukebox;

import com.niit.jukebox.exception.InvalidSongNumberException;
import com.niit.jukebox.implementation.JukeboxImpl;
import com.niit.jukebox.repository.PlaylistRepository;

public class Main {
    public static void main(String[] args) {
        PlaylistRepository playlistRepository = new PlaylistRepository();
        JukeboxImpl jukebox = new JukeboxImpl();
        try {
            playlistRepository.addSongToPlaylist(2, "7");
        } catch (InvalidSongNumberException e) {
            throw new RuntimeException(e);
        }

    }
}