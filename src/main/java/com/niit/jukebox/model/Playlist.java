/*
 * Author Name : Jaswanth Sai
 * Date : 9/20/2022
 * Created With: INTELLIJ IDEA COMMUNITY EDITION
 */
package com.niit.jukebox.model;

import java.util.List;
import java.util.Objects;

public class Playlist {

    // create fields
    private String playlistName;
    private List<Song> songDetails;

    // create constructor methods
    public Playlist() {
    }

    public Playlist(String playlistName, List<Song> songDetails) {
        this.playlistName = playlistName;
        this.songDetails = songDetails;
    }

    // create getter and setter methods
    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public List<Song> getSongDetails() {
        return songDetails;
    }

    public void setSongDetails(List<Song> songDetails) {
        this.songDetails = songDetails;
    }

    // create equals() and hashCode() method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Playlist)) return false;
        Playlist playlist = (Playlist) o;
        return Objects.equals(playlistName, playlist.playlistName) && Objects.equals(getSongDetails(), playlist.getSongDetails());
    }

    @Override
    public int hashCode() {
        return Objects.hash(playlistName, getSongDetails());
    }

    // create toString() method
    @Override
    public String toString() {
        return "Playlist{" + "playlistName='" + playlistName + '\'' + ", songDetails=" + songDetails + '}';
    }
}
