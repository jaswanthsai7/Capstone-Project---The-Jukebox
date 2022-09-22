/*
 * Author Name : Jaswanth Sai
 * Date : 9/20/2022
 * Created With: INTELLIJ IDEA COMMUNITY EDITION
 */
package com.niit.jukebox.service;

import com.niit.jukebox.model.Song;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class JukeboxService {
    /**
     * It takes a song path as a parameter, creates a File object, creates an AudioInputStream object, creates a Clip
     * object, opens the audio input stream, starts the sound file, pauses the current thread for the time the song is
     * being played, and catches any exceptions
     *
     * @param songPath the path to the song file
     */
    public void play(String songPath) {
        // create an object of FIle class
        File songFile = new File(songPath);
        // an object of the AudioInputStream class
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(songFile);
            // get a clip object from the AudioSystem
            Clip clip = AudioSystem.getClip();
            // use the clip object to open the audio input stream
            clip.open(audioInputStream);
            // start the sound file
            clip.start();
            // pause the current thread for the time the song is being played
            long songDurationInMilliseconds = clip.getMicrosecondLength() / 1000L;
            Thread.sleep(songDurationInMilliseconds);
        } catch (UnsupportedAudioFileException | IOException | InterruptedException |
                 LineUnavailableException exception) {
            Thread.currentThread().interrupt();
            exception.printStackTrace();
        }
    }

    /**
     * If the songsList is null, return an empty list, otherwise shuffle the songsList and return it
     *
     * @param songsList The list of songs to be shuffled.
     * @return A list of songs that have been shuffled.
     */
    public List<Song> shuffle(List<Song> songsList) {
        if (songsList == null) {
            return Collections.emptyList();
        } else {
            // to shuffle the songs
            Collections.shuffle(songsList);
            return songsList;
        }
    }
}


