package edu.vassar.cmpu203.vassarspotify.view;

import edu.vassar.cmpu203.vassarspotify.model.Song;

public interface IPlayScreenFragment {
    interface Listener{
        Song getSongFromModel(String songName, String artistName);
    }
}
