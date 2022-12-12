package edu.vassar.cmpu203.vassarspotify;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import edu.vassar.cmpu203.vassarspotify.model.Playlist;
import edu.vassar.cmpu203.vassarspotify.model.Song;

public class PlaylistTest {
    Playlist p = new Playlist("TestPlaylist");
    Song s = new Song("Over","Drake");

    @Test
    void testAddSong(){
        //Adds song to the playlist and checks if it was added
        p.addSong(s);
        assertEquals(s, p.getPlaylist().get(0) );
    }

    @Test
    void testGetName(){
        //Tests that the inputted name of the playlist is correct
        assertEquals("TestPlaylist", p.getName());
    }
}
