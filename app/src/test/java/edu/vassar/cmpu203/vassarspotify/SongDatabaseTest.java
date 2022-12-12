package edu.vassar.cmpu203.vassarspotify;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.vassar.cmpu203.vassarspotify.model.Song;
import edu.vassar.cmpu203.vassarspotify.model.SongDatabase;

public class SongDatabaseTest {
    SongDatabase sd = new SongDatabase();
    Song s = new Song("Over", "Drake");
    Song s2 = new Song("Stronger", "Kanye West");

    @Test
    void testSearchSongName(){
        //This test shows that we can search up the songs name
        assertEquals("Drake", sd.searchSong("Over").get(0).getArtist() );
        assertEquals("Kanye West", sd.searchSong("Stronger").get(0).getArtist() );
    }

    @Test
    void testSearchArtistName(){
        //This test shows that we can search up the artists name
        assertEquals("Over", sd.searchArtist("Drake").get(0).getSongName() );
        assertEquals("Stronger", sd.searchArtist("Kanye").get(0).getSongName() );
    }

    @Test
    void testgetRaddress(){
        //Tests if an inputted song points to the right place in memory
        //Disregards capitalization or missing letters
        assertEquals(2131689483, sd.getRaddress("Over", "Drake"));
        assertEquals(2131689483, sd.getRaddress("er", "drake"));
        assertEquals(2131689483, sd.getRaddress("", "drake"));
    }

    @Test
    void testGetRData(){
        //The numbers are the locations of the song data in the raw file
        //Checking if the right song points to the right place in memory
        assertEquals(2131689483, sd.getRData("over drake") );
        assertEquals(2131689481, sd.getRData("locked out of heaven bruno mars") );
    }

    @Test
    void testGetSong(){
        //Tests GetSong method returns a song
        assertEquals(s, sd.getSong("Over", "Drake"));
        assertEquals(s2, sd.getSong("Stronger", "Kanye West"));
    }

    @Test
    void testGetRandomSong(){
        //Tests that the GetRandomSong method returns "Over by Drake"
        //Test will be useless once randomness is added in
        //Currently only gives back "Over by Drake"
        assertEquals(s, sd.getRandomSong());
    }

    @Test
    void testGetString(){
        //Tests GetString method
        //Inputs a song and returns a conjoined form of the song in lower case
        assertEquals("kanyeweststronger", sd.getString("Stronger", "Kanye West"));
        assertEquals("overdrake", sd.getString("Over", "Drake"));
    }
}