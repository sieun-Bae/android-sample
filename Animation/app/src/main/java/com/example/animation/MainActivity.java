package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    ArrayList<Drawable> imageList = new ArrayList<Drawable>();

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        Resources res = getResources();
        imageList.add(res.getDrawable(R.drawable.walk1));
        imageList.add(res.getDrawable(R.drawable.walk2));
        imageList.add(res.getDrawable(R.drawable.walk3));
        imageList.add(res.getDrawable(R.drawable.walk4));
        imageList.add(res.getDrawable(R.drawable.walk5));
        imageList.add(res.getDrawable(R.drawable.walk6));
        imageList.add(res.getDrawable(R.drawable.walk7));
        imageList.add(res.getDrawable(R.drawable.walk8));

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimThread thread = new AnimThread();
                thread.start();
            }
        });
    }

    class AnimThread extends Thread {
        public void run() {
            int index = 0;
            for (int i=0;i<100;i++) {
                index = i%8;
                final Drawable drawable = imageList.get(index);

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageDrawable(drawable);
                    }
                });

                try {
                    Thread.sleep(200);
                } catch (Exception e) {}
            }
        }
    }
}