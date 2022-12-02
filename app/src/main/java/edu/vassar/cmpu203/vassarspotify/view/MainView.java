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
import edu.vassar.cmpu203.vassarspotify.databinding.FragmentLoginFragmentBinding;

public class MainView extends Fragment implements IMainView{

    FragmentManager fmanager;

    ActivityMainBinding binding;
    Listener listener;

    public MainView(FragmentActivity activity){
        this.fmanager = activity.getSupportFragmentManager();
        this.binding = ActivityMainBinding.inflate(activity.getLayoutInflater());

    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.binding = ActivityMainBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.binding.searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainView.this.listener.displaySearchFragment();
            }
        });
        this.binding.homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainView.this.listener.displayHomeFragment();
            }
        });
        this.binding.playButtonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainView.this.listener.displayPlayFragment();
            }
        });

    }

    @Override
    public View getRootView() {
        return this.binding.getRoot();
    }

    @Override
    public void displayFragment(Fragment fragment, boolean allowBack, String name) {
        FragmentTransaction ft = this.fmanager.beginTransaction();

        ft.replace(this.binding.fragmentContainerView.getId(), fragment);
        if (allowBack) {
            ft.addToBackStack(name);
        }
        ft.commit();
    }
    public void ignoreButtons(){
        this.binding.playButtonHome.setVisibility(View.INVISIBLE);
        this.binding.homeButton.setVisibility(View.INVISIBLE);
        this.binding.searchButton.setVisibility(View.INVISIBLE);
    }
    public void showButtons(){
        this.binding.playButtonHome.setVisibility(View.VISIBLE);
        this.binding.homeButton.setVisibility(View.VISIBLE);
        this.binding.searchButton.setVisibility(View.VISIBLE);
    }
}