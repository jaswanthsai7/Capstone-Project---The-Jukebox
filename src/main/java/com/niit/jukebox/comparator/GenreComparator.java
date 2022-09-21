/*
 * Author Name : Jaswanth Sai
 * Date : 9/21/2022
 * Created With: INTELLIJ IDEA COMMUNITY EDITION
 */
package com.niit.jukebox.comparator;

import com.niit.jukebox.model.Song;

import java.util.Comparator;

@FunctionalInterface
public interface GenreComparator extends Comparator<Song> {

    @Override
    int compare(Song o1, Song o2);
}
