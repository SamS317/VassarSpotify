package edu.vassar.cmpu203.vassarspotify.model;

import java.util.*;

/**
 * Provides a way to organize the profiles in the current database
 * Comes with methods addProfile and getProfiles
 */

public class ProfileDatabase {
    List<Profile> profiles = new <Profile> ArrayList<Profile>();

    /**
     * The ProfileDatabase constructor
     * Creates a new profile with username "Connor" and password "Genius"
     * Will be empty once database is added
     */
    public ProfileDatabase(){
        profiles.add(new Profile("Connor","Genius") );
    }

    /**
     * Provides a method to add a profile to the profile database
     *
     * This method will be more robust once database is added
     * @param p The profile wanting to be added to the profile database
     * @return  Returns true no matter what
     *          (Once database is added we will have to update this code
     *          in order to check if it was really added to the database)
     */
    public boolean addProfile (Profile p){

        profiles.add(p);
        return true;
    }

    /**
     * Provides a method to obtain all of the profiles currently in the profile database
     * @return profiles Returns the profiles in the
     */
    public List<Profile> getProfiles (){
        return profiles;
    }
}