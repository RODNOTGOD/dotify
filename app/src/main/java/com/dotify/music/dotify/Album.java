package com.dotify.music.dotify;

import java.util.HashMap;

public class Album {
    private String title;
    private Artist artist;
    private HashMap<String, Song> songs;

    //default constructor
    public Album(String title)
    {
        this.title = "";
        songs = new HashMap<>();
    }

    //getters
    public String getTitle(){
        return title;
    }


    public HashMap<String,Song> getSongs(){
        return songs;
    }

    public Artist getArtist(){
        return artist;
    }

    public void setartist(Artist artist){
        this.artist = artist;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addSong(String songName) {
        songs.put(songName, new Song(songName));
    }

    public void print(){
        System.out.println("Album Title: " + title);
        System.out.println("Album Artist: " + artist.getName());
        }

}
