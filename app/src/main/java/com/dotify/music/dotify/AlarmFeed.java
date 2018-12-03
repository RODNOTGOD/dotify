package com.dotify.music.dotify;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class AlarmFeed extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.alarm_display, container, false);
        Button button = rootView.findViewById(R.id.alarm_add);
        button.setOnClickListener((v) -> openAlarmCreator());
        return rootView;
    }

    public void openAlarmCreator() {
        Intent intent = new Intent(getActivity(), Alarm.class);
        startActivity(intent);
    }
}
