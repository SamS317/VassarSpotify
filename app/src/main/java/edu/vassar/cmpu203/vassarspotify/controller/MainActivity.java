package edu.vassar.cmpu203.vassarspotify.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.List;

import edu.vassar.cmpu203.vassarspotify.model.SongDatabase;
import edu.vassar.cmpu203.vassarspotify.model.Song;
import edu.vassar.cmpu203.vassarspotify.view.IAddItemsView;
import edu.vassar.cmpu203.vassarspotify.view.IMainView;
import edu.vassar.cmpu203.vassarspotify.view.Isearch_fragment;
import edu.vassar.cmpu203.vassarspotify.view.MainView;
import edu.vassar.cmpu203.vassarspotify.view.search_fragment;


public class MainActivity extends AppCompatActivity implements  IAddItemsView.Listener, Isearch_fragment.Listener  {

    SongDatabase currentSearch = new SongDatabase();
    IAddItemsView addItemsView;
    //search_fragment sfragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        IMainView mainView = new MainView(this);
        mainView.displayFragment(new search_fragment(this),true, "add items");
//        this.addItemsView = new AddItemsView(getApplicationContext(), this);

        setContentView(mainView.getRootView());
    }

    @Override
    public void searchAdded(String searchText, boolean songCheck, boolean artistCheck, search_fragment sfragment) {
        List<Song> returnList;
        if (songCheck) {
            returnList = this.currentSearch.searchSong(searchText);
        }
        else if (artistCheck){
            returnList = this.currentSearch.searchArtist(searchText);
        }
        else{
            returnList = this.currentSearch.searchSong(searchText); //change later for search of both artist and name
        }

        sfragment.updateSearchDisplay(returnList);

    }



    @Override
    public void onLogin() {

    }
}