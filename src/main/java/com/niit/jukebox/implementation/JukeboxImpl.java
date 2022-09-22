/*
 * Author Name : Jaswanth Sai
 * Date : 9/21/2022
 * Created With: INTELLIJ IDEA COMMUNITY EDITION
 */
package com.niit.jukebox.implementation;

import com.niit.jukebox.exception.InvalidSongNumberException;
import com.niit.jukebox.exception.PlaylistNotCreatedException;
import com.niit.jukebox.model.Playlist;
import com.niit.jukebox.model.Song;
import com.niit.jukebox.repository.PlaylistRepository;
import com.niit.jukebox.repository.SongRepository;
import com.niit.jukebox.service.JukeboxService;

import java.util.List;
import java.util.Scanner;

public class JukeboxImpl {
    SongRepository songRepository;
    JukeboxService jukeboxService;
    PlaylistRepository playlistRepository;
    Scanner input = new Scanner(System.in);

    public JukeboxImpl() {
        songRepository = new SongRepository();
        jukeboxService = new JukeboxService();
        playlistRepository = new PlaylistRepository();
    }

    public void jukeboxImpl() {
        int num;
        do {
            System.out.println("===================================================");
            System.out.println("                  Welcome to Jukebox               ");
            System.out.println("===================================================\n");
            System.out.println("1.Display All Songs \n2.Search songs \n3.Create a playlist \n4.Delete Playlist \n5.Add songs to Playlist \n6.Display Playlist \n7.shuffle the songs \n8.exit");
            System.out.println("Enter your choice : ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    getAllSongs();
                    System.out.println("Enter the Song number to play the song :");
                    int playChoice = input.nextInt();
                    playSong(playChoice);
                    break;
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
                            songRepository.searchByArtist(songs, artistName);
                            System.out.println("Enter the Song number to play the song :");
                            int playArtistChoice = input.nextInt();
                            playSong(playArtistChoice);

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
                            playSong(playGenreChoice);

                            break;
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
                        playSong(playlistPlayChoice);
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
                    getAllSongs();
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
                    displayPlaylist(displayChoice);
                    break;
                case 7: {
                    List<Song> songs = songRepository.displayAllSongs();
                    jukeboxService.shuffle(songs);
                    System.out.println("Enter song Number to play the song from playlist");
                    int playlistPlayChoice = input.nextInt();
                    playSong(playlistPlayChoice);
                    break;
                }
                case 8:
                    System.out.println("-------------Thanks for using Jukebox-------");
                    System.out.println("---------------See you again soon-------------");
                    break;
                default:
                    return;
            }
            num = input.nextInt();
        } while (num != 0);
    }

    private void getAllSongs() {
        List<Song> songs = songRepository.displayAllSongs();
        System.out.println(songs.toString().replaceAll("[\\[\\]]", ""));

    }

    private void playSong(int playChoice) {
        List<Song> songs = songRepository.displayAllSongs();
        songs.stream().filter(sortedSongs -> sortedSongs.getSongId() == playChoice).forEachOrdered(sortedSongs -> {
            String songPath = sortedSongs.getSongPath();
            System.out.println("Current Playing song " + sortedSongs.getSongName() + " Song Duration :" + sortedSongs.getDuration());
            jukeboxService.play(songPath);
        });
    }

    private void displayPlaylist(int displayChoice) {
        if (displayChoice == 1) {
            playlistRepository.displayAllPlaylists();
        } else if (displayChoice == 2) {
            System.out.println("Enter name of the Playlist : ");
            input.nextLine();
            String playlistName = input.nextLine();
            List<Playlist> playlists = playlistRepository.displayPlaylist(playlistName);
            System.out.println(playlists.toString().replaceAll("[\\[\\]]", ""));
        }
    }
}
