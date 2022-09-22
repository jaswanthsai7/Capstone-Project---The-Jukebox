/*
 * Author Name : Jaswanth Sai
 * Date : 9/22/2022
 * Created With: INTELLIJ IDEA COMMUNITY EDITION
 */
package com.niit.jukebox;

import com.niit.jukebox.service.JukeboxService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JukeboxServiceTest {
    JukeboxService jukeboxService;

    @BeforeEach
    void setUp() {
        jukeboxService = new JukeboxService();
    }

    @AfterEach
    void tearDown() {
        jukeboxService = null;
    }

    @Test
    public void checkShuffle() {
    }
}
