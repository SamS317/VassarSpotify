package edu.vassar.cmpu203.vassarspotify.view;

import java.util.List;

import edu.vassar.cmpu203.vassarspotify.model.Song;

public interface IAddItemsView {

    interface  Listener{
        void searchAdded(String searchText, boolean songCheck, boolean artistCheck, search_fragment search_fragment);
        void onLogin();
    }




    void updateSearchDisplay(List<Song> s);
}
