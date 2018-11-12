package com.dotify.music.dotify;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class StatusBar extends Fragment {
    public StatusBar() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.status_bar, container, false);
        Button newFeedBtn = rootView.findViewById(R.id.newsfeed_btn);
        Button libraryBtn = rootView.findViewById(R.id.library_btn);
        Button settingsBtn = rootView.findViewById(R.id.settings_btn);

        newFeedBtn.setOnClickListener(v -> {
            System.out.println("NEWSFEED CLICKED");
        });
        libraryBtn.setOnClickListener(v -> {
            System.out.println("LIBRARY CLICKED");
        });
        settingsBtn.setOnClickListener(v -> {
            System.out.println("SETTINGS CLICKED");
        });

        return rootView;
    }
}
