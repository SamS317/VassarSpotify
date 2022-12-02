package edu.vassar.cmpu203.vassarspotify.model;

import java.util.ArrayList;
import java.util.List;

public class QHistory {
    List<Song> hist = new <Song>ArrayList<Song>();
    int currSongIndex = 0;

    public QHistory(){}

    //Add a song to the queue by adding it to the end of the history
    public void addToQueue(Song s){
        hist.add(s);
    }

    //plays the next song
    //if no next song then returns random song

    //return null, then in the play screen if it sees null THATS where it gets the random song
    public Song playNextSong(){
        if( currSongIndex + 1 == hist.size() ){
            return null;
            //return new Song("Over","Drake");
            //return random song from song database
        }

        currSongIndex += 1;
        return hist.get(currSongIndex);
    }

//    public Song replayPreviousSong(){
//        if(currSongIndex <= 1){
//            return hist.get(currSongIndex);
//        }
//
//        currSongIndex -= 1;
//        hist.get(currSongIndex);
//    }

}
