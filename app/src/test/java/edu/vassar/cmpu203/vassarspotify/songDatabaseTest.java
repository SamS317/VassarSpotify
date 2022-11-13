package edu.vassar.cmpu203.vassarspotify;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.vassar.cmpu203.vassarspotify.model.Song;
import edu.vassar.cmpu203.vassarspotify.model.SongDatabase;

public class songDatabaseTest {
    SongDatabase sb = new SongDatabase();
    Song s = new Song("Over", "Drake");

    @Test
    void testSearchSongName(){
        //This test shows that we can search up the songs name
        assertEquals("Drake", sb.searchSong("Over").get(0).getArtist() );
    }

    @Test
    void testSearchArtistName(){
        //This test shows that we can search up the artists name
        assertEquals("Over", sb.searchArtist("Drake").get(0).getSongName() );
    }

    @Test
    void testSearchSongAndArtistName(){
        //This test shows that we can search for both an artist and a song with one search
        assertEquals("Stronger", sb.searchSongAndArtist("West").get(0).getSongName() );
        assertEquals("Leaving West Virginia", sb.searchSongAndArtist("West").get(2).getSongName() );
    }

    @Test
    void testPlay(){
        assertTrue( sb.play(s) );
    }
}
