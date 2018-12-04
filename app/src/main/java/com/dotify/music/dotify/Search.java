package com.dotify.music.dotify;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

public class Search extends AppCompatActivity {

    TextView searchTermLabel;
    private ArrayList<Song> mSongs = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        searchTermLabel = findViewById(R.id.searchTermString);
        initSongs();
        RecyclerView recyclerView = findViewById(R.id.searchResultsRecycleView);
        SongViewAdapter adapter = new SongViewAdapter(mSongs);
        recyclerView.setAdapter(adapter);
    }

    public void initSongs(){
        mSongs.add(new Song("Hello Everyone","The Demos"));
        mSongs.add(new Song("Demo Song 1","The Demos"));
        mSongs.add(new Song("Demo Song 2","The Demos"));
        mSongs.add(new Song("Demo Song 4","The Demos"));
        mSongs.add(new Song("The Last Demo Song","The Demos"));
        mSongs.add(new Song("The Last Demo Song Part 2","The Demos"));
    }

}
