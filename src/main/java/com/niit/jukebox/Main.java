package com.niit.jukebox;

import com.niit.jukebox.model.Playlist;
import com.niit.jukebox.model.Song;
import com.niit.jukebox.repository.PlaylistRepository;
import com.niit.jukebox.repository.SongRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SongRepository songRepository = new SongRepository();
        List<Song> songs = songRepository.displayAllSongs();
        Song songById = songRepository.getSongById(2);
        List<Song> alan_walker = songRepository.searchByArtist(songs, "alan walker");
        List<Song> dance = songRepository.searchByGenre(songs, "dance");
        PlaylistRepository playlistRepository = new PlaylistRepository();
        List<Playlist> playlists = playlistRepository.displayPlaylist("test");
        System.out.println(playlists);
    }
}