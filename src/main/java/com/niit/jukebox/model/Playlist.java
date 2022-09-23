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
    private int playlistId;
    private String playlistName;
    private List<Song> songDetails;

    // create constructor methods
    public Playlist() {
    }

    public Playlist(int playlistId, String playlistName, List<Song> songDetails) {
        this.playlistId = playlistId;
        this.playlistName = playlistName;
        this.songDetails = songDetails;
    }

    public Playlist(int playlistId, String playlistName) {
        this.playlistId = playlistId;
        this.playlistName = playlistName;
    }

    // create getter and setter methods
    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

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
        return getPlaylistId() == playlist.getPlaylistId() && Objects.equals(getPlaylistName(), playlist.getPlaylistName()) && Objects.equals(getSongDetails(), playlist.getSongDetails());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlaylistId(), getPlaylistName(), getSongDetails());
    }

    // create toString() method
    @Override
    public String toString() {
        return String.format("|%1$-5s|           | %2$-5s|   %3$-5s", playlistId, playlistName,
                "\nSongId     SongName           Genre           Artist             Album             Duration\n"
                        + "===============================================================================================\n" + songDetails);
    }
}
