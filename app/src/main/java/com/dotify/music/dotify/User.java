package com.dotify.music.dotify;

import java.util.ArrayList;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String hashedPassword;

    //privacy settings TBA?

    private Playlist favorites;
    private ArrayList<Playlist> playlists;

    public User(String firstName, String lastName, String email, String username, String hashedPassword){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.favorites = new Playlist("Favorites");
    }
}
