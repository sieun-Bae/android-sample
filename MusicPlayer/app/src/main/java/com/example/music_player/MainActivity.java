package com.example.music_player;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mp = MediaPlayer.create(this, R.raw.roses);
        mp.setLooping(false);

        tv = (TextView) this.findViewById(R.id.hellobutton);
        tv.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(!mp.isPlaying()) {
                    mp.start();
                    tv.setText("Stop");
                } else {
                    mp.pause();
                    tv.setText("Start");
                }
            }
        });
    }
}