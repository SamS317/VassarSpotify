package edu.vassar.cmpu203.vassarspotify.view;

import android.view.View;

import java.util.List;

import edu.vassar.cmpu203.vassarspotify.model.Song;
import edu.vassar.cmpu203.vassarspotify.model.SongDatabase;

public interface IAddItemsView {

    interface  Listener{
        void searchAdded(String searchText, boolean songCheck, boolean artistCheck);
        void onLogin();
    }




    void updateSearchDisplay(List<Song> s);
}
