/*
 * Author Name : Jaswanth Sai
 * Date : 9/20/2022
 * Created With: INTELLIJ IDEA COMMUNITY EDITION
 */
package com.niit.jukebox.model;

public class Song {
    private int songId;
    private String songName;
    private String genre;
    private String artist;
    private String album;
    private String duration;

    public Song() {
    }

    public Song(int songId, String songName, String genre, String artist, String album, String duration) {
        this.songId = songId;
        this.songName = songName;
        this.genre = genre;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
    }
}
