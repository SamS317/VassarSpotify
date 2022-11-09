package edu.vassar.cmpu203.vassarspotify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.vassar.cmpu203.vassarspotify.view.AddItemsView;
import edu.vassar.cmpu203.vassarspotify.view.IAddItemsView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        IAddItemsView addItemsView = new AddItemsView(getApplicationContext());

        setContentView(addItemsView.getRootView());
    }
}