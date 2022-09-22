/*
 * Author Name : Jaswanth Sai
 * Date : 9/21/2022
 * Created With: INTELLIJ IDEA COMMUNITY EDITION
 */
package com.niit.jukebox;

import com.niit.jukebox.model.Song;
import com.niit.jukebox.repository.SongRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SongRepositoryTest {
    SongRepository songRepository;

    @BeforeEach
    void setUp() {
        songRepository = new SongRepository();
    }

    @AfterEach
    void tearDown() {
        songRepository = null;
    }

    @Test
    void checkSongByIdSuccess() {
        Song actualResult = songRepository.getSongById(2);
        Song song = new Song(2, "faded", "dance", "alan walker", "different world", "03:31", "src/main/resources/songs/faded.wav");
        Assertions.assertEquals(song, actualResult);
    }

    @Test
    void checkSongByIdFailure() {
        Song actualResult = songRepository.getSongById(0);
        Assertions.assertNull(actualResult);
    }

    @Test
    void checkSongBYIdSuccess2() {
        Song actualResult = songRepository.getSongById(4);
        Song song = new Song(4, "happier", "pop", "marshmellow", "fortnite set", "03:38", "src/main/resources/songs/happier.wav");
        Assertions.assertEquals(song, actualResult);
    }

    @Test
    void checkSongByIdFailure2() {
        Song actualResult = songRepository.getSongById(-6);
        Assertions.assertNull(actualResult);
    }
}
