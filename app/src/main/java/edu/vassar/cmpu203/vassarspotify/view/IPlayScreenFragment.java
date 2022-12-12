package edu.vassar.cmpu203.vassarspotify.view;

import android.content.Context;

import edu.vassar.cmpu203.vassarspotify.model.Song;

public interface IPlayScreenFragment {
    interface Listener{
        Song getSongFromSongDatabase(String songName, String artistName);
        Song nextSong(Song s);
        Song previousSong(Song s);
        Song getCurrentSong();
        void playPauseGivenSong(Context context, Song s);
        boolean isSongPlaying();
        String getRightText(String name, String artist);

    }
    void changeTextValues(Song s);
}
