package edu.vassar.cmpu203.vassarspotify;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import edu.vassar.cmpu203.vassarspotify.model.Profile;

public class ProfileTest {
    Profile p = new Profile("username123","password123");

    @Test
    void testLoggingIn(){
        assertTrue(p.checkLogin("username123", "password123"));
    }

    @Test
    void testToString(){
        assertEquals("username123", p.toString());
    }
}