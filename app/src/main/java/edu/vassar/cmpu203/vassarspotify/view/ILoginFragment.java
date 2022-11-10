package edu.vassar.cmpu203.vassarspotify.view;

import android.view.View;

public interface ILoginFragment {
    public View getRootView();

    interface Listener{
        void LogIn(String usernname, String password);
        void CreateUser(String usernname, String password);
    }
}
