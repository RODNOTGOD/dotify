package com.dotify.music.dotify;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<Artist> artists = new ArrayList<>();
    public ArrayList<Album> albums = new ArrayList<>();
    public ArrayList<Song> songs = new ArrayList<> ();

    private SongArrayAdapter songArrayAdapter;
    private ListView songListView;

    public String searchTerm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Song demoSong = new Song("Never Gonna Give You Up",1,3.2,"Pop");
        Song demoSong2 = new Song("Never Gonna Give You Up V.2",2,3.2,"Pop");
        Artist demoArtist = new Artist("Rick Astley",1);
        Album demoAlbum = new Album("Never Gonna Give You Up (Single)",1,"Pop");

        demoSong.setSongAlbum(demoAlbum);
        demoSong.setSongArtist(demoArtist);
        demoSong2.setSongAlbum(demoAlbum);
        demoSong2.setSongArtist(demoArtist);

        Song[] demoSongArray = {demoSong};
        Album[] demoAlbumArray = {demoAlbum};

        demoAlbum.setAlbumArtist(demoArtist);
        demoAlbum.setSongArray(demoSongArray);

        demoArtist.setAlbumList(demoAlbumArray);

        artists.add(demoArtist);
        albums.add(demoAlbum);
        songs.add(demoSong);
        songs.add(demoSong2);

        setContentView(R.layout.activity_search);

        songListView = (ListView) findViewById(R.id.songListView);
        songArrayAdapter = new SongArrayAdapter(this, songs);
        songListView.setAdapter(songArrayAdapter);


    }
}
