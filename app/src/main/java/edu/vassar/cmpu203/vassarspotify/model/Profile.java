package edu.vassar.cmpu203.vassarspotify.model;

import androidx.annotation.NonNull;

/**
 * Provides a way to represent a user through a profile
 */
public class Profile {
    String username;
    String password;

    /**
     * Provides a way to make a profile with all contained information
     * @param username The name the user wants the profile to have
     * @param password The password the user wants the profile to have
     */
    public Profile (String username, String password){
        this.username = username;
        this.password = password;
    }

    /**
     * Constructor of Profile
     */
    public  Profile (){}
    public String getUsernameText(){
        return this.username;
    }

    /**
     * Provides a method of checking if the username and password matches profiles username and password
     * @param username The usernames' name to be checked against the profiles username
     * @param password The usernames' password to be checked against the profiles password
     * @return boolean
     */
    public boolean checkLogin(String username, String password){
        return this.username.equalsIgnoreCase(username) && this.password.equals(password) ;
    }

    /**
     * Provides a way to get the string representation of the username
     * @return String Returns the username as a string
     */
    @NonNull
    public String toString(){
        return "" + this.username;
    }
}