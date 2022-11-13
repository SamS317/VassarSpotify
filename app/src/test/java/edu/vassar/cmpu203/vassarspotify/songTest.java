package edu.vassar.cmpu203.vassarspotify;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.vassar.cmpu203.vassarspotify.model.Song;

public class songTest {
    Song s = new Song("Dream On", "Aerosmith");

    @Test
    void testSongName(){
        assertEquals("Dream On", s.getSongName());
    }

    @Test
    void testArtistName(){
        assertEquals("Aerosmith", s.getArtist());
    }

    @Test
    void testToString(){
        assertEquals("Dream On by Aerosmith", s.toString());
    }
}
