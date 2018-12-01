package com.dotify.music.dotify;


import java.util.HashMap;

public class Album {
    private String title;
    private String date;
    private HashMap<String, Song> songs;

    public Album(String title) {
        this.title = title;
        songs = new HashMap<>();
    }

    public HashMap<String, Song> getSongs() {
        return songs;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
    }

    public void addSong(String songName) {
        songs.put(songName, new Song(songName));
    }
}
