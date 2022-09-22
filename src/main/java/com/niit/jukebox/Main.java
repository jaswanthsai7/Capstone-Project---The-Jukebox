package com.niit.jukebox;

import com.niit.jukebox.exception.InvalidSongNumberException;
import com.niit.jukebox.exception.PlaylistNotCreatedException;
import com.niit.jukebox.model.Playlist;
import com.niit.jukebox.model.Song;
import com.niit.jukebox.repository.PlaylistRepository;
import com.niit.jukebox.repository.SongRepository;
import com.niit.jukebox.service.JukeboxService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int num;
        do {

            SongRepository songRepository = new SongRepository();
            JukeboxService jukeboxService = new JukeboxService();
            PlaylistRepository playlistRepository = new PlaylistRepository();
            jukeboxService.displayDetails();
            System.out.println("Enter your choice : ");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    jukeboxService.getAllSongs();
                    System.out.println("Enter 2 to exit");
                    int enteredNumber = input.nextInt();
                    if (enteredNumber == 2) {
                        break;
                    }
                case 2:
                    System.out.println("Search songs based on \n1.Artist \n2.Genre \n3.Song Name");
                    System.out.println("Enter search Type : ");
                    int sortChoice = input.nextInt();
                    switch (sortChoice) {
                        case 1: {
                            List<Song> songs = songRepository.displayAllSongs();
                            System.out.println("Enter Artist Name : \n");
                            input.nextLine();
                            String artistName = input.nextLine();
                            List<Song> songList = songRepository.searchByArtist(songs, artistName);
                            System.out.println(songList.toString().replaceAll("[\\[\\]]", ""));
                            System.out.println("Enter the Song number to play the song :");
                            int playArtistChoice = input.nextInt();
                            jukeboxService.playSong(playArtistChoice);
                            break;
                        }
                        case 2: {
                            List<Song> songs = songRepository.displayAllSongs();
                            System.out.println("Enter Genre Name : \n");
                            input.nextLine();
                            String genreName = input.nextLine();
                            List<Song> songs1 = songRepository.searchByGenre(songs, genreName);
                            System.out.println(songs1.toString().replaceAll("[\\[\\]]", ""));
                            System.out.println("Enter the Song number to play the song :");
                            int playGenreChoice = input.nextInt();
                            jukeboxService.playSong(playGenreChoice);

                            break;
                        }
                        case 3: {
                            List<Song> songs = songRepository.displayAllSongs();
                            System.out.println("Enter Song Name : \n");
                            input.nextLine();
                            String songName = input.nextLine();
                            List<Song> songs1 = songRepository.searchByGenre(songs, songName);
                            System.out.println(songs1.toString().replaceAll("[\\[\\]]", ""));
                            System.out.println("Enter the Song number to play the song :");
                            int playGenreChoice = input.nextInt();
                            jukeboxService.playSong(playGenreChoice);

                        }
                        default:
                            return;
                    }
                    break;
                case 3: {
                    System.out.println("All the available songs : \n");
                    List<Song> songs = songRepository.displayAllSongs();
                    System.out.println(songs.toString().replaceAll("[\\[\\]]", ""));
                    System.out.println("Enter the Name of the playlist :\n");
                    input.nextLine();
                    String playlistName = input.nextLine();
                    System.out.println("Enter song Numbers to Create a playlist : \n");
                    String songNumbers = input.nextLine();
                    try {
                        playlistRepository.createPlaylist(playlistName, songNumbers);
                    } catch (PlaylistNotCreatedException exception) {
                        System.out.println("unable to create playlist");
                        exception.printStackTrace();
                    }
                    System.out.println("1.Display Playlist  \n2.exit");
                    int playlistChoice = input.nextInt();
                    if (playlistChoice == 1) {
                        System.out.println("Enter Playlist Name :");
                        input.nextLine();
                        String name = input.nextLine();
                        List<Playlist> playlists = playlistRepository.displayPlaylist(name);
                        System.out.println(playlists.toString().replaceAll("[\\[\\]]", ""));
                        System.out.println("1.Enter song Number to play the song from playlist \n2.exit");
                        int playlistPlayChoice = input.nextInt();
                        jukeboxService.playSong(playlistPlayChoice);
                    }
                    break;
                }
                case 4:
                    System.out.println("Enter the Name of the Playlist to delete");
                    input.nextLine();
                    String deletePlaylist = input.nextLine();
                    playlistRepository.removePlaylist(deletePlaylist);
                    break;
                case 5: {
                    jukeboxService.getAllSongs();
                    System.out.println("Enter the PlaylistId ");
                    int playlistId = input.nextInt();
                    System.out.println("Enter the Song Ids :");
                    input.nextLine();
                    String songIds = input.nextLine();
                    try {
                        playlistRepository.addSongToPlaylist(playlistId, songIds);
                    } catch (InvalidSongNumberException exception) {
                        exception.printStackTrace();
                    }

                    break;
                }
                case 6:
                    System.out.println("1.Display all playlist  2.Display My Playlist");
                    int displayChoice = input.nextInt();
                    jukeboxService.displayPlaylist(displayChoice);
                    break;
                case 7: {
                    List<Song> songs = songRepository.displayAllSongs();
                    List<Song> shuffledSongs = jukeboxService.shuffle(songs);
                    System.out.println(shuffledSongs);
                    System.out.println("Enter song Number to play the song from playlist");
                    int playlistPlayChoice = input.nextInt();
                    jukeboxService.playSong(playlistPlayChoice);
                    break;
                }
                case 8: {
                    System.out.println("Sort songs Based on : \n");
                    System.out.println("1.SongName  2.Artist  3.Genre ");
                    int sortingChoice = input.nextInt();
                    jukeboxService.allSort(sortingChoice);
                    break;
                }
                case 9:
                    System.out.println("-------------Thanks for using Jukebox-------");
                    System.out.println("---------------See you again soon-------------");
                    break;
                default:
                    return;
            }
            num = input.nextInt();
        } while (num != 0);

    }
}