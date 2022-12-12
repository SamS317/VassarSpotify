package edu.vassar.cmpu203.vassarspotify.view;

import android.annotation.SuppressLint;
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

import edu.vassar.cmpu203.vassarspotify.databinding.FragmentPlaylistBinding;
import edu.vassar.cmpu203.vassarspotify.model.Playlist;
import edu.vassar.cmpu203.vassarspotify.model.Song;


/**
 * Provides an implementation that lets us hold playlists
 */
public class PlaylistFragment extends Fragment implements IPlaylistFragment {
    FragmentPlaylistBinding binding;
    Listener listener;
    Playlist playlist;


    public PlaylistFragment(Listener listener, Playlist playlist ){
        this.listener=listener;
        this.playlist = playlist;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.binding = FragmentPlaylistBinding.inflate(inflater);
        return this.binding.getRoot();
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        //Implement at a later date
        this.binding.editButton.setOnClickListener(view1 -> {});


        this.binding.playlistName2.setText(PlaylistFragment.this.listener.getGivenPlaylistName(playlist));
        TableLayout t1 = PlaylistFragment.this.binding.playlistTable2;
        t1.removeAllViews();
        for (Song s: PlaylistFragment.this.listener.getCurrentPlaylist(PlaylistFragment.this.listener.getGivenPlaylistName(playlist))){
            TableRow row = new TableRow(PlaylistFragment.this.getContext());
            Button play = new Button(PlaylistFragment.this.getContext());
            Button delete = new Button(PlaylistFragment.this.getContext());
            Button queue = new Button(PlaylistFragment.this.getContext());

            play.setText(String.format("%s\n%s", s.getSongName(), s.getArtist()));
            queue.setText("Add to\nQueue");
            delete.setText("Delete");

            row.addView(play);
            row.addView(queue);
            row.addView(delete);

            t1.addView(row);

            play.setOnClickListener(v -> PlaylistFragment.this.listener.displayPlayFromPlaylist(s));

            queue.setOnClickListener(v -> PlaylistFragment.this.listener.addSongToQueue(s));

//            delete.setOnClickListener(v -> PlaylistFragment.this.listener.deleteSong(s));
        }
    }
}