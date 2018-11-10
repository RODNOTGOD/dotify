package com.dotify.music.dotify;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class MusicPlayer extends Fragment {

    int counter;
    static MUSIC_STATUS status;
    enum MUSIC_STATUS { PLAYING, PAUSE }

    public MusicPlayer() {
        counter = 0;
        status = MUSIC_STATUS.PAUSE;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.music_player_fragment, container, false);

        ImageButton playBtn = rootView.findViewById(R.id.music_play_button);
        ImageButton prevBtn = rootView.findViewById(R.id.music_prev_button);
        ImageButton nextBtn = rootView.findViewById(R.id.music_next_button);

        playBtn.setOnClickListener(v -> {
            if (status == MUSIC_STATUS.PAUSE) {
                playBtn.setImageResource(R.drawable.music_play_background);
                status = MUSIC_STATUS.PLAYING;
            } else {
                playBtn.setImageResource(R.drawable.music_pause_background);
                status = MUSIC_STATUS.PAUSE;
            }
        });

        prevBtn.setOnClickListener(v -> {
            // go to previous song
        });

        prevBtn.setOnClickListener(v -> {
            // go to previous song
        });

        return rootView;
    }
}
