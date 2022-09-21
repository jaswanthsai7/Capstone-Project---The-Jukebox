/*
 * Author Name : Jaswanth Sai
 * Date : 9/21/2022
 * Created With: INTELLIJ IDEA COMMUNITY EDITION
 */
package com.niit.jukebox;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class SongRepositoryTest {
    SongRepositoryTest songRepositoryTest;

    @BeforeEach
    void setUp() {
        songRepositoryTest = new SongRepositoryTest();
    }

    @AfterEach
    void tearDown() {
        songRepositoryTest = null;
    }
}
