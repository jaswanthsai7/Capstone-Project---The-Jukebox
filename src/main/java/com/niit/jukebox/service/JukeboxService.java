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

    /**
     * This function will get all the songs from the database and print them out
     */
    public void getAllSongs() {
        List<Song> songs = songRepository.displayAllSongs();
        System.out.println("====================================================================================");
        System.out.println("SongId     SongName     Genre         Artist             Album          Duration");
        System.out.println("=====================================================================================");
        System.out.println(songs.toString().replaceAll("[\\[\\]]", "").replace(",", ""));
        System.out.println("=======================================================================================");
    }

    /**
     * This function takes the song id as input and plays the song
     *
     * @param playChoice The song id of the song to be played.
     */
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

    /**
     * It displays all the playlists or a specific playlist based on the user's choice
     *
     * @param displayChoice 1 for displaying all playlists, 2 for displaying a specific playlist
     */
    public void displayPlaylist(int displayChoice) {
        if (displayChoice == 1) {
            playlistRepository.displayAllPlaylists();
        } else if (displayChoice == 2) {
            System.out.println("Enter name of the Playlist : ");
            String playlistName = input.nextLine();
            List<Playlist> playlist = playlistRepository.displayPlaylist(playlistName);
            System.out.format("%5s %20s ", "PlaylistId", "PlaylistName\n");
            System.out.println("=================================================================`");
            System.out.println(playlist.toString().replaceAll("[\\[\\]]", ",").replace(",", ""));
            System.out.println("==================================================================");
        }
    }

    /**
     * "If the user wants to sort by name, sort by name. If the user wants to sort by artist, sort by artist. If the user
     * wants to sort by genre, sort by genre."
     * <p>
     * This is a very simple example, but it's easy to see how this can get out of hand. Imagine if you had to add a new
     * sorting option. You'd have to add a new case to the switch statement, and then add a new function call to the
     * sorting service
     *
     * @param sortingChoice 1 = sort by name, 2 = sort by artist, 3 = sort by genre
     */
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

    /**
     * This function displays the menu of the application
     */
    public void displayDetails() {
        System.out.println("===================================================");
        System.out.println("                  Welcome to Jukebox               ");
        System.out.println("===================================================\n");
        System.out.println("1.Display All Songs \n2.Search songs \n3.Create a playlist \n4.Delete Playlist \n5.Add songs to Playlist \n6.Display Playlist \n7.shuffle the songs \n8.Sort songs \n9.exit");
    }

    public void shuffleDisplay() {
        List<Song> songs = songRepository.displayAllSongs();
        List<Song> shuffledSongs = shuffle(songs);
        System.out.println("====================================================================================");
        System.out.println("SongId     SongName     Genre         Artist             Album          Duration");
        System.out.println("=====================================================================================");
        System.out.println(shuffledSongs.toString().replaceAll("[\\[\\]]", "").replace(",", ""));
        System.out.println("=====================================================================================");
    }
}


