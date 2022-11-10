package edu.vassar.cmpu203.vassarspotify.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import edu.vassar.cmpu203.vassarspotify.R;
import edu.vassar.cmpu203.vassarspotify.databinding.FragmentSearchFragmentBinding;
import edu.vassar.cmpu203.vassarspotify.model.Song;


public class search_fragment extends Fragment implements IAddItemsView{

    FragmentSearchFragmentBinding binding;
    Listener listener;

    public search_fragment(Listener listener) {
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
                Editable searchTextE = search_fragment.this.binding.searchText.getText();
                String searchText = searchTextE.toString();



                //extract radio buttons checked
                boolean songChoiceBool = search_fragment.this.binding.songChoiceButtonId.isChecked();
                boolean artistChoiceBool = search_fragment.this.binding.artistChoiceButtonId.isChecked();

                //delegate this to controller
                search_fragment.this.listener.searchAdded(searchText, songChoiceBool, artistChoiceBool);

                //clears search
                searchTextE.clear();

            }
        });
    }

    @Override
    public void updateSearchDisplay(List<Song> sList) {
        this.binding.searchText.setText(sList.toString());
        for (Song x: sList){
//            TableRow tableRow = new TableRow(this.tableLayout.getContext());
//            TextView textView = new TextView(tableRow.getContext());
//            textView.setText(x.toString());
//            tableRow.addView(textView);
//            tableLayout.addView(tableRow);
//            this.binding.searchResultTable.addView(tableRow);
        }
    }
}