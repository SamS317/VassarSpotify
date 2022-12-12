package edu.vassar.cmpu203.vassarspotify.view;

import android.view.View;

import androidx.fragment.app.Fragment;

public interface IMainView {
    View getRootView();

    void displayFragment(Fragment fragment, boolean allowBack, String name);
    void ignoreButtons();
    void showButtons();
    interface Listener{
        void displaySearchFragment();
        void displayPlayFragment();
        void displayHomeFragment();
    }
}