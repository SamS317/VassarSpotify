package edu.vassar.cmpu203.vassarspotify.model;

import androidx.annotation.NonNull;

import java.util.Objects;

public class Song {
    public String songName;
    public String artist;

    public Song(String songName, String artist) {
        this.songName = songName;
        this.artist = artist;
    }
    public String getSongName (){
        return this.songName;
    }

    public String getArtist(){
        return this.artist;
    }

    @NonNull
    @Override
    public String toString() {
        return this.songName + " by " + this.artist;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if( o == null || getClass() != o.getClass()) return false;
        return (Objects.equals(this.songName, ((Song) o).getSongName())) && (Objects.equals(this.artist, ((Song) o).getArtist()));
    }
}