package edu.vassar.cmpu203.vassarspotify.model;

import java.util.ArrayList;
import java.util.List;

public class Queue {
    List<Song> queue = new <Song>ArrayList<Song>();
    int counter = 0;

    public Queue(){}

    public boolean addSong(Song s){
        queue.add(s);
        return true;
    }

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

    public void clearQueue(){
        queue.clear();
    }
}