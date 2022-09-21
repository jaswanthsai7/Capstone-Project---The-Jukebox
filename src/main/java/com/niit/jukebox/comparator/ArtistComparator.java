package com.niit.jukebox.comparator;

import com.niit.jukebox.model.Song;

import java.util.Comparator;

@FunctionalInterface
public interface ArtistComparator extends Comparator<Song> {

    @Override
    int compare(Song o1, Song o2);
}
