/*
 * Author Name : Jaswanth Sai
 * Date : 9/22/2022
 * Created With: INTELLIJ IDEA COMMUNITY EDITION
 */
package com.niit.jukebox.repository;

import com.niit.jukebox.model.Playlist;
import com.niit.jukebox.model.Song;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

class PlaylistRepositoryTest {
    PlaylistRepository playlistRepository;

    @BeforeEach
    void setUp() {
        playlistRepository = new PlaylistRepository();
    }

    @AfterEach
    void tearDown() {
        playlistRepository = null;
    }

    @Test
    void checkDisplayPlaylistByNameSuccess() {
        List<Playlist> playlists = playlistRepository.displayPlaylist("tony");
        List<Song> songList = List.of(new Song(2, "faded", "dance", "alan walker", "different world", "03:31", "src/main/resources/songs/faded.wav"));
        Playlist actualResult = new Playlist(2, "tony", songList);
        Assertions.assertEquals(playlists.toString().replaceAll("[\\[\\]]", ""), actualResult.toString().replaceAll("[\\[\\]]", ""));
    }

    @Test
    void checkDisplayPlaylistByNameFailure() {
        List<Playlist> playlists = playlistRepository.displayPlaylist(null);
        Assertions.assertEquals(Collections.emptyList(), playlists);
    }
}
