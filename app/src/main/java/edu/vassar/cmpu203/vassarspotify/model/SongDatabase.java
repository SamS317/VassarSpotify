package edu.vassar.cmpu203.vassarspotify.model;

import java.util.*;

/**
 * Provides a method to contain all songs
 *
 * Later implementations will be able to communicate with a database
 * Later implementations will not have a constructor with pre made songs
 */
public class SongDatabase {

    List<Song> songListReturn = new <Song> ArrayList<Song>();
    List <Song> songList = new <Song> ArrayList<Song>();
    public SongDatabase(){
        songListReturn.clear();
        songList.clear();
        songList.add(new Song("Stronger", "Kanye West"));
        songList.add(new Song("Truth hurts", "Lizzo"));
        songList.add(new Song("Old Town Road", "Lil Nas X"));
        songList.add(new Song("Over", "Drake"));
        songList.add(new Song("Billie Jean", "Michael Jackson"));
        songList.add(new Song("Locked Out of Heaven", "Bruno Mars"));
        songList.add(new Song("Despacito", "Luis Fonsi & Daddy Yankee"));
        songList.add(new Song("Talking to the Moon", "Bruno Mars"));
        songList.add(new Song("Hello", "Adele"));
        songList.add(new Song("Hello", "Eminem"));
        songList.add(new Song("Hello", "Beyonce"));
        songList.add(new Song("Can't Tell Me Nothing", "Kanye West"));
        songList.add(new Song("Leaving West Virginia", "Kathy Mattea"));
        songList.add(new Song("Nez", "Nez"));

    }

    /**
     * Provides a way to search for a song in the current song database
     *
     * This method only returns the songs that match the song title with the input string best
     *
     * Later implementation should possibly combine searchSong and searchArtist
     * @param song The string that will be used to search the database
     * @return Returns a list of songs that matches the input string
     */
    public List<Song> searchSong(String song){
        List <Song> songList = new <Song> ArrayList<Song>();
        for (Song s: this.songList){
            if (s.songName.toUpperCase().contains(song.toUpperCase())){
                songList.add(s);
            }
        }
        return songList;
    }
    public List<Song> searchArtist(String artist){
        List <Song> songList = new <Song> ArrayList<Song>();
        for (Song s: this.songList){
            if (s.artist.toUpperCase().contains(artist.toUpperCase())){
                songList.add(s);
            }
        }
        return songList;
    }

    public Song getSong(String songName, String artistName){
        for(Song s: this.songList){
            if (s.songName.toUpperCase().equals(songName.toUpperCase()) && (s.artist.toUpperCase().equals(artistName.toUpperCase()))){
                return s;
            }
        }
        return new Song("Take my breath away", "Berlin");
    }

    public Song getRandomSong(){
        return new Song("Over","Drake");
    }
}