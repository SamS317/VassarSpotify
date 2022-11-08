package edu.vassar.cmpu203.vassarspotify.model;

public class Song {
    public String songName;
    public String artist;

    public Song(String songName, String artist) {
        this.songName = songName;
        this.artist = artist;
    }

    @Override
    public String toString() {
        return this.songName + " by " + this.artist;
    }
}
