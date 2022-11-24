package edu.vassar.cmpu203.vassarspotify.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.vassar.cmpu203.vassarspotify.databinding.FragmentPlayScreenBinding;
import edu.vassar.cmpu203.vassarspotify.model.Song;


public class PlayScreenFragment extends Fragment implements IPlayScreenFragment{

    FragmentPlayScreenBinding binding;
    Listener listener;

    public PlayScreenFragment(Listener listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.binding = FragmentPlayScreenBinding.inflate(inflater);
        return this.binding.getRoot();
    }


    public Song getSongFromScreen(){
        String songNameString  = (PlayScreenFragment.this.binding.songNamePS.getText()).toString();
        String artistNameString = (PlayScreenFragment.this.binding.artistNamePS.getText()).toString();

        return PlayScreenFragment.this.listener.getSongFromSongDatabase(songNameString, artistNameString);
    }


    public void changeTextValues(Song s){
        PlayScreenFragment.this.binding.songNamePS.setText(s.getSongName());
        PlayScreenFragment.this.binding.artistNamePS.setText(s.getArtist());
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Song s = PlayScreenFragment.this.listener.getCurrentSong();
        PlayScreenFragment.this.binding.songNamePS.setText(s.getSongName());
        PlayScreenFragment.this.binding.artistNamePS.setText(s.getArtist());

        //Play and pause button
        this.binding.playbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String songNameString  = (PlayScreenFragment.this.binding.songNamePS.getText()).toString();
                String artistNameString = (PlayScreenFragment.this.binding.artistNamePS.getText()).toString();

                Song s = PlayScreenFragment.this.listener.getSongFromSongDatabase(songNameString, artistNameString);

                PlayScreenFragment.this.listener.playPauseGivenSong(PlayScreenFragment.this.getContext(), s);

                changeTextValues(s);

                if( PlayScreenFragment.this.listener.isSongPlaying() ){
                    PlayScreenFragment.this.binding.playbackButton.setText("Pause");
                }else{
                    PlayScreenFragment.this.binding.playbackButton.setText("Play");
                }


                PlayScreenFragment.this.listener.playMusic(s);
            }
        });

        //Replay last played song button
        this.binding.replayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String songNameString  = (PlayScreenFragment.this.binding.songNamePS.getText()).toString();
                String artistNameString = (PlayScreenFragment.this.binding.artistNamePS.getText()).toString();

                Song s = PlayScreenFragment.this.listener.getSongFromSongDatabase(songNameString, artistNameString);

                PlayScreenFragment.this.listener.previousSong(s);
            }
        });

        //Skip song button
        this.binding.skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String songNameString  = (PlayScreenFragment.this.binding.songNamePS.getText()).toString();
                String artistNameString = (PlayScreenFragment.this.binding.artistNamePS.getText()).toString();

                Song s = PlayScreenFragment.this.listener.getSongFromSongDatabase(songNameString, artistNameString);

                Song sNext = PlayScreenFragment.this.listener.nextSong(s);

                PlayScreenFragment.this.binding.songNamePS.setText(sNext.getSongName());
                PlayScreenFragment.this.binding.artistNamePS.setText(sNext.getArtist());
            }
        });

        //Skip song button
        this.binding.toSearchScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlayScreenFragment.this.listener.changeToSearchScreen(PlayScreenFragment.this);
            }
        });
    }
}