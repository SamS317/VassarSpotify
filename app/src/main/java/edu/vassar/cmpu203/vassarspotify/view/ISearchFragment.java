package edu.vassar.cmpu203.vassarspotify.view;

import android.view.View;

import java.util.List;

import edu.vassar.cmpu203.vassarspotify.model.Song;

public interface ISearchFragment {
    View getRootView();


    void updateSearchDisplay(List<Song> sList);
    interface  Listener{
        void searchSongDatabase(String searchText, boolean songCheck, boolean artistCheck, SearchFragment sfragment);
        void displayPlayFromSearch(Song s);
        boolean addSongToQueue(Song s);
        void displaySubPlaylistWithSong(Song s);
    }
}