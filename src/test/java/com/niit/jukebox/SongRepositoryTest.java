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

public class SongRepositoryTest {
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
    public void checkSongByIdSuccess() {
        Song actualResult = songRepository.getSongById(2);
        Song song = new Song(2, "faded", "dance", "alan walker", "different world", "03:31", "src/main/resources/songs/faded.wav");
        Assertions.assertEquals(song, actualResult);
    }
}
