/*
 * Author Name : Jaswanth Sai
 * Date : 9/21/2022
 * Created With: INTELLIJ IDEA COMMUNITY EDITION
 */
package com.niit.jukebox;

import com.niit.jukebox.service.DatabaseService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class DatabaseServiceTest {
    DatabaseService databaseService;

    @BeforeEach
    void setUp() {
        databaseService = new DatabaseService();
    }

    @AfterEach
    void tearDown() {
        databaseService = null;
    }
}
