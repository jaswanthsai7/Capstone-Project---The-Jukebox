/*
 * Author Name : Jaswanth Sai
 * Date : 9/21/2022
 * Created With: INTELLIJ IDEA COMMUNITY EDITION
 */
package com.niit.jukebox;

import com.niit.jukebox.service.DatabaseService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

class DatabaseServiceTest {
    DatabaseService databaseService;

    @BeforeEach
    void setUp() {
        databaseService = new DatabaseService();
    }

    @AfterEach
    void tearDown() {
        databaseService = null;
    }

    @Test
    void checkIfConnectionActiveSuccess() {
        boolean connect = databaseService.connect();
        boolean expected = true;
        Assertions.assertEquals(expected, connect, "Please check the connection");
    }

    @Test
    void checkConnectionStatusSuccess() {
        String connectionStatus = databaseService.connectionStatus(null);
        String expectedResult = "Connection : InActive";
        Assertions.assertEquals(expectedResult, connectionStatus, "Please check the connection");
    }

    @Test
    void checkConnectionStatusFailure() {
        databaseService.connect();
        Connection connection = databaseService.getConnection();
        String actualResult = databaseService.connectionStatus(connection);
        String expectedResult = "Connection : Active";
        Assertions.assertEquals(expectedResult, actualResult, "Please check the connection");
    }

    @Test
    void checkIfConnectionActiveFailure() {
        boolean connect = databaseService.connect();
        boolean expected = true;
        Assertions.assertEquals(expected, connect, "Please check the connection");
    }
}
