package edu.vassar.cmpu203.vassarspotify.view;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Objects;

import edu.vassar.cmpu203.vassarspotify.R;
import edu.vassar.cmpu203.vassarspotify.databinding.FragmentPlayScreenBinding;
import edu.vassar.cmpu203.vassarspotify.model.Song;


public class PlayScreenFragment extends Fragment implements IPlayScreenFragment{

    FragmentPlayScreenBinding binding;
    Listener listener;
    ImageView albumCover;
    //ImageView albumCover = new ImageView(PlayScreenFragment.this.getContext());



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
                albumCover = requireView().findViewById(R.id.imageView);
                albumCover.setImageResource((Integer) returnDrawableID(PlayScreenFragment.this.listener.getRightText(s.getSongName(), s.getArtist())));
                if( PlayScreenFragment.this.listener.isSongPlaying() ){
                    PlayScreenFragment.this.binding.playbackButton.setText("Pause");
                }else{
                    PlayScreenFragment.this.binding.playbackButton.setText("Play");
                }

            }
        });

        //Replay last played song button
        this.binding.replayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String songNameString  = (PlayScreenFragment.this.binding.songNamePS.getText()).toString();
                String artistNameString = (PlayScreenFragment.this.binding.artistNamePS.getText()).toString();

                Song s = PlayScreenFragment.this.listener.getSongFromSongDatabase(songNameString, artistNameString);

                Song prevSong = PlayScreenFragment.this.listener.previousSong(s);

                albumCover = requireView().findViewById(R.id.imageView);
                albumCover.setImageResource((Integer) returnDrawableID(PlayScreenFragment.this.listener.getRightText(prevSong.getSongName(), prevSong.getArtist())));

                PlayScreenFragment.this.binding.songNamePS.setText(prevSong.getSongName());
                PlayScreenFragment.this.binding.artistNamePS.setText(prevSong.getArtist());
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

                albumCover = requireView().findViewById(R.id.imageView);
                albumCover.setImageResource((Integer) returnDrawableID(PlayScreenFragment.this.listener.getRightText(sNext.getSongName(), sNext.getArtist())));

                PlayScreenFragment.this.binding.songNamePS.setText(sNext.getSongName());
                PlayScreenFragment.this.binding.artistNamePS.setText(sNext.getArtist());
            }
        });

    }

    public Object returnDrawableID(String name){
        if (name.equals("billiejeanmichaeljackson")){
            return R.drawable.billiejeanmichaeljackson;
        }
        else if (name.equals("canttellmeanythingkanyewest")){
            return R.drawable.canttellmeanythingkanyewest;
        }
        else if (name.equals("despacitoluisfonsidaddyyankee")){
            return R.drawable.despacitoluisfonsidaddyyankee;
        }
        else if (name.equals("halobeyonce")){
            return R.drawable.halobeyonce;
        }
        else if (name.equals("helloadele")){
            return R.drawable.helloadele;
        }
        else if (name.equals("helloeminem")){
            return R.drawable.helloeminem;
        }
        else if (name.equals("kanyeweststronger")){
            return R.drawable.kanyeweststronger;
        }
        else if (name.equals("leavingwestvirginialathymattea")){
            return R.drawable.leavingwestvirginialathymattea;
        }
        else if (name.equals("lockedoutofheavenbrunomars")){
            return R.drawable.lockedoutofheavenbrunomars;
        }
        else if (name.equals("oldtownroadlilnasx")){
            return R.drawable.oldtownroadlilnasx;
        }
        else if (name.equals("overdrake")){
            return R.drawable.overdrake;
        }
        else if (name.equals("talkingtothemoonbrunomars")){
            return R.drawable.talkingtothemoonbrunomars;
        }
        else if (name.equals("truthhurtslizzo")){
            return R.drawable.truthhurtslizzo;
        }
        else{
            return null;
        }
    }
}