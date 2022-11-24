package edu.vassar.cmpu203.vassarspotify.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.List;

import edu.vassar.cmpu203.vassarspotify.databinding.FragmentSearchFragmentBinding;
import edu.vassar.cmpu203.vassarspotify.model.Song;


public class SearchFragment extends Fragment implements ISearchFragment{

    PlayScreenFragment PSFragment;
    FragmentSearchFragmentBinding binding;
    Listener listener;

    public SearchFragment(Listener listener) {
        this.listener = listener;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.binding = FragmentSearchFragmentBinding.inflate(inflater);
        return this.binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.binding.searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //extract searchText
                Editable searchTextE = SearchFragment.this.binding.searchText.getText();
                String searchText = searchTextE.toString();

                //extract radio buttons checked
                boolean songChoiceBool = SearchFragment.this.binding.songChoiceButtonId.isChecked();
                boolean artistChoiceBool = SearchFragment.this.binding.artistChoiceButtonId.isChecked();

                //delegate this to controller
                SearchFragment.this.listener.searchAdded(searchText, songChoiceBool, artistChoiceBool, SearchFragment.this);

                //clears search
                searchTextE.clear();

            }
        });

        this.binding.changeToPlayScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Delegate this to controller
                SearchFragment.this.listener.changeFromSearchToPlay(SearchFragment.this);
            }
        });

    }

    @Override
    public View getRootView() {
        return this.binding.getRoot();
    }


    @Override
    public void updateSearchDisplay(List<Song> sList) {
        TableLayout tl = SearchFragment.this.binding.searchResultTable;
        tl.removeAllViews();
        for (Song x: sList){
            TableRow row = new TableRow(SearchFragment.this.getContext());
            Button play = new Button(SearchFragment.this.getContext());
            Button queue = new Button(SearchFragment.this.getContext());
            Button playlist = new Button(SearchFragment.this.getContext());

            play.setText(String.format("%s\n%s", x.getSongName(), x.getArtist()));
            queue.setText("Add to\nQueue");
            playlist.setText("Add to\nPlaylist");

            row.addView(play);
            row.addView(queue);
            row.addView(playlist);

            tl.addView(row);

            //Adds listener to Play button
            play.setOnClickListener(v -> SearchFragment.this.listener.changePlayScreenWSong(x, SearchFragment.this));

            //Adds listener to Queue button
            queue.setOnClickListener(v -> SearchFragment.this.listener.addSongToQueue(x));

            //Adds listener to Playlist button (implement later)
            //queue.setOnClickListener(v -> SearchFragment.this.listener.addSongToPlaylist(x));
        }
    }
}