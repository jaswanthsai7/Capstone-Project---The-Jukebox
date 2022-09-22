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

    public List<Song> shuffle(List<Song> songsList) {
        if (songsList == null) {
            return null;
        } else {
            // to shuffle the songs
            Collections.shuffle(songsList);
            return songsList;
        }
    }
}


