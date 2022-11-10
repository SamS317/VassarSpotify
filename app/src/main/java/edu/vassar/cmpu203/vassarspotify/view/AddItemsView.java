package edu.vassar.cmpu203.vassarspotify.view;

import android.content.Context;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import edu.vassar.cmpu203.vassarspotify.databinding.ActivityMainBinding;

public class AddItemsView implements  IAddItemsView{

    ActivityMainBinding binding;


    public AddItemsView(Context context){
        this.binding = ActivityMainBinding.inflate(LayoutInflater.from(context));

        this.binding.searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //extract searchText
                Editable searchTextE = AddItemsView.this.binding.searchText.getText();
                String searchText = searchTextE.toString();



//                Boolean songChoiceBool = AddItemsView.this.binding.songChoiceButtonId.callOnClick();
//                System.out.println(songChoiceBool);

                //Snackbar.make(view, "Adding  item! Well, maybe>", Snackbar.LENGTH_LONG).show();
            }
        });

    }
    @Override
    public View getRootView() {

        return this.binding.getRoot();
    }
}
