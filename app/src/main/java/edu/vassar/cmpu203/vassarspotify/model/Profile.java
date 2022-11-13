package edu.vassar.cmpu203.vassarspotify.model;

public class Profile {
    String username;
    String password;
    public Profile (String username, String password){
        this.username = username;
        this.password = password;
    }
    public  Profile (){

    }
    public String getUsername(){
        return this.username;
    }
    public boolean checkLogin(String username, String password){

        return this.username.toLowerCase().equals(username.toLowerCase()) && this.password.equals(password) ;

    }

    public String toString(){
        return "" + this.username;
    }

}



