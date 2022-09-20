/*
 * Author Name : Jaswanth Sai
 * Date : 9/20/2022
 * Created With: INTELLIJ IDEA COMMUNITY EDITION
 */
package com.niit.jukebox.model;

import java.util.Objects;

public class Playlist {

    // create fields
    private String playListName;
    private Song songDetails;

    // create constructor methods
    public Playlist() {
    }

    public Playlist(String playListName, Song songDetails) {
        this.playListName = playListName;
        this.songDetails = songDetails;
    }

    // create getter and setter methods
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

    // create equals() and hashCode() method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Playlist)) return false;
        Playlist playlist = (Playlist) o;
        return Objects.equals(getPlayListName(), playlist.getPlayListName()) && Objects.equals(getSongDetails(), playlist.getSongDetails());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlayListName(), getSongDetails());
    }

    // create toString() method
    @Override
    public String toString() {
        return "Playlist{" + "playListName='" + playListName + '\'' + ", songDetails=" + songDetails + '}';
    }
}
