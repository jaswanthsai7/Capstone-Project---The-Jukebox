/*
 * Author Name : Jaswanth Sai
 * Date : 9/20/2022
 * Created With: INTELLIJ IDEA COMMUNITY EDITION
 */
package com.niit.jukebox.service;

import com.niit.jukebox.exception.InvalidSongNumberException;
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
            System.out.println("\u001B[32m Enter 0 to pause or Enter 21 to stop and exit \u001B[0m");
            int enteredNumber = input.nextInt();
            // play and pause
            if (enteredNumber == 0) {
                clip.stop();
                System.out.println("\u001B[32m Enter 1 to play or Enter 21 to stop and exit \u001B[0m");
                int choice = input.nextInt();
                do {
                    if (choice == 1) {
                        // start the sound file
                        clip.start();
                        System.out.println("\u001B[32m Enter 0 to pause or Enter 21 to stop and exit \u001B[0m");
                        choice = input.nextInt();
                    } else if (choice == 0) {
                        // stop the sound
                        clip.stop();
                        System.out.println("\u001B[32m Enter 1 to play or Enter 21 to stop and exit \u001B[0m");
                        choice = input.nextInt();
                    } else if (choice == 21) {
                        clip.stop();
                        System.err.println("Song Stopped");
                        return;
                    }
                } while (true);
            } else if (enteredNumber == 21) {
                System.err.println("Song Stopped");
                clip.stop();
                return;
            }
            // pause the current thread by play time
            long songDurationInMilliseconds = clip.getMicrosecondLength() / 1000L;
            Thread.sleep(songDurationInMilliseconds);
            // handle the exception
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
            // return empty list
            return Collections.emptyList();
        } else {
            // to shuffle the songs
            Collections.shuffle(songsList);
            // return the shuffled list
            return songsList;
        }
    }

    /**
     * This function will get all the songs from the database and print them out
     */
    public void getAllSongs() {
        // get the songs list
        List<Song> songs = songRepository.displayAllSongs();
        System.out.println("=============================================================================================");
        System.out.println("SongId     SongName           Genre           Artist             Album             Duration");
        System.out.println("=============================================================================================");
        System.out.println(songs.toString().replaceAll("[\\[\\]]", "").replace(",", ""));
        System.out.println("=============================================================================================");
    }

    /**
     * This function takes the song id as input and plays the song
     *
     * @param playChoice The song id of the song to be played.
     */
    public void playSongChoice(int playChoice) {
        // get the list of songs
        List<Song> songs = songRepository.displayAllSongs();
        for (Song songAll : songs) {
            if (songAll.getSongId() == playChoice) {
                System.out.println("Current Playing song " + songAll.getSongName() + " Song Duration :" + songAll.getDuration());
                String songPath = songAll.getSongPath();
                // pass the song path to play method
                play(songPath);
            }
        }
    }

    /**
     * It displays all the playlists or a specific playlist based on the user's choice
     *
     * @param displayChoice 1 for displaying all playlists, 2 for displaying a specific playlist
     */
    public void displayPlaylistChoice(int displayChoice) {
        // check the choice
        if (displayChoice == 1) {
            // display all playlist
            playlistRepository.displayAllPlaylists();
        } else if (displayChoice == 2) {
            // prompt to enter the name
            System.out.println("\u001B[32m Enter name of the Playlist : \u001B[0m");
            String playlistName = input.nextLine();
            // call the displayPlaylist method
            List<Playlist> playlist = playlistRepository.displayPlaylist(playlistName);
            // print the playlist
            System.out.format("%5s %20s ", "PlaylistId", "PlaylistName\n");
            System.out.println("===============================================================================================");
            System.out.println(playlist.toString().replaceAll("[\\[\\]]", ",").replace(",", ""));
            System.out.println("===============================================================================================");
            System.out.println("\u001B[32m Enter the songId to play or Enter 21 to exit \u001B[0m");
            int songId = input.nextInt();
            // call the playSong method
            playSongChoice(songId);
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
    public void allTypeSort(int sortingChoice) {
        // check the entered choice
        switch (sortingChoice) {
            case 1:
                // call the sortByName()
                sortingService.sortByName();
                break;
            case 2:
                // call SortByArtist()
                sortingService.sortByArtist();
                break;
            case 3:
                // call SortByGenre()
                sortingService.sortByGenre();
                break;
            default:
                System.err.println("Enter a valid choice");
                break;
        }
    }

    /**
     * This function displays the menu of the application
     */
    public void displayDetails() {
        System.out.println("\u001B[32m==================================================== \u001B[0m");
        System.out.println("\u001B[32m                  Welcome to Jukebox                \u001B[0m");
        System.out.println("\u001B[32m==================================================== \u001B[0m\n");
        System.out.println("1.Display All Songs \n2.Search songs \n3.Create a playlist \n4.Delete Playlist \n5.Add songs to Playlist \n6.Display Playlist \n7.shuffle the songs \n8.Sort songs \n9.exit");
    }

    /**
     * It gets all the songs from the repository, shuffles them, and prints them
     */
    public void shuffleDisplay() {
        // get the songs list
        List<Song> songs = songRepository.displayAllSongs();
        // shuffle the songs
        List<Song> shuffledSongs = shuffle(songs);
        // print the songs
        System.out.println("=============================================================================================");
        System.out.println("SongId     SongName           Genre           Artist             Album             Duration");
        System.out.println("=============================================================================================");
        System.out.println(shuffledSongs.toString().replaceAll("[\\[\\]]", "").replace(",", ""));
        System.out.println("=============================================================================================");

    }

    /**
     * It takes the playlistId and songIds as input and adds the songs to the playlist
     */
    public void addSongsDisplay() {
        int addSongChoice;
        do {
            System.out.println("\u001B[32m All the playlists Available : \u001B[0m\n");
            getAllSongs();
            playlistRepository.displayPlaylist();
            // prompt to enter playlistId
            System.out.println("\u001B[32m Enter the PlaylistId : \u001B[0m");
            int playlistId = input.nextInt();
            // prompt to enter song ids
            System.out.println("\u001B[32m Enter the Song Ids : \u001B[0m");
            input.nextLine();
            String songIds = input.nextLine();
            // handle the exception
            try {
                playlistRepository.addSongToPlaylist(playlistId, songIds);
            } catch (InvalidSongNumberException exception) {
                System.out.println(exception.getMessage());
                exception.printStackTrace();
            }
            System.out.println("\u001B[32m Enter 21 to exit or 1 to add songs again \u001B[0m");
            addSongChoice = input.nextInt();
        } while (addSongChoice != 21);
    }
}


