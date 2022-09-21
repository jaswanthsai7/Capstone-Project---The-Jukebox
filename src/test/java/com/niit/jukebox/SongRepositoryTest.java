/*
 * Author Name : Jaswanth Sai
 * Date : 9/21/2022
 * Created With: INTELLIJ IDEA COMMUNITY EDITION
 */
package com.niit.jukebox;

import com.niit.jukebox.repository.SongRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

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
}
