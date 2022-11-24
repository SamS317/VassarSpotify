package edu.vassar.cmpu203.vassarspotify;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import edu.vassar.cmpu203.vassarspotify.model.Profile;
import edu.vassar.cmpu203.vassarspotify.model.ProfileDatabase;

public class ProfileDatabaseTest {
    ProfileDatabase pd = new ProfileDatabase();

    @Test
    void testAddProfile(){
        Profile p = new Profile("username123","password123");
        assertTrue( pd.addProfile(p) );
        assertEquals(pd.getProfiles().get(1), p);
    }

    @Test
    void testGetProfiles(){
        Profile Sam = new Profile("Sam","Super-Genius");
        pd.addProfile(Sam);

        List<Profile> profiles = pd.getProfiles();

        assertEquals(profiles.get(1).toString(), "Sam");
    }
}