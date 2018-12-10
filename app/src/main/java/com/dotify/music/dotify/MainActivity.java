package com.dotify.music.dotify;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addStartupFragment();

    }

    private void addStartupFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        NewsFeed newsFeed = new NewsFeed();
        transaction.add(R.id.main_feed_fragment, newsFeed);
        transaction.commit();
    }

    public void logoutButtonClicked(View v){
        System.out.println("logout button pushed!");
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}
