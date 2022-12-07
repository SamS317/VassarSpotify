package edu.vassar.cmpu203.vassarspotify.view;

import java.util.List;

import edu.vassar.cmpu203.vassarspotify.model.Playlist;
import edu.vassar.cmpu203.vassarspotify.model.Song;

public interface IListPlaylistFragment {

    interface Listener{
        List<Playlist> getPlaylists();
        void addToPlaylist(Playlist playlist, Song song);
    }
}

