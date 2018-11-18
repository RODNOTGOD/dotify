package com.dotify.music.dotify;

import java.util.ArrayList;

public class Album {
    private String albumName;
    int albumId;
    private Artist albumArtist;
    private Song[] songArray;
    private double albumLength;
    private String albumGenre;

    //default constructor
    public Album()
    {
        this.albumName = "";
        this.albumId = 0;
        this.albumArtist = null;
        this.albumLength = 0.0;
        this.albumGenre = "";
        this.songArray = null;
    }

    //constructor
    public Album(String albumName, int albumId, Artist artist, Song songArray[], String albumGenre)
    {
        this.albumName = albumName;
        this.albumId = albumId;
        this.albumArtist = artist;
        this.albumGenre = albumGenre;
        this.songArray = songArray;
        for(Song s: songArray){
            albumLength += s.getSongLength();
        }
    }

    //constructor
    public Album(String albumName, int albumId, String albumGenre)
    {
        this.albumName = albumName;
        this.albumId = albumId;
        this.albumGenre = albumGenre;
    }

    //getters
    public String getAlbumName(){
        return albumName;
    }

    public double getAlbumLength(){
        return albumLength;
    }

    public double getAlbumId(){
        return albumId;
    }

    public String getAlbumGenre(){
        return albumGenre;
    }

    public Song[] getSongArray(){
        return songArray;
    }

    public Artist getAlbumArtist(){
        return albumArtist;
    }

    public void setAlbumArtist(Artist artist){
        this.albumArtist = artist;
    }

    public void setSongArray(Song[] songArray){
        this.songArray = songArray;
        for(Song s: songArray){
            albumLength += s.getSongLength();
        }
    }

    public void print(){
        System.out.println("Album Name: " + albumName);
        System.out.println("Album ID: " + albumId);
        System.out.println("Album Artist: " + albumArtist.getArtistName());
        System.out.println("Album Length: " + albumLength);
        System.out.println("Album Genre: " + albumGenre);
        System.out.println("Songs: ");
        for(Song s: songArray){
            System.out.println("\t" + s.getSongName());
        }
    }
}
