package edu.vassar.cmpu203.vassarspotify.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.vassar.cmpu203.vassarspotify.model.Playlist;
import edu.vassar.cmpu203.vassarspotify.model.PlaylistDatabase;
import edu.vassar.cmpu203.vassarspotify.model.Profile;
import edu.vassar.cmpu203.vassarspotify.model.ProfileDatabase;
import edu.vassar.cmpu203.vassarspotify.model.Queue;
import edu.vassar.cmpu203.vassarspotify.model.SongDatabase;
import edu.vassar.cmpu203.vassarspotify.model.Song;
import edu.vassar.cmpu203.vassarspotify.view.HomeFragment;
import edu.vassar.cmpu203.vassarspotify.view.IHomeFragment;
import edu.vassar.cmpu203.vassarspotify.view.IListPlaylistFragment;
import edu.vassar.cmpu203.vassarspotify.view.ILoginFragment;
import edu.vassar.cmpu203.vassarspotify.view.IMainView;
import edu.vassar.cmpu203.vassarspotify.view.IPlayScreenFragment;
import edu.vassar.cmpu203.vassarspotify.view.IPlaylistFragment;
import edu.vassar.cmpu203.vassarspotify.view.ISearchFragment;
import edu.vassar.cmpu203.vassarspotify.view.ListPlaylistFragment;
import edu.vassar.cmpu203.vassarspotify.view.LoginFragment;
import edu.vassar.cmpu203.vassarspotify.view.MainView;
import edu.vassar.cmpu203.vassarspotify.view.PlayScreenFragment;
import edu.vassar.cmpu203.vassarspotify.view.PlaylistFragment;
import edu.vassar.cmpu203.vassarspotify.view.SearchFragment;


public class MainActivity extends AppCompatActivity implements ISearchFragment.Listener, ILoginFragment.Listener, IPlayScreenFragment.Listener, IHomeFragment.Listener, IMainView.Listener, IPlaylistFragment.Listener, IListPlaylistFragment.Listener {
    /***
     * The "Controller" class in our Model-View-Controller program
     *
     * pd        => The profile database where all of the profiles are stored
     * MPCreated => A gate that shows if a media player has been created
     * mp        => Our current media player
     * currSong  => The current song that is playing through media player
     * sd        => The current song database where all the songs are stored
     * mainView  => Main activity view class
     * q         => The queue class that holds the songs to be played next
     * h         => The history class that holds all the songs that have been played
     */


    public boolean MPCreated = false;
    MediaPlayer mp;
    Song currSong;

    SongDatabase sd = new SongDatabase();
    private MainView mainView;

    Queue q = new Queue();

    Playlist p = new Playlist();
    PlaylistDatabase pl = new PlaylistDatabase();

    Profile pf = new Profile();
    ProfileDatabase pd = new ProfileDatabase();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("users").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(@NonNull QuerySnapshot QSnap) {
                        for (DocumentSnapshot DSnap : QSnap) {
                            String name = (String) DSnap.get("name");
                            String password = (String) DSnap.get("password");

                            pd.addProfile( new Profile(name, password) );

                            String msg = String.format("%s profile added", name);
                            Log.i("NextGenPos", msg);
                        }
                    }
                });


        //load song if one saved
        File inFile = new File(this.getApplicationContext().getFilesDir(), "savedsongs2");
        if(inFile.isFile()) {
            try {
                FileInputStream fis = new FileInputStream(inFile);
                ObjectInputStream ois = new ObjectInputStream(fis);

                this.currSong =  (Song) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        mainView = new MainView(this, this);

        mainView.ignoreButtons();

        mainView.displayFragment(new LoginFragment(this), false, "login");

        setContentView(mainView.getRootView());
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) { super.onSaveInstanceState(outState); }


    /**
     * Provides a method to search for a song or artist
     * @param searchText The text to be searched in the database
     * @param songCheck True if the user wants search to include song names matching searchText
     * @param artistCheck True if the user wants search to include artist names matching searchText
     * @param sfragment The search fragment
     */
    @Override
    public void searchSongDatabase(String searchText, boolean songCheck, boolean artistCheck, SearchFragment sfragment) {
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

            sfragment.updateSearchDisplay( new <Song> ArrayList<Song>(songSet) );
        }
    }


    /**
     * The following methods change to various screens
     * In order:
     * Displays Search Screen
     * Displays Home Screen
     * Displays Login Screen
     * Displays Play Screen
     */
    @Override
    public void displaySearchFragment(){
        mainView.displayFragment(new SearchFragment(this), false, "search");
    }

    @Override
    public void displayHomeFragment(){
        mainView.displayFragment(new HomeFragment(this), false, "home");
    }

    @Override
    public void logOut() {
        mainView.displayFragment(new LoginFragment(this), false, "login");
    }

    @Override
    public void displayPlayFragment(){
        mainView.displayFragment(new PlayScreenFragment(this), false, "play2");
    }


    /**
     * Specific change screen method
     * This method provides a way to change between the search screen and the play screen while
     * changing the song on the play screen fragment
     * @param s Song to be displayed
     */
    @Override
    public void changePlayScreenWSong(Song s) {
        q.clearQueue();
        q.addSong(s);
        mainView.displayFragment(new PlayScreenFragment(this), false, "play");
    }

    @Override
    public void changePlayScreenWSong(Song s, PlaylistFragment playlistFragment) {
        q.clearQueue();
        q.addSong(s);
        //save song
        File outFile = new File(this.getApplicationContext().getFilesDir(), "savedsongs2");

        try {
            FileOutputStream fos = new FileOutputStream(outFile);
            ObjectOutputStream ous = new ObjectOutputStream(fos);

            ous.writeObject(this.currSong);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        Map<String, Object> newUserMap = new HashMap<>();
//
//        //Test data
//        newUserMap.put("name", this.getUsername());
//        newUserMap.put("password", this.getPassword());
//        newUserMap.put("currsong", this.currSong);
//
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//
//        String newPath = "users/" + this.getUsername();
//
//        DocumentReference docRef = db.document(newPath);

//        CollectionReference colRef = db.collection("users");
//        DocumentReference docRef = colRef.document(username);

//        docRef.set( newUserMap, SetOptions.merge() );
//        Map<String, Object> user1Map = new HashMap<>();
//        user1Map.put("name", this.getUsername());
//        user1Map.put("username", this.getUsername());
//        user1Map.put("password", this.getPassword());
//        user1Map.put("currSong", this.currSong);
//
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        CollectionReference colRef = db.collection("users");
//
//        DocumentReference docRef = colRef.document("users1");
//        docRef.set( user1Map, SetOptions.merge() );
//        colRef.add(user1Map);
        mainView.displayFragment(new PlayScreenFragment(this), false, "play");
    }

    public Song getSongFromSongDatabase(String songName, String artistName){
        return sd.getSong(songName, artistName);
    }


    public Song getCurrentSong(){
        return q.getCurrentSong();
    }

    public Song nextSong(Song s){

        return q.getNext(s);
    }

    public Song previousSong(Song s){ return q.getPrevious(s); }

    public boolean addSongToQueue(Song s){

        return q.addSong(s);

    }

    @Override
    public boolean deleteSong(Song s) {
        return false;
    }



    public void addSongToPlaylistHelper(Song s){

        mainView.displayFragment(new ListPlaylistFragment(this, s), false, "play");;
    }

    @Override
    public String getUsername(){
        return pf.getUsernameText();
    }
    public String getPassword(){
        return pf.getPassword();
    }

    public String getPlaylistName2(Playlist playlist){
        return playlist.getName();
    }
    public List<Song> getCurrentPlaylist(String name){
        List<Playlist> temp = pl.getPlaylists();
        for (Playlist plist: temp){
            if (plist.getName() == name){
                return plist.getPlaylist();
            }
        }
        return null;
    }
    public boolean addPlaylist(String s) {
        return pl.addPlaylist(new Playlist(s));
    }
    public List<Playlist> getPlaylists(){
        return pl.getPlaylists();
    }

    @Override
    public void addToPlaylist(Playlist playlist, Song s) {
        playlist.addSong(s);
    }

    public String getPlaylistName(Playlist playlist){
        return p.getPlaylistName(playlist);
    }
    public void displayPlaylistFragment(String name){
        List<Playlist> temp = pl.getPlaylists();
        Playlist p1 = null;
        for (Playlist plist: temp){
            if (plist.getName().equals(name)){
                p1 = plist;
            }
        }
        mainView.displayFragment(new PlaylistFragment(this, p1), false, "playlist");

    }

    public void playPauseGivenSong(Context context, @NonNull Song s){

        //If we play a different song than currently playing
        //Change currSong to new input song
        //Reset media player has been created flag
        //Stop current audio if there is a current audio to stop
        if(! s.equals(this.currSong)){

            this.currSong = s;
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
            mp = MediaPlayer.create(context, (Integer) sd.getRaddress(this.currSong.getSongName(), this.currSong.getArtist()));



            mp.start();
            MPCreated = true;
        }
    }

    public List<Profile> getProfilesForCreateUser(){
        return pd.getProfiles();
    }

    public boolean isSongPlaying(){
        return mp.isPlaying();
    }

    @Override
    public String getRightText(String name, String artist) {
        return sd.getString(name, artist);
    }

    //    public List<Song> getPlaylists
    @Override
    public void LogIn(String username, String password, LoginFragment lfragment) {
        mainView.showButtons();

        boolean hold = false;
        for (Profile p: pd.getProfiles()){
            if (p.toString().equalsIgnoreCase(username)){
                if (p.checkLogin(username, password)){
                    hold = true;
                    pf = p;
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
        mainView.showButtons();

        Map<String, Object> newUserMap = new HashMap<>();

        //Test data
        newUserMap.put("name", username);
        newUserMap.put("password", password);
        newUserMap.put("currsong", null);

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        String newPath = "users/" + username;

        DocumentReference docRef = db.document(newPath);

//        CollectionReference colRef = db.collection("users");
//        DocumentReference docRef = colRef.document(username);

        docRef.set( newUserMap, SetOptions.merge() );



        Profile p = new Profile(username, password);
        pd.addProfile(p);
        lfragment.successfullyLoggedIn(true);
        this.mainView.displayFragment(new SearchFragment(this),true, "search");
    }
}

//452 lines before purge