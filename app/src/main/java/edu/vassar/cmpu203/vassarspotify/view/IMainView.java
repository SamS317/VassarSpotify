package edu.vassar.cmpu203.vassarspotify.view;

import android.view.View;

import androidx.fragment.app.Fragment;

public interface IMainView {
    public View getRootView();

    public void displayFragment(Fragment fragment, boolean allowBack, String name);
    public void ignoreButtons();
    public void showButtons();
    interface Listener{
        void displaySearchFragment();
        void displayPlayFragment();
        void displayHomeFragment();
    }
}