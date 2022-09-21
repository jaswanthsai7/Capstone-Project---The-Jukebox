/*
 * Author Name : Jaswanth Sai
 * Date : 9/21/2022
 * Created With: INTELLIJ IDEA COMMUNITY EDITION
 */
package com.niit.jukebox.implementation;

import com.niit.jukebox.repository.SongRepository;

import java.util.Scanner;

public class JukeboxImpl {
    SongRepository songRepository;

    public JukeboxImpl() {
        songRepository = new SongRepository();
    }

    public void jukeboxImpl() {
        System.out.println("===================================================");
        System.out.println("                  Welcome to Jukebox               ");
        System.out.println("===================================================\n");
        System.out.println("1.Display All Songs \n2.Play a song \n3.Create a playlist \n4.Delete Playlist \n5.Add songs to Playlist \n6.Display Playlist");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        switch (choice) {
            case '1':
                songRepository.displayAllSongs();

        }
    }
}
