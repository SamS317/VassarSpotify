package edu.vassar.cmpu203.vassarspotify.view;

import java.util.List;

import edu.vassar.cmpu203.vassarspotify.model.Playlist;
import edu.vassar.cmpu203.vassarspotify.model.Song;

public interface IPlaylistFragment {
    interface Listener{
        String getGivenPlaylistName(Playlist playlist);
        List<Song> getCurrentPlaylist(String name);
        void displayPlayFromPlaylist(Song s);
        boolean addSongToQueue(Song s);
    }
}
