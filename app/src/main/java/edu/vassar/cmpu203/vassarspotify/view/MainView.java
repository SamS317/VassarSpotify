package edu.vassar.cmpu203.vassarspotify.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import edu.vassar.cmpu203.vassarspotify.controller.MainActivity;
import edu.vassar.cmpu203.vassarspotify.databinding.ActivityMainBinding;

public class MainView extends Fragment implements IMainView{
    FragmentManager fmanager;
    ActivityMainBinding binding;
    MainActivity mainActivity;


    /**
     * Provides the listeners for the general home, play, and search buttons
     * @param activity Current activity
     * @param mainActivity Current MainActivity
     */
    public MainView(FragmentActivity activity, MainActivity mainActivity){
        this.fmanager = activity.getSupportFragmentManager();
        this.binding = ActivityMainBinding.inflate(activity.getLayoutInflater());
        this.mainActivity = mainActivity;


        this.binding.displaySearchButton.setOnClickListener(view -> MainView.this.mainActivity.displaySearchFragment());

        this.binding.homeButton.setOnClickListener(view -> MainView.this.mainActivity.displayHomeFragment());

        this.binding.playButtonHome.setOnClickListener(view -> MainView.this.mainActivity.displayPlayFragment());
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.binding = ActivityMainBinding.inflate(inflater);
        return this.binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public View getRootView() { return this.binding.getRoot(); }


    @Override
    public void displayFragment(Fragment fragment, boolean allowBack, String name) {
        FragmentTransaction ft = this.fmanager.beginTransaction();

        ft.replace(this.binding.fragmentContainerView.getId(), fragment);
        if (allowBack) {
            ft.addToBackStack(name);
        }
        ft.commit();
    }


    /**
     * Provides a way to hide the main 3 buttons at the bottom of
     * the screen when we want
     */
    public void ignoreButtons(){
        this.binding.playButtonHome.setVisibility(View.INVISIBLE);
        this.binding.homeButton.setVisibility(View.INVISIBLE);
        this.binding.displaySearchButton.setVisibility(View.INVISIBLE);
    }


    /**
     * Provides a way to bring back the main 3 buttons at the bottom of
     * the screen when we want
     */
    public void showButtons(){
        this.binding.playButtonHome.setVisibility(View.VISIBLE);
        this.binding.homeButton.setVisibility(View.VISIBLE);
        this.binding.displaySearchButton.setVisibility(View.VISIBLE);
    }
}