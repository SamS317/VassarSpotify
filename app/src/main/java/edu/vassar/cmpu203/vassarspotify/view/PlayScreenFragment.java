package edu.vassar.cmpu203.vassarspotify.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.vassar.cmpu203.vassarspotify.R;
import edu.vassar.cmpu203.vassarspotify.controller.MainActivity;
import edu.vassar.cmpu203.vassarspotify.databinding.FragmentPlayScreenBinding;
import edu.vassar.cmpu203.vassarspotify.model.Song;


public class PlayScreenFragment extends Fragment implements IPlayScreenFragment{

    FragmentPlayScreenBinding binding;
    Listener listener;

    public PlayScreenFragment(Listener listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_play_screen, container, false);
    }

    public Song getSongFromScreen(){
        Editable songNameText = (Editable) PlayScreenFragment.this.binding.songNamePS.getText();
        String songNameString = songNameText.toString();

        Editable artistNameText = (Editable) PlayScreenFragment.this.binding.artistNamePS.getText();
        String artistNameString = artistNameText.toString();

        return PlayScreenFragment.this.listener.getSongFromModel(songNameString, artistNameString);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Play and pause button
        this.binding.playbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable songNameText = (Editable) PlayScreenFragment.this.binding.songNamePS.getText();
                String songNameString = songNameText.toString();

                Editable artistNameText = (Editable) PlayScreenFragment.this.binding.artistNamePS.getText();
                String artistNameString = artistNameText.toString();
                Song s = PlayScreenFragment.this.listener.getSongFromModel(songNameString, artistNameString);

                PlayScreenFragment.this.listener.playMusic(s);
            }
        });

        //Replay last played song button
        this.binding.replayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable songNameText = (Editable) PlayScreenFragment.this.binding.songNamePS.getText();
                String songNameString = songNameText.toString();

                Editable artistNameText = (Editable) PlayScreenFragment.this.binding.artistNamePS.getText();
                String artistNameString = artistNameText.toString();
                Song s = PlayScreenFragment.this.listener.getSongFromModel(songNameString, artistNameString);

                PlayScreenFragment.this.listener.previousSong(s);
            }
        });

        //Skip song button
        this.binding.skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable songNameText = (Editable) PlayScreenFragment.this.binding.songNamePS.getText();
                String songNameString = songNameText.toString();

                Editable artistNameText = (Editable) PlayScreenFragment.this.binding.artistNamePS.getText();
                String artistNameString = artistNameText.toString();
                Song s = PlayScreenFragment.this.listener.getSongFromModel(songNameString, artistNameString);

                PlayScreenFragment.this.listener.nextSong(s);
            }
        });


    }
}