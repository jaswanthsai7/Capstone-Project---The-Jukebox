/*
 * Author Name : Jaswanth Sai
 * Date : 9/20/2022
 * Created With: INTELLIJ IDEA COMMUNITY EDITION
 */
package com.niit.jukebox.model;

import java.util.Objects;

public class Song {

    // create fields
    private int songId;
    private String songName;
    private String genre;
    private String artist;
    private String album;
    private String duration;
    private String songPath;

    // create constructor methods
    public Song() {
    }

    public Song(int songId, String songName, String genre, String artist, String album, String duration, String songPath) {
        this.songId = songId;
        this.songName = songName;
        this.genre = genre;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
        this.songPath = songPath;
    }

    // create getter and setter methods
    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSongPath() {
        return songPath;
    }

    public void setSongPath(String songPath) {
        this.songPath = songPath;
    }

    // create equals() and hashCode() method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Song)) return false;
        Song song = (Song) o;
        return getSongId() == song.getSongId() && Objects.equals(getSongName(), song.getSongName()) && Objects.equals(getGenre(), song.getGenre()) && Objects.equals(getArtist(), song.getArtist()) && Objects.equals(getAlbum(), song.getAlbum()) && Objects.equals(getDuration(), song.getDuration()) && Objects.equals(getSongPath(), song.getSongPath());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSongId(), getSongName(), getGenre(), getArtist(), getAlbum(), getDuration(), getSongPath());
    }

    // create toString() method
    @Override
    public String toString() {
        return String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s", songId, songName, genre, artist, album, duration, songPath + "\n");
    }
}
