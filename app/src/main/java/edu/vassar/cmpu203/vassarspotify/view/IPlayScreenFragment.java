package edu.vassar.cmpu203.vassarspotify.view;

import android.content.Context;

import edu.vassar.cmpu203.vassarspotify.model.Song;

public interface IPlayScreenFragment {
    interface Listener{
        Song getSongFromSongDatabase(String songName, String artistName);
        boolean playMusic(Song s);
        Song nextSong(Song s);
        Song previousSong(Song s);
        void changeToSearchScreen(PlayScreenFragment PSFragment);
        Song getCurrentSong();
        void playPauseGivenSong(Context context, Song s);
        boolean isSongPlaying();
    }
    void changeTextValues(Song s);
}
