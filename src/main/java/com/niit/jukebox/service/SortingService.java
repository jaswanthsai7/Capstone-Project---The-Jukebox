/*
 * Author Name : Jaswanth Sai
 * Date : 9/22/2022
 * Created With: INTELLIJ IDEA COMMUNITY EDITION
 */
package com.niit.jukebox.service;

import com.niit.jukebox.model.Song;
import com.niit.jukebox.repository.SongRepository;

import java.util.List;

public class SortingService extends Service {
    SongRepository songRepository;

    public SortingService() {
        songRepository = new SongRepository();
    }

    @Override
    // Sorting the songs by name.
    public void sortByName() {
        // get the list of songs
        List<Song> allSongs = songRepository.displayAllSongs();
        // sort the songs based on name
        allSongs.sort((o1, o2) -> String.CASE_INSENSITIVE_ORDER.compare(o1.getSongName(), o2.getSongName()));
        System.out.println("=============================================================================================");
        System.out.println("SongId     SongName           Genre           Artist             Album              Duration");
        System.out.println("=============================================================================================");
        System.out.println(allSongs.toString().replaceAll("[\\[\\]]", "").replace(",", ""));
        System.out.println("=============================================================================================");
    }

    @Override
    // Sorting the songs by artist.
    public void sortByArtist() {
        // get the list of songs
        List<Song> allSongs = songRepository.displayAllSongs();
        // sort the songs based on artist
        allSongs.sort((o1, o2) -> String.CASE_INSENSITIVE_ORDER.compare(o1.getArtist(), o2.getArtist()));
        System.out.println("=============================================================================================");
        System.out.println("SongId     SongName           Genre           Artist             Album              Duration");
        System.out.println("=============================================================================================");
        System.out.println(allSongs.toString().replaceAll("[\\[\\]]", "").replace(",", ""));
        System.out.println("=============================================================================================");
    }

    @Override
    // Sorting the songs by genre.
    public void sortByGenre() {
        // get the list of songs
        List<Song> allSongs = songRepository.displayAllSongs();
        // sort the songs based on genre
        allSongs.sort((o1, o2) -> String.CASE_INSENSITIVE_ORDER.compare(o1.getGenre(), o2.getGenre()));
        System.out.println("=============================================================================================");
        System.out.println("SongId     SongName           Genre           Artist             Album              Duration");
        System.out.println("=============================================================================================");
        System.out.println(allSongs.toString().replaceAll("[\\[\\]]", "").replace(",", ""));
        System.out.println("=============================================================================================");
    }
}
