package com.niit.jukebox;

import com.niit.jukebox.exception.PlaylistNotCreatedException;
import com.niit.jukebox.model.Song;
import com.niit.jukebox.repository.PlaylistRepository;
import com.niit.jukebox.repository.SongRepository;
import com.niit.jukebox.service.JukeboxService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice;
        do {
            // create an object to call the methods
            SongRepository songRepository = new SongRepository();
            JukeboxService jukeboxService = new JukeboxService();
            PlaylistRepository playlistRepository = new PlaylistRepository();
            // displays the welcome message for jukebox
            jukeboxService.displayDetails();
            // ask the user to enter choice
            System.out.println("Enter your choice : ");
            Scanner input = new Scanner(System.in);
            choice = input.nextInt();
            // switch case for looping
            switch (choice) {
                case 1:
                    // display all songs
                    jukeboxService.getAllSongs();
                    // prompt to enter choice
                    System.out.println("1.Enter songId to play 2.Enter 21 to exit");
                    int enteredNumber = input.nextInt();
                    jukeboxService.playSongChoice(enteredNumber);
                    break;
                case 2:
                    // search songs based on artist genre and song name
                    System.out.println("Search songs based on \n1.Artist \n2.Genre \n3.Song Name");
                    // prompt to enter search type
                    System.out.println("Enter search Type : ");
                    int searchChoice = input.nextInt();
                    // check the entered number and display
                    switch (searchChoice) {
                        case 1: {
                            List<Song> songs = songRepository.displayAllSongs();
                            // prompt to enter artist name
                            System.out.println("Enter Artist Name : \n");
                            input.nextLine();
                            String artistName = input.nextLine();
                            List<Song> artistSongs = songRepository.searchByArtist(songs, artistName);
                            // display all the songs of the artist
                            System.out.println("=============================================================================================");
                            System.out.println("SongId     SongName           Genre           Artist             Album             Duration");
                            System.out.println("=============================================================================================");
                            System.out.println(artistSongs.toString().replaceAll("[\\[\\]]", "").replace(",", ""));
                            System.out.println("=============================================================================================");
                            System.out.println("Enter song Id to play or Enter 21 to exit");
                            int playArtistChoice = input.nextInt();
                            // call the play song method to play
                            jukeboxService.playSongChoice(playArtistChoice);
                            break;
                        }
                        case 2: {
                            List<Song> songs = songRepository.displayAllSongs();
                            System.out.println("Enter Genre Name : \n");
                            input.nextLine();
                            String genreName = input.nextLine();
                            List<Song> genreSongs = songRepository.searchByGenre(songs, genreName);
                            System.out.println("=============================================================================================");
                            System.out.println("SongId     SongName           Genre           Artist             Album             Duration");
                            System.out.println("=============================================================================================");
                            System.out.println(genreSongs.toString().replaceAll("[\\[\\]]", "").replace(",", ""));
                            System.out.println("=============================================================================================");
                            System.out.println("Enter song Id to play or Enter 21 to exit");
                            int playGenreChoice = input.nextInt();
                            // call the play song method to play
                            jukeboxService.playSongChoice(playGenreChoice);
                            break;
                        }
                        case 3: {
                            List<Song> songList = songRepository.displayAllSongs();
                            System.out.println("Enter Song Name : \n");
                            input.nextLine();
                            String songName = input.nextLine();
                            List<Song> songNames = songRepository.searchByName(songList, songName);
                            System.out.println("=============================================================================================");
                            System.out.println("SongId     SongName           Genre           Artist             Album             Duration");
                            System.out.println("=============================================================================================");
                            System.out.println(songNames.toString().replaceAll("[\\[\\]]", "").replace(",", ""));
                            System.out.println("=============================================================================================");
                            System.out.println("Enter song Id to play or Enter 21 to exit");
                            int playGenreChoice = input.nextInt();
                            // call the play song method to play
                            jukeboxService.playSongChoice(playGenreChoice);
                            break;
                        }
                        default:
                            return;
                    }
                    break;
                case 3: {
                    System.out.println("All the available songs : \n");
                    jukeboxService.getAllSongs();
                    // prompt to enter name of the play list
                    System.out.println("Enter the Name of the playlist :\n");
                    input.nextLine();
                    String playlistName = input.nextLine();
                    // prompt to create a playlist
                    System.out.println("Enter song Numbers to Create a playlist : \n");
                    String songNumbers = input.nextLine();
                    try {
                        // handle the exception
                        playlistRepository.createPlaylist(playlistName, songNumbers);
                    } catch (PlaylistNotCreatedException exception) {
                        System.err.println(exception.getMessage());
                        exception.printStackTrace();
                    }
                    // ask to display playlist
                    System.out.println("1.Display all Playlist  2.Display your playlist 0.exit");
                    int playlistChoice = input.nextInt();
                    // call the display play list method to display based on choice
                    jukeboxService.displayPlaylistChoice(playlistChoice);
                    break;
                }
                case 4:
                    playlistRepository.displayPlaylistNames();
                    // prompt to enter name of the playlist
                    System.out.println("Enter the Name of the Playlist to delete");
                    input.nextLine();
                    String deletePlaylist = input.nextLine();
                    // call the remove playlist mto delete the playlist
                    playlistRepository.removePlaylist(deletePlaylist);
                    break;
                case 5: {
                    // display all the songs
                    jukeboxService.getAllSongs();
                    jukeboxService.addSongsDisplay();
                    break;
                }
                case 6:
                    // display the choice of playlist
                    System.out.println("1.Display all playlist  2.Display My Playlist");
                    // take the input
                    int displayChoice = input.nextInt();
                    jukeboxService.displayPlaylistChoice(displayChoice);
                    break;
                case 7: {
                    // display the shuffle songs
                    jukeboxService.shuffleDisplay();
                    // prompt to enter the song number
                    System.out.println("Enter songId to play the song from playlist or Enter 21 to exit");
                    int playlistPlayChoice = input.nextInt();
                    // play the song entered
                    jukeboxService.playSongChoice(playlistPlayChoice);
                    break;
                }
                case 8: {
                    System.out.println("Sort songs Based on : \n");
                    // prompt to enter the sorting type
                    System.out.println("1.SongName  2.Artist  3.Genre ");
                    int sortingChoice = input.nextInt();
                    // call the method to display the sorted songs
                    jukeboxService.allTypeSort(sortingChoice);
                    // prompt to enter the song or exit
                    System.out.println("Enter songId to play the song from playlist or enter 21 to exit ");
                    int playlistPlayChoice = input.nextInt();
                    // call the method to play song based on choice
                    jukeboxService.playSongChoice(playlistPlayChoice);
                    break;
                }
                case 9:
                    System.out.println("-------------Thanks for using Jukebox-------");
                    System.out.println("---------------See you again soon-------------");
                    return;
                default:
                    System.out.println("Please Enter a valid Choice");
                    break;
            }
        } while (true);
    }
}