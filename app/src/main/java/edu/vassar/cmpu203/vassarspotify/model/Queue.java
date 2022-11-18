package edu.vassar.cmpu203.vassarspotify.model;

import java.util.ArrayList;
import java.util.List;

public class Queue {
    List<Song> queue = new <Song>ArrayList<Song>();

    public Queue(){}

    public boolean addSong(Song s){
        queue.add(s);
        return true;
    }

    public Song getNext(Song s){
        try{
            Song returnSong = queue.get( queue.indexOf(s) + 1);
            removeFromQueue(s);
            return returnSong;
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

    public void removeFromQueue(Song s){
        try{
            queue.remove( queue.get( queue.indexOf(s)) );
        } catch(Exception ignored){}
    }
}