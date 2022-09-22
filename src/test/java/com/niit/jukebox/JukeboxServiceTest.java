/*
 * Author Name : Jaswanth Sai
 * Date : 9/22/2022
 * Created With: INTELLIJ IDEA COMMUNITY EDITION
 */
package com.niit.jukebox;

import com.niit.jukebox.model.Song;
import com.niit.jukebox.repository.SongRepository;
import com.niit.jukebox.service.JukeboxService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class JukeboxServiceTest {
    JukeboxService jukeboxService;
    SongRepository songRepository;

    @BeforeEach
    void setUp() {
        jukeboxService = new JukeboxService();
        songRepository = new SongRepository();
    }

    @AfterEach
    void tearDown() {
        jukeboxService = null;
    }

    @Test
    void checkShuffleSuccess() {
        List<Song> songs = songRepository.displayAllSongs();
        List<Song> shuffle = jukeboxService.shuffle(songs);
        Assertions.assertNotEquals(null, shuffle, "please check the shuffle method");
    }

    @Test
    void checkShuffleFailure() {
        List<Song> shuffleList = jukeboxService.shuffle(null);
        Assertions.assertNull(shuffleList);
    }
}
