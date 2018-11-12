package com.dotify.music.dotify;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

public class MusicPlayer extends AppCompatActivity {

    ImageView albumartView;
    ImageView playView;

    Button prevBtn;
    Button playBtn;
    Button nextBtn;

    enum MusicListenStatus {PLAYING, PAUSE}

    MusicListenStatus musicStatus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_player);

        albumartView = findViewById(R.id.albumart_view);
        playView = findViewById(R.id.player_view);

        prevBtn = findViewById(R.id.musicplayer_prev);
        playBtn = findViewById(R.id.musicplayer_play);
        nextBtn = findViewById(R.id.musicplayer_next);

        musicStatus = MusicListenStatus.PAUSE;

        playBtn.setOnClickListener((v) -> {
            if (musicStatus == MusicListenStatus.PAUSE) {
                playView.setImageResource(R.drawable.music_pause_light);
                musicStatus = MusicListenStatus.PLAYING;
            } else {
                playView.setImageResource(R.drawable.music_play_light);
                musicStatus = MusicListenStatus.PAUSE;
            }
        });

    }
}
