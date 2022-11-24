package edu.vassar.cmpu203.vassarspotify.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.vassar.cmpu203.vassarspotify.R;
import edu.vassar.cmpu203.vassarspotify.model.History;
import edu.vassar.cmpu203.vassarspotify.model.Profile;
import edu.vassar.cmpu203.vassarspotify.model.ProfileDatabase;
import edu.vassar.cmpu203.vassarspotify.model.Queue;
import edu.vassar.cmpu203.vassarspotify.model.SongDatabase;
import edu.vassar.cmpu203.vassarspotify.model.Song;
import edu.vassar.cmpu203.vassarspotify.view.IHomeFragment;
import edu.vassar.cmpu203.vassarspotify.view.ILoginFragment;
import edu.vassar.cmpu203.vassarspotify.view.IPlayScreenFragment;
import edu.vassar.cmpu203.vassarspotify.view.ISearchFragment;
import edu.vassar.cmpu203.vassarspotify.view.LoginFragment;
import edu.vassar.cmpu203.vassarspotify.view.MainView;
import edu.vassar.cmpu203.vassarspotify.view.PlayScreenFragment;
import edu.vassar.cmpu203.vassarspotify.view.SearchFragment;


public class MainActivity extends AppCompatActivity implements ISearchFragment.Listener, ILoginFragment.Listener, IPlayScreenFragment.Listener, IHomeFragment.Listener {
    /***
     * The "Controller" class in our Model-View-Controller program
     */
    ProfileDatabase pd = new ProfileDatabase();

    //Media player stuff
    public boolean MPCreated = false;
    MediaPlayer mp;
    Song currSong;

    SongDatabase sd = new SongDatabase();
    private MainView mainView;

    Queue q = new Queue();
    History h = new History();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mainView = new MainView(this);
        mainView.displayFragment(new LoginFragment(this), false, "login");
//        mainView.displayFragment(new SearchFragment(this),true, "search");
//        this.addItemsView = new AddItemsView(getApplicationContext(), this);
        //mainView.displayFragment(new PlayScreenFragment(this), false, "play");

        setContentView(mainView.getRootView());
    }

    @Override
    public void searchAdded(String searchText, boolean songCheck, boolean artistCheck, SearchFragment sfragment) {

        //Gets rid of the keyboard after a song is searched
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }


        if (songCheck && !artistCheck) {
            sfragment.updateSearchDisplay(this.sd.searchSong(searchText));
        }
        else if (artistCheck && !songCheck){
            sfragment.updateSearchDisplay(this.sd.searchArtist(searchText));
        }
        else{
            List<Song> tempList = this.sd.searchArtist(searchText);
            tempList.addAll(sd.searchSong(searchText));

            Set<Song> songSet = new <Song> HashSet<Song>(tempList);
            List<Song> returnList = new <Song> ArrayList<Song>(songSet);

            sfragment.updateSearchDisplay(returnList);
        }
    }

    @Override
    public void changePlayScreen(SearchFragment searchFragment) {
        mainView.displayFragment(new PlayScreenFragment(this), false, "play");
    }

    @Override
    public void changePlayScreenWSong(Song s, SearchFragment searchFragment) {
        q.clearQueue();
        q.addSong(s);
        mainView.displayFragment(new PlayScreenFragment(this), false, "play");
    }

    public Song getSongFromSongDatabase(String songName, String artistName){
        return sd.getSong(songName, artistName);
    }

    @Override
    public void LogIn(String username, String password, LoginFragment lfragment) {
        boolean hold = false;
        for (Profile p: pd.getProfiles()){
            if (p.toString().equalsIgnoreCase(username)){
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

    public Song getCurrentSong(){
        return q.getCurrentSong();
    }

    public boolean playMusic(Song s){ return sd.play(s); }

    public Song nextSong(Song s){ return q.getNext(s); }

    public Song previousSong(Song s){ return q.getPrevious(s); }

    public boolean addSongToQueue(Song s){ return q.addSong(s); }

    @Override
    public void changeToSearchScreen(PlayScreenFragment PSFragment) {
        mainView.displayFragment(new SearchFragment(this), false, "play");
    }


    public void playPauseGivenSong(Context context, @NonNull Song s){
        //If we play a different song than currently playing
        //Change currSong to new input song
        //Reset media player has been created flag
        //Stop current audio if there is a current audio to stop
        if(! s.equals(currSong)){
            currSong = s;
            if (MPCreated){
                mp.stop();
            }
            MPCreated = false;
        }

        //If the song hasn't created a media
        if(MPCreated) {
            if (mp.isPlaying()) {
                mp.pause();
            } else {
                mp.start();
            }
        }else{
            mp = MediaPlayer.create(context, R.raw.overdrake);
            mp.start();
            MPCreated = true;
        }
    }

    public boolean isSongPlaying(){
        return mp.isPlaying();
    }

    @Override
    public void CreateUser(String username, String password, LoginFragment lfragment) {
        Profile p = new Profile(username, password);
        pd.addProfile(p);
        lfragment.successfullyLoggedIn(true);
        this.mainView.displayFragment(new SearchFragment(this),true, "search");
    }
}