package edu.vassar.cmpu203.vassarspotify.view;

import android.view.View;

import androidx.fragment.app.Fragment;

import java.util.List;

import edu.vassar.cmpu203.vassarspotify.model.Song;

public interface ISearchFragment {
    public View getRootView();


    public void updateSearchDisplay(List<Song> sList);
    interface  Listener{
        void searchAdded(String searchText, boolean songCheck, boolean artistCheck, SearchFragment sfragment);
    }
}
