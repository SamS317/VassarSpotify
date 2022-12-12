package edu.vassar.cmpu203.vassarspotify;
import edu.vassar.cmpu203.vassarspotify.model.Profile;
import edu.vassar.cmpu203.vassarspotify.model.ProfileDatabase;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.List;


public class ProfileDatabaseTest {
    ProfileDatabase pd = new ProfileDatabase();

    @Test
    void testAddProfile(){
        //Tests that the add profile method works and returns the right profile
        Profile p = new Profile("username123","password123");
        assertTrue( pd.addProfile(p) );
        assertEquals(pd.getProfiles().get(0), p);
    }

    @Test
    void testGetProfiles(){
        //Tests that the getProfiles method works and returns the correct profile
        Profile Sam = new Profile("Sam","Super-Genius");
        pd.addProfile(Sam);

        List<Profile> profiles = pd.getProfiles();

        assertEquals(profiles.get(0).toString(), "Sam");
    }
}