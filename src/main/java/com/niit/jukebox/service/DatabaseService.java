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
    public boolean connect() {
        // (optional) load the jdbc driver to memory
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // create an object for DriverManager
            this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String connectionStatus = connectionStatus(connection);
            System.out.println(connectionStatus);
            return true;
        } catch (ClassNotFoundException | SQLException exception) {
            String connectionStatus = connectionStatus(connection);
            System.out.println(connectionStatus);
            exception.printStackTrace();
            return false;
        }
    }

    public String connectionStatus(Connection connection) {
        if (connection != null) {
            return "Connection : Active";
        } else {
            return "Connection : InActive";
        }
    }
}
