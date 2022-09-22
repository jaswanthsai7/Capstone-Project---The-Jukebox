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
    public void sortByName() {
        List<Song> allSongs = songRepository.displayAllSongs();
        allSongs.sort((o1, o2) -> String.CASE_INSENSITIVE_ORDER.compare(o1.getSongName(), o2.getSongName()));
        System.out.println(allSongs);

    }

    @Override
    public void sortByArtist() {
        List<Song> allSongs = songRepository.displayAllSongs();
        allSongs.sort((o1, o2) -> String.CASE_INSENSITIVE_ORDER.compare(o1.getArtist(), o2.getArtist()));
        System.out.println(allSongs);

    }

    @Override
    public void sortByGenre() {
        List<Song> allSongs = songRepository.displayAllSongs();
        allSongs.sort((o1, o2) -> String.CASE_INSENSITIVE_ORDER.compare(o1.getGenre(), o2.getGenre()));
        System.out.println(allSongs);
    }
}
