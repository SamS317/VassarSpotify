package edu.vassar.cmpu203.vassarspotify.view;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import edu.vassar.cmpu203.vassarspotify.R;
import edu.vassar.cmpu203.vassarspotify.databinding.FragmentPlayScreenBinding;
import edu.vassar.cmpu203.vassarspotify.model.Song;


public class PlayScreenFragment extends Fragment implements IPlayScreenFragment{
    FragmentPlayScreenBinding binding;
    Listener listener;
    ImageView albumCover;


    public PlayScreenFragment(Listener listener) { this.listener = listener; }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = FragmentPlayScreenBinding.inflate(inflater);
        return this.binding.getRoot();
    }


    /**
     * Contains listeners for play, replay, and skip buttons
     * @param view Current View
     * @param savedInstanceState Current savedInstanceState
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Song s = PlayScreenFragment.this.listener.getCurrentSong();
        PlayScreenFragment.this.binding.songNamePS.setText(s.getSongName());
        PlayScreenFragment.this.binding.artistNamePS.setText(s.getArtist());


        //Listener for the play/pause button on the play-screen
        this.binding.playbackButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                String songNameString  = (PlayScreenFragment.this.binding.songNamePS.getText()).toString();
                String artistNameString = (PlayScreenFragment.this.binding.artistNamePS.getText()).toString();

                Song s = PlayScreenFragment.this.listener.getSongFromSongDatabase(songNameString, artistNameString);

                PlayScreenFragment.this.listener.playPauseGivenSong(PlayScreenFragment.this.getContext(), s);

                PlayScreenFragment.this.binding.songNamePS.setText(s.getSongName());
                PlayScreenFragment.this.binding.artistNamePS.setText(s.getArtist());

                albumCover = requireView().findViewById(R.id.imageView);
                albumCover.setImageResource((Integer) returnDrawableID(PlayScreenFragment.this.listener.getRightText(s.getSongName(), s.getArtist())));

                if( PlayScreenFragment.this.listener.isSongPlaying() ){
                    PlayScreenFragment.this.binding.playbackButton.setText("Pause");
                }else{
                    PlayScreenFragment.this.binding.playbackButton.setText("Play");
                }
            }
        });


        //Listener for the replay song button on the play-screen
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


        //Listener for the skip song button on the play-screen
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


    /**
     * Provides a way to return the image directory in the current raw file
     * This method will be replaced with database calls in one of the next iterations
     * @param name The full name of the song and artist combo
     * @return Returns the link to the picture located in the "drawable" resource file
     */
    public Object returnDrawableID(String name){
        switch (name) {
            case "billiejeanmichaeljackson":
                return R.drawable.billiejeanmichaeljackson;
            case "canttellmeanythingkanyewest":
                return R.drawable.canttellmeanythingkanyewest;
            case "despacitoluisfonsidaddyyankee":
                return R.drawable.despacitoluisfonsidaddyyankee;
            case "halobeyonce":
                return R.drawable.halobeyonce;
            case "helloadele":
                return R.drawable.helloadele;
            case "helloeminem":
                return R.drawable.helloeminem;
            case "kanyeweststronger":
                return R.drawable.kanyeweststronger;
            case "leavingwestvirginialathymattea":
                return R.drawable.leavingwestvirginialathymattea;
            case "lockedoutofheavenbrunomars":
                return R.drawable.lockedoutofheavenbrunomars;
            case "oldtownroadlilnasx":
                return R.drawable.oldtownroadlilnasx;
            case "overdrake":
                return R.drawable.overdrake;
            case "talkingtothemoonbrunomars":
                return R.drawable.talkingtothemoonbrunomars;
            case "truthhurtslizzo":
                return R.drawable.truthhurtslizzo;
            default:
                return null;
        }
    }
}