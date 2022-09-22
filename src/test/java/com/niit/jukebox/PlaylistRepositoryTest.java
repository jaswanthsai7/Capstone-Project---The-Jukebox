/*
 * Author Name : Jaswanth Sai
 * Date : 9/22/2022
 * Created With: INTELLIJ IDEA COMMUNITY EDITION
 */
package com.niit.jukebox;

import com.niit.jukebox.exception.InvalidSongNumberException;
import com.niit.jukebox.model.Playlist;
import com.niit.jukebox.model.Song;
import com.niit.jukebox.repository.PlaylistRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PlaylistRepositoryTest {
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
    public void CheckAddSongsToPlaylistSuccess() throws InvalidSongNumberException {
        List<Song> songs = new ArrayList<>();
        songs.add(new Song(2, "faded", "dance", "alan walker", "different world", "03:31", "src/main/resources/songs/faded.wav"));
        Playlist expectedResult = new Playlist(2, "test", songs);
        List<Playlist> playlists = playlistRepository.displayPlaylist("test");
        Assertions.assertEquals(expectedResult, playlists);

    }
}
