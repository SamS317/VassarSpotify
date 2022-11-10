package edu.vassar.cmpu203.vassarspotify.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.List;

import edu.vassar.cmpu203.vassarspotify.model.Profile;
import edu.vassar.cmpu203.vassarspotify.model.SongDatabase;
import edu.vassar.cmpu203.vassarspotify.model.Song;
import edu.vassar.cmpu203.vassarspotify.view.IAddItemsView;
import edu.vassar.cmpu203.vassarspotify.view.IMainView;
import edu.vassar.cmpu203.vassarspotify.view.ISearchFragment;
import edu.vassar.cmpu203.vassarspotify.view.MainView;
import edu.vassar.cmpu203.vassarspotify.view.SearchFragment;


public class MainActivity extends AppCompatActivity implements  IAddItemsView.Listener, ISearchFragment.Listener  {

    Profile Connor = new Profile("Connor", "Genius");
    Profile Pf = new Profile();

    SongDatabase currentSearch = new SongDatabase();
    IAddItemsView addItemsView;
    //search_fragment sfragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        IMainView mainView = new MainView(this);
        mainView.displayFragment(new SearchFragment(this),true, "add items");
//        this.addItemsView = new AddItemsView(getApplicationContext(), this);

        setContentView(mainView.getRootView());
    }

    @Override
    public void searchAdded(String searchText, boolean songCheck, boolean artistCheck, SearchFragment sfragment) {
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

    public void LogIn(String username, String password){

    }
    public void CreateUser(String username, String password){

    }


    @Override
    public void onLogin() {

    }
}