package edu.vassar.cmpu203.vassarspotify.view;

import android.content.Context;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.google.android.material.snackbar.Snackbar;

import edu.vassar.cmpu203.vassarspotify.databinding.ActivityMainBinding;
import edu.vassar.cmpu203.vassarspotify.model.SongDatabase;

public class AddItemsView implements  IAddItemsView{

    ActivityMainBinding binding;


    Listener listener;
    TableLayout tableLayout;

    public AddItemsView(Context context, Listener listener){
        this.listener = listener;
        this.binding = ActivityMainBinding.inflate(LayoutInflater.from(context));

        this.binding.searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //extract searchText
                Editable searchTextE = AddItemsView.this.binding.searchText.getText();
                String searchText = searchTextE.toString();



                //extract radio buttons checked
                boolean songChoiceBool = AddItemsView.this.binding.songChoiceButtonId.isChecked();
                boolean artistChoiceBool = AddItemsView.this.binding.artistChoiceButtonId.isChecked();

                //delegate this to controller
                AddItemsView.this.listener.searchAdded(searchText, songChoiceBool, artistChoiceBool);

            }
        });

    }
    @Override
    public View getRootView() {

        return this.binding.getRoot();
    }

    @Override
    public void updateSearchDisplay(SongDatabase s) {
        this.binding.searchText.setText(s.toString());

    }
}
