package edu.vassar.cmpu203.vassarspotify.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides a way to hold multiple songs in one place
 * Can be used to play the whole playlist later on
 */
public class Playlist {
    List<Song> playlist = new <Song>ArrayList<Song>();

    String name;
    public Playlist(String name){ this.name = name; }

    public Playlist(){}

    /**
     * Provides a way to add a song to a playlist
     * @param s Song to be added
     */
    public void addSong(Song s){
        playlist.add(s);
    }

    public String getName() { return name; }

    public List<Song> getPlaylist(){ return this.playlist; }

    public String getPlaylistName(Playlist playlist){ return playlist.name; }
}