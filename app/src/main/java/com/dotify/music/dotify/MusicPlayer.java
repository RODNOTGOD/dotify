package com.dotify.music.dotify;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.Arrays;

public class MusicPlayer extends AppCompatActivity {

    Player player;

    TextView artistText;
    TextView currentSongText;

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

        player = Player.getInstance();
        musicStatus = MusicListenStatus.PLAYING;

        artistText = findViewById(R.id.textView);
        currentSongText = findViewById(R.id.textView2);

        albumartView = findViewById(R.id.albumart_view);
        playView = findViewById(R.id.player_view);

        prevBtn = findViewById(R.id.musicplayer_prev);
        playBtn = findViewById(R.id.musicplayer_play);
        nextBtn = findViewById(R.id.musicplayer_next);

        Song song = player.getCurrentSong();
        currentSongText.setText(song.getTitle());

        playBtn.setOnClickListener((v) -> {
            if (musicStatus == MusicListenStatus.PAUSE) {
                playView.setImageResource(R.drawable.music_pause_light);
                musicStatus = MusicListenStatus.PLAYING;
                player.play();
            } else {
                playView.setImageResource(R.drawable.music_play_light);
                musicStatus = MusicListenStatus.PAUSE;
                player.pause();
            }
        });

        prevBtn.setOnClickListener((v) -> prevSong());
        nextBtn.setOnClickListener((v) -> nextSong());
    }

    private void prevSong() {
        player.previous();
    }

    private void nextSong() {
        player.next();
    }
}
