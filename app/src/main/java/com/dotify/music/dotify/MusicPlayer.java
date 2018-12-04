package com.dotify.music.dotify;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

public class MusicPlayer extends AppCompatActivity {

    static final String SERVER_IP = DatabaseRetrieve.SERVER_IP;

    static MediaPlayer player = new MediaPlayer();
    static boolean initialStage = true;

    boolean playPause;

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

        player.setAudioStreamType(AudioManager.STREAM_MUSIC);

        albumartView = findViewById(R.id.albumart_view);
        playView = findViewById(R.id.player_view);

        prevBtn = findViewById(R.id.musicplayer_prev);
        playBtn = findViewById(R.id.musicplayer_play);
        nextBtn = findViewById(R.id.musicplayer_next);

        musicStatus = MusicListenStatus.PAUSE;

        String[] queue = null;
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            queue = bundle.getStringArray("queue");
        }

        String[] finalQueue = queue;
        playBtn.setOnClickListener((v) -> {
            if (musicStatus == MusicListenStatus.PAUSE) {
                playView.setImageResource(R.drawable.music_pause_light);
                musicStatus = MusicListenStatus.PLAYING;
            } else {
                playView.setImageResource(R.drawable.music_play_light);
                musicStatus = MusicListenStatus.PAUSE;
            }
            toggleMusic(finalQueue);
        });
    }

    private void toggleMusic(String[] queue) {
        if (queue == null) return;
        if (!playPause) {
            if (initialStage) {
                try {
                    player.setDataSource("http://" + SERVER_IP + "/" + queue[0]);
                    player.setOnPreparedListener((mp) -> {
                        mp.start();
                        initialStage = false;
                    });
                    player.prepareAsync();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                if (!player.isPlaying())
                    player.start();
            }
            playPause = true;
        } else {
            if (player.isPlaying())
                player.pause();
            playPause = false;
        }
    }
}
