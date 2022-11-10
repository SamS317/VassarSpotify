package edu.vassar.cmpu203.vassarspotify.view;

import java.util.List;

import edu.vassar.cmpu203.vassarspotify.model.Song;

public interface IAddItemsView {

    interface  Listener{
        void searchAdded(String searchText, boolean songCheck, boolean artistCheck, SearchFragment search_fragment);
        void LogIn(String usernname, String password);
        void CreateUser(String usernname, String password);
        void onLogin();
    }




    void updateSearchDisplay(List<Song> s);
}
