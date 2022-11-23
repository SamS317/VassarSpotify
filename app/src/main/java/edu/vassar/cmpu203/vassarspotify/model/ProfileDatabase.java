package edu.vassar.cmpu203.vassarspotify.model;

import java.util.*;

public class ProfileDatabase {
    List<Profile> profiles = new <Profile> ArrayList<Profile>();

    public ProfileDatabase(){
        profiles.add(new Profile("Connor","Genius") );
    }

    public boolean addProfile (Profile p){
        /**
         * Adds a profile to the current profile database
         * @param p The profile wanting to be added to the profile database
         * @return  Returns true no matter what
         *          (Once database is added we will have to update this
         *          code in order to check if it was really added to the database)
         */
        profiles.add(p);
        return true;
    }
    public List<Profile> getProfiles (){
        return profiles;
    }
}