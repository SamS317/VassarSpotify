package edu.vassar.cmpu203.vassarspotify.view;

import android.view.View;

import edu.vassar.cmpu203.vassarspotify.model.SongDatabase;

public interface IAddItemsView {

    interface  Listener{
        void searchAdded(String searchText, boolean songCheck, boolean artistCheck);
    }


    View getRootView();

    void updateSearchDisplay(SongDatabase s);
}
