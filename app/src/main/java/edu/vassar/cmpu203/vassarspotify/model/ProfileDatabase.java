package edu.vassar.cmpu203.vassarspotify.model;

import java.util.*;

public class ProfileDatabase {
    List profiles = new ArrayList();

    public ProfileDatabase(){
    }
    public boolean addProfile (Profile p){
        profiles.add(p);
        return true;
    }
    public List<Profile> getProfiles (){
        return profiles;
    }


}

