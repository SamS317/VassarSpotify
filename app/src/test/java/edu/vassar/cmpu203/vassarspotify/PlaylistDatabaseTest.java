package edu.vassar.cmpu203.vassarspotify;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import edu.vassar.cmpu203.vassarspotify.model.Playlist;
import edu.vassar.cmpu203.vassarspotify.model.PlaylistDatabase;

public class PlaylistDatabaseTest {
    PlaylistDatabase pd = new PlaylistDatabase();
    Playlist p = new Playlist("TestPlaylist");

    @Test
    void testAddPlaylist(){
        //Tests the addition of a playlist actually adds a playlist
        //Simultaneously tests getPlaylists method
        pd.addPlaylist(p);
        assertEquals(p, pd.getPlaylists().get(0));

        pd.addPlaylist(p);
        assertEquals(p, pd.getPlaylists().get(1));
    }
}