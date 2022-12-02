package edu.vassar.cmpu203.vassarspotify.model;

import java.util.ArrayList;
import java.util.List;

/*
History is different than queue in a couple ways

If the user wants to go back to a previous song they can
The system then returns the previously played song

If the user queue's a song after replaying the history gets deleted

Example:
Lets say you have a history sequence shown below

abcdab

Where each letter describes a different song
The user is currently on counter = 5
If the user goes back, counter = 4 and song = a
If the user plays another song, the new history should be

abcdaj

Where j is the new song added
Notice the deletion of b in the history

*/

public class History {
    List<Song> hist = new <Song>ArrayList<Song>();
    int counter = 0;

    public History(){}

    public void addToHistory(Song s){
        hist = hist.subList(0, counter); //Explain later if it works haha
        counter += 1;
        hist.add(s);
    }

    public Song replayPrevSong(){
        try{
            Song returnSong = hist.get( counter - 1 );
            counter -= 1;

            return returnSong;
        }catch(Exception e){
            return new Song("Take your breath away","Berlin");
        }
    }

    public Song skipThisSong(){
        try{
            Song returnSong = hist.get( counter + 1 );
            counter += 1;

            return returnSong;
        }catch(Exception e){
            return new Song("Take your breath away","Berlin");
        }
    }

}