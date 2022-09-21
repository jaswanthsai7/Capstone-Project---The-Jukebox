/*
 * Author Name : Jaswanth Sai
 * Date : 9/21/2022
 * Created With: INTELLIJ IDEA COMMUNITY EDITION
 */
/*package com.niit.jukebox.implementation;

import com.niit.jukebox.model.Song;
import com.niit.jukebox.repository.SongRepository;
import com.niit.jukebox.service.JukeboxService;

import java.util.List;
import java.util.Scanner;

public class JukeboxImpl {
    SongRepository songRepository;
    JukeboxService jukeboxService;

    public JukeboxImpl() {
        songRepository = new SongRepository();
        jukeboxService = new JukeboxService();
    }

    public void jukeboxImpl() {
        System.out.println("===================================================");
        System.out.println("                  Welcome to Jukebox               ");
        System.out.println("===================================================\n");
        System.out.println("1.Display All Songs \n2.Create a playlist \n3.Delete Playlist \n4.Add songs to Playlist \n5.Display Playlist \n6.exit");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your choice : ");
        int choice = input.nextInt();
        if (choice == 1) {
            System.out.println(" display all the songs based on \n1.Artist \n2.Genre");
            System.out.println("Enter sorting Type : ");
            int sortChoice = input.nextInt();
            if (sortChoice == 1) {
                List<Song> songs = songRepository.displayAllSongs();
                songRepository.searchByArtist(songs,);
                System.out.println("Enter the Song number to play the song :");
                int playChoice = input.nextInt();
                for (Song sortedSongs : songs) {
                    if (sortedSongs.getSongId() == playChoice) {
                        String songPath = sortedSongs.getSongPath();
                        System.out.println("Current Playing song " + sortedSongs.getSongName() + " Song Duration :" + sortedSongs.getDuration());
                        System.out.println("Press 1 to Stop");
                        int stopChoice = input.nextInt();
                        jukeboxService.Play(songPath);

                    }
                }

            } else if (sortChoice == 2) {
                List<Song> songs = songRepository.displayAllSongs();
                songRepository.sortByGenre(songs);
                System.out.println("enter the song number to play the song");
                int playChoice = input.nextInt();
                for (Song sortedSongs : songs) {
                    if (sortedSongs.getSongId() == playChoice) {
                        String songPath = sortedSongs.getSongPath();
                        jukeboxService.Play(songPath);
                    }
                }
            }
        } else if (choice == 6) {
        }
    }
}*/
