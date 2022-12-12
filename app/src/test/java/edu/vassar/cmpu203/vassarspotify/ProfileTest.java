package edu.vassar.cmpu203.vassarspotify;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import edu.vassar.cmpu203.vassarspotify.model.Profile;

public class ProfileTest {
    Profile p = new Profile("username123","password123");

    @Test
    void testGetUsernameText(){
        //Tests the getUsernameText method returns the correct username
        assertEquals("username123", p.getUsernameText());
    }

    @Test
    void testCheckLogin(){
        //Tests that the password and username combination matches
        assertTrue(p.checkLogin("username123", "password123"));
    }

    @Test
    void testToString(){
        //Tests the toString method gives back what we want it to
        assertEquals("username123", p.toString());
    }
}