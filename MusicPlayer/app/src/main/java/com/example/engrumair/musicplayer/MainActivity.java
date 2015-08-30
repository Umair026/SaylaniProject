package com.example.engrumair.musicplayer;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
    GridView grid;

    private GridView itemClick;
    String[] lower_item = {
            "All Music","Recent player","Artist","Album","Folder","Playlist","Recent Add"
    };
    int[] image_Id ={
            R.drawable.ic_audiotrack_white_24dp,
            R.drawable.ic_library_music_white_24dp,
            R.drawable.ic_person_outline_white_24dp,
            R.drawable.ic_album_white_24dp,
            R.drawable.ic_folder_open_white_24dp,
            R.drawable.ic_queue_music_white_24dp,
            R.drawable.ic_content_paste_white_24dp,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridAdapter Adapter = new GridAdapter(MainActivity.this,lower_item,image_Id);
        grid=(GridView)findViewById(R.id.grid_view);

        grid.setAdapter(Adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {
                Toast.makeText(getApplicationContext(),"Clicked", Toast.LENGTH_SHORT).show();
                TextView textView = (TextView) findViewById(R.id.grid_lower_item);

            }
        });

        final ImageView play_Image = (ImageView) findViewById(R.id.play);
        play_Image.setOnClickListener(new View.OnClickListener() {
          int set;
            @Override
            public void onClick(View v) {

              if(set != 1) {
                  Toast.makeText(MainActivity.this,"Play click",Toast.LENGTH_SHORT).show();
                  play_Image.setImageResource(R.drawable.ic_pause_white_24dp);
                    set = 1;
              }
               else {
                  Toast.makeText(MainActivity.this,"Pause click",Toast.LENGTH_SHORT).show();
                  play_Image.setImageResource(R.drawable.ic_play_arrow_white_24dp);
              set =0;
              }

            }
        });

        ImageView playback_Image = (ImageView) findViewById(R.id.play_back);
        playback_Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Play_Back",Toast.LENGTH_SHORT).show();
            }
        });

        ImageView playfarward_Image = (ImageView) findViewById(R.id.play_farward);
        playfarward_Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Play Farward",Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

}
