package edu.vassar.cmpu203.vassarspotify.model;

import java.util.*;

public class ProfileDatabase {
    List<Profile> profiles = new <Profile> ArrayList<Profile>();

    public ProfileDatabase(){
        profiles.add(new Profile("Connor","Genius") );
    }

    public boolean addProfile (Profile p){
        profiles.add(p);
        return true;
    }
    public List<Profile> getProfiles (){
        return profiles;
    }


}