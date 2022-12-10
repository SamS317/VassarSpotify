package edu.vassar.cmpu203.vassarspotify.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.Objects;

import edu.vassar.cmpu203.vassarspotify.R;
import edu.vassar.cmpu203.vassarspotify.databinding.FragmentListPlaylistBinding;
import edu.vassar.cmpu203.vassarspotify.model.Playlist;
import edu.vassar.cmpu203.vassarspotify.model.Song;


public class ListPlaylistFragment extends Fragment implements IListPlaylistFragment{

   FragmentListPlaylistBinding binding;
   Listener listener;
    boolean hold = false;
    Song song = null;

   public ListPlaylistFragment(Listener listener, Song s){
       this.listener=listener;
       this.song = s;
   }

    public ListPlaylistFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.binding = FragmentListPlaylistBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        choosePlaylist();

    }
    public void choosePlaylist(){

        TableLayout t1 = ListPlaylistFragment.this.binding.listPlaylistTable;
        t1.removeAllViews();
        for (Playlist p: ListPlaylistFragment.this.listener.getPlaylists()){
            TableRow row = new TableRow(ListPlaylistFragment.this.getContext());
            Button playlistButton = new Button(ListPlaylistFragment.this.getContext());
            if (!Objects.equals(p.getName(), "")) {
                playlistButton.setText(p.getName());

                row.addView(playlistButton);

                t1.addView(row);
            }

            playlistButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ListPlaylistFragment.this.listener.addToPlaylist(p, song);
                    hold = true;
                    ListPlaylistFragment.this.listener.displaySearchFragment();
                }
            });
            if (hold){

                break;
            }
        }
    }
}