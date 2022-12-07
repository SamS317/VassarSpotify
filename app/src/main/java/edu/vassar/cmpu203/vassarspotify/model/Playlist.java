package edu.vassar.cmpu203.vassarspotify.model;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    List<Song> playlist = new <Song>ArrayList<Song>();

    public Playlist(){}

    public boolean addSong(Song s){
        playlist.add(s);
        return true;
    }
    public Song getNext(Song s){
        try{
            Song returnSong = playlist.get( playlist.indexOf(s) + 1);
            //removeFromQueue(s);
            return returnSong;
        } catch(Exception e){
            return s;
        }
    }
    public Song getPrevious(Song s){
        try{
            Song returnSong = playlist.get( playlist.indexOf(s) - 1);
            //removeFromQueue(s);
            return returnSong;
        } catch(Exception e){
            return s;
        }
    }
    public Song getCurrentSong(){
        try{
            return playlist.get(0);
        }catch(Exception e){
            return (new Song("Take my breath away","Berlin"));
        }
    }
    public void clearPlaylist(){playlist.clear();}

    public void removeFromPlaylist(Song s){
        try {
//            playlist.remove(playlist.get(playlist.indexOf(s)));
            playlist.remove(s);
        }catch (Exception ignored){}
    }
}
