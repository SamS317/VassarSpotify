package edu.vassar.cmpu203.vassarspotify.model;

import androidx.annotation.NonNull;

public class Profile {
    String username;
    String password;
    public Profile (String username, String password){
        this.username = username;
        this.password = password;
    }
    public  Profile (){}

    public String getUsername(){
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