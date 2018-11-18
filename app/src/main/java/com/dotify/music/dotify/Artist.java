package com.dotify.music.dotify;

public class Artist {
    private String artistName;
    private int artistId;
    private Album[] albumList;

    //default constructor
    public Artist()
    {
        this.artistName = "";
        this.artistId = 0;
        this.albumList = null;
    }

    //constructor
    public Artist(String artistName, int artistId, Album[] albumList)
    {
        this.artistName = artistName;
        this.artistId = artistId;
        this.albumList = albumList;
    }

    public Artist(String artistName, int artistId)
    {
        this.artistName = artistName;
        this.artistId = artistId;
    }

    //getters
    public String getArtistName(){
        return artistName;
    }

    public double getArtistId(){
        return artistId;
    }

    public Album[] getAlbumList(){
        return albumList;
    }

    public void setAlbumList (Album[] albumList){
        this.albumList = albumList;
    }

    public void print(){
        System.out.println("Artist Name: " + artistName);
        System.out.println("Artist ID: " + artistId);
        System.out.println("Albums: ");
        for(Album a: albumList){
            System.out.println("\t" + a.getAlbumName());
        }
    }
}
