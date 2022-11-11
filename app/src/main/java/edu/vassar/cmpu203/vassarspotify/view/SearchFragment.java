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
import android.widget.TextView;

import java.util.List;

import edu.vassar.cmpu203.vassarspotify.databinding.FragmentSearchFragmentBinding;
import edu.vassar.cmpu203.vassarspotify.model.Song;


public class SearchFragment extends Fragment implements ISearchFragment{

    FragmentSearchFragmentBinding binding;
    Listener listener;

    public SearchFragment(Listener listener) {
        this.listener = listener;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
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
    }

    @Override
    public View getRootView() {
        return this.binding.getRoot();
    }



    @Override
    public void updateSearchDisplay(List<Song> sList) {
//        this.binding.searchText.setText(sList.toString());
        TableLayout tl = SearchFragment.this.binding.searchResultTable;
        tl.removeAllViews();
        for (Song x: sList){
            TableRow row = new TableRow(SearchFragment.this.getContext());
            TextView tv1 = new TextView(SearchFragment.this.getContext());
            TextView tv2 = new TextView(SearchFragment.this.getContext());
//            TextView tv3 = new TextView(SearchFragment.this.getContext());
//            TextView tv4 = new TextView(SearchFragment.this.getContext());
//            TextView tv5 = new TextView(SearchFragment.this.getContext());
            Button play = new Button(SearchFragment.this.getContext());
            Button queue = new Button(SearchFragment.this.getContext());
            Button playlist = new Button(SearchFragment.this.getContext());

            play.setText("play");
            queue.setText("Queue");
            playlist.setText("Playlist");
            tv1.setText(x.getSongName());
            tv2.setText(x.getArtist());

            row.addView(tv1);
            row.addView(tv2);
            row.addView(play);
            row.addView(queue);
            row.addView(playlist);

            tl.addView(row);

//            TableRow tableRow = new TableRow(this.tableLayout.getContext());
//            TextView textView = new TextView(tableRow.getContext());
//            textView.setText(x.toString());
//            tableRow.addView(textView);
//            tableLayout.addView(tableRow);
//            this.binding.searchResultTable.addView(tableRow);
        }
    }
}