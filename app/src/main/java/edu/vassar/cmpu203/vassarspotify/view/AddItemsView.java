package edu.vassar.cmpu203.vassarspotify.view;

import android.content.Context;
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
                Snackbar.make(view, "Adding  item! Well, maybe>", Snackbar.LENGTH_LONG).show();
            }
        });

    }
    @Override
    public View getRootView() {

        return this.binding.getRoot();
    }
}
