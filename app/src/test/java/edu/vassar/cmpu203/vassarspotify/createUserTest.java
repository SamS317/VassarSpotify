package edu.vassar.cmpu203.vassarspotify;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import edu.vassar.cmpu203.vassarspotify.model.Profile;

public class createUser {
    Profile p = new Profile("username123","password123");

    @Test
    void testUsername(){
        assertEquals("username123", p.getUsername());
    }

    @Test
    void testLoggingIn(){
        assertTrue(p.checkLogin("username123", "password123"));
    }

    @Test
    void testToString(){
        assertEquals("username123", p.toString());
    }
}