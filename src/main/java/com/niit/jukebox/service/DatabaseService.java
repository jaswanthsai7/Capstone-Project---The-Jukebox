/*
 * Author Name : Jaswanth Sai
 * Date : 9/20/2022
 * Created With: INTELLIJ IDEA COMMUNITY EDITION
 */
package com.niit.jukebox.service;

import java.sql.Connection;

public class DatabaseService {

    // url for the database
    private static final String URL = "jdbc:mysql://localhost:3306/jukebox";
    // credentials of the user
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    // create a field for the connection object
    private Connection connection;
}
