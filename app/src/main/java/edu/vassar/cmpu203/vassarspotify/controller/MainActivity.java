package edu.vassar.cmpu203.vassarspotify.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.List;

import edu.vassar.cmpu203.vassarspotify.model.SongDatabase;
import edu.vassar.cmpu203.vassarspotify.model.Song;
import edu.vassar.cmpu203.vassarspotify.view.AddItemsView;
import edu.vassar.cmpu203.vassarspotify.view.IAddItemsView;

public class MainActivity extends AppCompatActivity implements  IAddItemsView.Listener{

    SongDatabase currentSearch = new SongDatabase();
    IAddItemsView addItemsView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addItemsView = new AddItemsView(getApplicationContext(), this);

        setContentView(addItemsView.getRootView());
    }

    @Override
    public void searchAdded(String searchText, boolean songCheck, boolean artistCheck) {
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
        for (Song x: returnList){

        }
        this.addItemsView.updateSearchDisplay(this.currentSearch);
    }
}