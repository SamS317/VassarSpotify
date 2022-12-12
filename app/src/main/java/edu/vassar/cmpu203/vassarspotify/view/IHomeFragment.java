package edu.vassar.cmpu203.vassarspotify.view;

import java.util.List;

import edu.vassar.cmpu203.vassarspotify.model.Playlist;

public interface IHomeFragment {
    interface Listener{
        String getUsername();
        String getPlaylistName(Playlist playlist);

        boolean addPlaylist(String s);

        List<Playlist> getPlaylists();

        void displayPlaylistFragment(String name);
        void displayHomeFragment();
        void logOut();
    }
}