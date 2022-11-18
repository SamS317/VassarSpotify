package edu.vassar.cmpu203.vassarspotify.model;

import java.util.ArrayList;
import java.util.List;

public class History {
    List<Song> hist = new <Song>ArrayList<Song>();
    int counter = 0;

    public History(){}

    public void addToHistory(Song s){
        hist.add(s);
    }

    public Song getPreviousSong(Song currentSong){
        try{
            Song returnSong = hist.get(counter - 1);
            counter -= 1;

            hist = hist.subList(0, counter);

            return returnSong;
        }catch(Exception e){
            return new Song("Take your breath away","Berlin");
        }
    }
}
