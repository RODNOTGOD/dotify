package com.dotify.music.dotify;

public class Song {
    private String songName;
    int songId;
    private Artist songArtist;
    private Album songAlbum;
    private double songLength;
    private String songGenre;

    //default constructor
    public Song()
    {
        this.songName = "";
        this.songAlbum = null;
        this.songArtist = null;
        this.songId = 0;
        this.songLength = 0.0;
        this.songGenre = "";
    }

    //constructor
    public Song(String songName, Album album, Artist artist, int songId, double songLength, String songGenre)
    {
        this.songName = songName;
        this.songAlbum = album;
        this.songArtist = artist;
        this.songId = songId;
        this.songLength = songLength;
        this.songGenre = songGenre;
    }

    public Song(String songName, int songId, double songLength, String songGenre)
    {
        this.songName = songName;
        this.songId = songId;
        this.songLength = songLength;
        this.songGenre = songGenre;
    }

    //quick demo constructor
    public Song(String songName, String artistName)
    {
        this.songName = songName;
        this.setSongArtist(new Artist(artistName));
    }

    //quick demo constructor
    public Song(String songName)
    {
        this.songName = songName;
        this.setSongArtist(new Artist("Unknown Artist"));
    }

    //getters
    public String getSongName(){
        return songName;
    }

    public double getSongLength(){
        return songLength;
    }

    public double getSongId(){
        return songId;
    }

    public String getSongGenre(){
        return songGenre;
    }

    public Album getSongAlbum(){
        return songAlbum;
    }

    public Artist getSongArtist(){
        return songArtist;
    }

    public void setSongAlbum(Album album){
        this.songAlbum = album;
    }

    public void setSongArtist(Artist artist){
        this.songArtist = artist;
    }

    public void print(){
        System.out.println("Song Name: " + songName);
        System.out.println("Album Name: " + songAlbum.getTitle());
        System.out.println("Artist Name: " + songArtist.getName());
        System.out.println("Song ID: " + songId);
        System.out.println("Song Length: " + songLength);
        System.out.println("Song Genre: " + songGenre);
    }

}
