package edu.vassar.cmpu203.vassarspotify.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.List;

import edu.vassar.cmpu203.vassarspotify.model.Profile;
import edu.vassar.cmpu203.vassarspotify.model.ProfileDatabase;
import edu.vassar.cmpu203.vassarspotify.model.SongDatabase;
import edu.vassar.cmpu203.vassarspotify.model.Song;
import edu.vassar.cmpu203.vassarspotify.view.ILoginFragment;
import edu.vassar.cmpu203.vassarspotify.view.IMainView;
import edu.vassar.cmpu203.vassarspotify.view.ISearchFragment;
import edu.vassar.cmpu203.vassarspotify.view.LoginFragment;
import edu.vassar.cmpu203.vassarspotify.view.MainView;
import edu.vassar.cmpu203.vassarspotify.view.SearchFragment;


public class MainActivity extends AppCompatActivity implements ISearchFragment.Listener, ILoginFragment.Listener {

    ProfileDatabase pd = new ProfileDatabase();
    Profile Connor = new Profile("Connor", "Genius");

    SongDatabase currentSearch = new SongDatabase();
    private MainView mainView;

    //search_fragment sfragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        pd.addProfile(Connor);
        super.onCreate(savedInstanceState);


        mainView = new MainView(this);
        mainView.displayFragment(new LoginFragment(this), false, "login");
//        mainView.displayFragment(new SearchFragment(this),true, "search");
//        this.addItemsView = new AddItemsView(getApplicationContext(), this);

        setContentView(mainView.getRootView());
    }

    @Override
    public void searchAdded(String searchText, boolean songCheck, boolean artistCheck, SearchFragment sfragment) {
        List<Song> returnList;
        List<Song> returnList2;
        if (songCheck && !artistCheck) {
            returnList = this.currentSearch.searchSong(searchText);
        }
        else if (artistCheck && !songCheck){
            returnList = this.currentSearch.searchArtist(searchText);
        }
        else{
            returnList = this.currentSearch.searchSong(searchText);
            returnList2 = this.currentSearch.searchArtist(searchText);
            returnList.addAll(returnList2);
        }

        sfragment.updateSearchDisplay(returnList);

    }

    @Override
    public void LogIn(String username, String password, LoginFragment lfragment) {
        boolean hold = false;
        for (Profile p: pd.getProfiles()){
            if (p.getUsername().equalsIgnoreCase(username)){
                 if (p.checkLogin(username, password)){
                     hold = true;
                }
            }

        }
        if (hold){
            this.mainView.displayFragment(new SearchFragment(this),true, "search");
        }
        lfragment.successfullyLoggedIn(hold);

    }

    @Override
    public void CreateUser(String username, String password, LoginFragment lfragment) {
        Profile p = new Profile(username, password);
        pd.addProfile(p);
        lfragment.successfullyLoggedIn(true);
        this.mainView.displayFragment(new SearchFragment(this),true, "search");
    }



}