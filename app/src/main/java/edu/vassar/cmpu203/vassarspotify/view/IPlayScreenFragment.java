package edu.vassar.cmpu203.vassarspotify.view;

import edu.vassar.cmpu203.vassarspotify.model.Song;

public interface IPlayScreenFragment {
    interface Listener{
        Song getSongFromModel(String songName, String artistName);
        boolean playMusic(Song s);
        Song nextSong(Song s);
        Song previousSong(Song s);
        void changeToSearchScreen(PlayScreenFragment PSFragment);
        Song getCurrentSong();
    }
    void changeTextValues(Song s);
}
