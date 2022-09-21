/*
 * Author Name : Jaswanth Sai
 * Date : 9/20/2022
 * Created With: INTELLIJ IDEA COMMUNITY EDITION
 */
package com.niit.jukebox.service;

import javax.sound.sampled.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JukeboxService {
    public void readFileToPlay(int playSongId) {

        try (FileReader fileReader = new FileReader("src/main/resources/song_path.csv"); BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                int songId = Integer.parseInt(data[0].trim());
                String path = data[1].trim();
                if (songId == (playSongId)) {
                    // create an object of FIle class
                    File songFile = new File(path);
                    // an object of the AudioInputStream class
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
                }

            }
        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("song thread was interrupted, please try agin");
        } catch (UnsupportedAudioFileException | LineUnavailableException exception) {
            System.err.println(exception.getMessage());
            exception.printStackTrace();
        }


    }

    public void stop() {
        // stop the song
    }

    public void shuffle() {
        // to shuffle the songs
    }

}

