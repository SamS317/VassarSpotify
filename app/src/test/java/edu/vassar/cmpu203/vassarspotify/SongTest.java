package edu.vassar.cmpu203.vassarspotify;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.vassar.cmpu203.vassarspotify.model.Song;

public class SongTest {
    Song s = new Song("Dream On", "Aerosmith");
    Song s2 = new Song("Over", "Drake");
    Song s3 = new Song("8 Mile", "Eminem");

    @Test
    void testGetSongName(){
        //Tests the getSongName method
        //Should return the name of the songs of the songs stated above
        assertEquals("Dream On", s.getSongName());
        assertEquals("Over", s2.getSongName());
        assertEquals("8 Mile", s3.getSongName());
    }

    @Test
    void testGetArtist(){
        //Tests the getArtist method
        //Should return the name of the artist of the songs stated above
        assertEquals("Aerosmith", s.getArtist());
        assertEquals("Drake", s2.getArtist());
        assertEquals("Eminem", s3.getArtist());
    }

    @Test
    void testToString(){
        //Tests the toString method returns what we want it to
        assertEquals("Dream On by Aerosmith", s.toString());
        assertEquals("Over by Drake", s2.toString());
        assertEquals("8 Mile by Eminem", s3.toString());
    }
}
