package com.dotify.music.dotify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class SongArrayAdapter  extends ArrayAdapter<Song> {

    //nested class which has reusing views that scroll on and off the screen
    private static class ViewHolder {
        TextView songNameView;
        TextView artistNameView;
        TextView albumNameView;
    }

    //constructor
    public SongArrayAdapter(Context context,List<Song> songList){
        super(context, -1, songList);
    }

    //creates customer views for the ListView's items
    public View getView(int position, View convertView, ViewGroup parent){
        Song song = getItem(position);
        ViewHolder viewHolder;

        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView =
                    inflater.inflate(R.layout.song_item, parent, false);
            viewHolder.songNameView =
                    (TextView) convertView.findViewById(R.id.songNameLabel);
            viewHolder.artistNameView =
                    (TextView) convertView.findViewById(R.id.artistNameLabel);
            viewHolder.albumNameView =
                    (TextView) convertView.findViewById(R.id.albumNameLabel);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.songNameView.setText(song.getSongName());
        viewHolder.artistNameView.setText(song.getSongArtist().getArtistName());
        viewHolder.albumNameView.setText(song.getSongAlbum().getAlbumName());

        return convertView;
    }
}
