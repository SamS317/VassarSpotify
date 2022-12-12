package edu.vassar.cmpu203.vassarspotify.model;

import java.util.ArrayList;
import java.util.List;


/**
 * Provides a way to contain the songs to be played next
 * *NOTE* Not fully finished *NOTE*
 */
public class Queue {
    List<Song> queue = new <Song>ArrayList<Song>();

    public Queue(){}

    /**
     * Provides a way to add a song to the database
     * @param s Song to be added
     * @return Returns true always
     */
    public boolean addSong(Song s){
        queue.add(s);
        return true;
    }

    /**
     * Next three methods provide ways to get the next, previous, and current songs
     * @param s Current Song
     * @return Returns the song either next, previous, or currently playing
     */
    public Song getNext(Song s){
        try{
            return queue.get( queue.indexOf(s) + 1);
        } catch(Exception e){
            return s;
        }
    }

    public Song getPrevious(Song s){
        try{
            return queue.get( queue.indexOf(s) - 1);
        } catch(Exception e){
            return s;
        }
    }

    public Song getCurrentSong(){
        try{
            return queue.get(0);
        }catch(Exception e){
            return (new Song("Take my breath away","Berlin"));
        }
    }

    /**
     * Provides a way to clear the queue of all songs
     */
    public void clearQueue(){ queue.clear(); }
}