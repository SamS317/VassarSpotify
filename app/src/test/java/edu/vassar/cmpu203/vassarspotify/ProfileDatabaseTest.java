package edu.vassar.cmpu203.vassarspotify;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.vassar.cmpu203.vassarspotify.model.Profile;
import edu.vassar.cmpu203.vassarspotify.model.ProfileDatabase;

public class ProfileDatabaseTest {
    ProfileDatabase pd = new ProfileDatabase();

    @Test
    void testAddProfile(){
        Profile p = new Profile("username123","password123");
        assertTrue( pd.addProfile(p) );
        assertEquals(pd.getProfiles().get(0), p);
    }
}
