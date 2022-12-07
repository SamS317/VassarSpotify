package edu.vassar.cmpu203.vassarspotify.model;

import java.util.ArrayList;
import java.util.List;

public class PlaylistDatabase {
    List<Playlist> playlists = new <Playlist>ArrayList<Playlist>();

    public PlaylistDatabase(){}

    public boolean addPlaylist(Playlist p){
        playlists.add(p);
        return true;
    }
    public List<Playlist> getPlaylists(){
        return this.playlists;
    }
}

