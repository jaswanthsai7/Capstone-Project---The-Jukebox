/*
 * Author Name : Jaswanth Sai
 * Date : 9/20/2022
 * Created With: INTELLIJ IDEA COMMUNITY EDITION
 */
package com.niit.jukebox.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {

    // url for the database
    private static final String URL = "jdbc:mysql://localhost:3306/jukebox";

    // credentials of the user
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    // create a field for the connection object
    private Connection connection;

    // create a constructor to initialize connection
    public DatabaseService() {
        this.connection = null;
    }

    // create getter method for connection
    public Connection getConnection() {
        return connection;
    }

    // create a method for the connection

    /**
     * It connects to the database.
     *
     * @return A boolean value.
     */
    public boolean connect() {
        // (optional) load the jdbc driver to memory
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // create an object for DriverManager
            this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return true;
            // handle the exception
        } catch (ClassNotFoundException | SQLException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    /**
     * If the connection is not null, return "Connection : Active", otherwise return "Connection : InActive"
     *
     * @param connection The connection object that is being monitored.
     * @return A String
     */
    public String connectionStatus(Connection connection) {
        // check the connection
        if (connection != null) {
            return "Connection : Active";
        } else {
            return "Connection : InActive";
        }
    }
}
