/*
 * Author Name : Jaswanth Sai
 * Date : 9/20/2022
 * Created With: INTELLIJ IDEA COMMUNITY EDITION
 */
package com.niit.jukebox.service;

import com.niit.jukebox.model.Playlist;
import com.niit.jukebox.model.Song;
import com.niit.jukebox.repository.PlaylistRepository;
import com.niit.jukebox.repository.SongRepository;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class JukeboxService {
    DatabaseService databaseService;
    SongRepository songRepository;
    PlaylistRepository playlistRepository;
    SortingService sortingService;
    Scanner input = new Scanner(System.in);

    public JukeboxService() {
        databaseService = new DatabaseService();
        songRepository = new SongRepository();
        playlistRepository = new PlaylistRepository();
        sortingService = new SortingService();
    }

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
            System.out.println("Enter 1 to stop and 2 to exit");
            int enteredNumber = input.nextInt();
            if (enteredNumber == 0) {
                clip.stop();
            } else {
                System.out.println("Song Stopped");
                clip.stop();
                return;
            }
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

    public void getAllSongs() {
        List<Song> songs = songRepository.displayAllSongs();
        System.out.println(songs.toString().replaceAll("[\\[\\]]", ""));

    }

    public void playSong(int playChoice) {
        List<Song> songs = songRepository.displayAllSongs();
        for (Song songAll : songs) {
            if (songAll.getSongId() == playChoice) {
                System.out.println("Current Playing song " + songAll.getSongName() + " Song Duration :" + songAll.getDuration());
                String songPath = songAll.getSongPath();
                play(songPath);
            }
        }
    }

    public void displayPlaylist(int displayChoice) {
        if (displayChoice == 1) {
            playlistRepository.displayAllPlaylists();
        } else if (displayChoice == 2) {
            System.out.println("Enter name of the Playlist : ");
            String playlistName = input.nextLine();
            List<Playlist> playlists = playlistRepository.displayPlaylist(playlistName);
            System.out.println(playlists.toString().replaceAll("[\\[\\]]", ""));
        }
    }

    public void allSort(int sortingChoice) {
        switch (sortingChoice) {
            case 1:
                sortingService.sortByName();
                break;
            case 2:
                sortingService.sortByArtist();
                break;
            case 3:
                sortingService.sortByGenre();
                break;
            default:
                break;
        }
    }

    public void displayDetails() {
        System.out.println("1.Display All Songs \n2.Search songs \n3.Create a playlist \n4.Delete Playlist \n5.Add songs to Playlist \n6.Display Playlist \n7.shuffle the songs \n8.Sort songs \n9.exit");
    }

    public void displayPlaylistByName(int playlistChoice) {
        if (playlistChoice == 1) {
            System.out.println("Enter Playlist Name :");
            input.nextLine();
            String name = input.nextLine();
            List<Playlist> playlists = playlistRepository.displayPlaylist(name);
            System.out.println(playlists.toString().replaceAll("[\\[\\]]", ""));
            System.out.println("Enter any number to exit");
        }
    }
}


