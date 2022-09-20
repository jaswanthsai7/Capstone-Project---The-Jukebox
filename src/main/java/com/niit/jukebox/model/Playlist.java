/*
 * Author Name : Jaswanth Sai
 * Date : 9/20/2022
 * Created With: INTELLIJ IDEA COMMUNITY EDITION
 */
package com.niit.jukebox.model;

public class Playlist {
    private String playListName;
    private Song songDetails;

    public Playlist() {
    }

    public Playlist(String playListName, Song songDetails) {
        this.playListName = playListName;
        this.songDetails = songDetails;
    }

    public String getPlayListName() {
        return playListName;
    }

    public void setPlayListName(String playListName) {
        this.playListName = playListName;
    }

    public Song getSongDetails() {
        return songDetails;
    }

    public void setSongDetails(Song songDetails) {
        this.songDetails = songDetails;
    }
}
