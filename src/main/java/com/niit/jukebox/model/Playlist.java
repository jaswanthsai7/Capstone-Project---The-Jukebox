/*
 * Author Name : Jaswanth Sai
 * Date : 9/20/2022
 * Created With: INTELLIJ IDEA COMMUNITY EDITION
 */
package com.niit.jukebox.model;

import java.util.Objects;

public class Playlist {

    // create fields
    private int playlistId;
    private Song songDetails;

    // create constructor methods
    public Playlist() {
    }

    public Playlist(int playlistId, Song songDetails) {
        this.playlistId = playlistId;
        this.songDetails = songDetails;
    }

    // create getter and setter methods
    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
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
        return getPlaylistId() == playlist.getPlaylistId() && Objects.equals(getSongDetails(), playlist.getSongDetails());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlaylistId(), getSongDetails());
    }


    // create toString() method
    @Override
    public String toString() {
        return "Playlist{" + "playlistId=" + playlistId + ", songDetails=" + songDetails + '}';
    }
}
