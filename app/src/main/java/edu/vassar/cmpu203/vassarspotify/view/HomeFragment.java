package edu.vassar.cmpu203.vassarspotify.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import edu.vassar.cmpu203.vassarspotify.databinding.FragmentHomeBinding;
import edu.vassar.cmpu203.vassarspotify.model.Playlist;

public class HomeFragment extends Fragment implements IHomeFragment{

    HomeFragment HFragment;
    FragmentHomeBinding binding;
    Listener listener;

    public HomeFragment(Listener listener){this.listener = listener;}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.binding = FragmentHomeBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.binding.addPlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String playlistName = HomeFragment.this.binding.playListName.getText().toString();
                HomeFragment.this.listener.addPlaylist(playlistName);
                HomeFragment.this.listener.displayHomeFragment();

            }
        });
        this.binding.logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeFragment.this.listener.logOut();
            }
        });
        this.binding.usernameHome.setText(HomeFragment.this.listener.getUsername());
        TableLayout t1 = HomeFragment.this.binding.playListTable;
        t1.removeAllViews();
        for (Playlist p: HomeFragment.this.listener.getPlaylists() ){

            TableRow row = new TableRow(HomeFragment.this.getContext());
            Button playlistButton = new Button(HomeFragment.this.getContext());
            playlistButton.setText(HomeFragment.this.listener.getPlaylistName(p));

            row.addView(playlistButton);
            t1.addView(row);
            playlistButton.setOnClickListener(v -> HomeFragment.this.listener.displayPlaylistFragment(HomeFragment.this.listener.getPlaylistName(p)));
        }

    }
}