package edu.vassar.cmpu203.vassarspotify.view;

import android.view.View;

import java.util.List;

import edu.vassar.cmpu203.vassarspotify.model.Profile;

public interface ILoginFragment {
    public View getRootView();
    public void successfullyLoggedIn(boolean worked);
    interface Listener{
        void LogIn(String username, String password, LoginFragment lfragment);
        void CreateUser(String username, String password, LoginFragment lfragment);
        List<Profile> getProfilesForCreateUser();
    }
}