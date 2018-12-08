package com.dotify.music.dotify;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static CharSequence searchTerm = "meep";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addStartupFragment();
    }

    private void addStartupFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        MusicLibrary musicLibrary = new MusicLibrary();
        transaction.add(R.id.main_feed_fragment, musicLibrary);
        transaction.commit();

    }

    public void switchToUserLibrary(UserLibrary thing) {
        Fragment userLibrary = new UserLibrary();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        String tag = "library";
        transaction.add(R.id.main_feed_fragment, userLibrary, tag);
        transaction.addToBackStack(tag);

        transaction.commit();
    }
}
