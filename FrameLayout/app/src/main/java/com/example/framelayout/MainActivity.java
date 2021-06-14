package com.example.framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    ImageView imageView2;
    int idx = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
    }

    public void onButtonClicked(View v) {
        idx += 1;

        if (idx > 1) {
            idx = 0;
        }

        if (idx == 0) {
            imageView.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
        } else if (idx == 1) {
            imageView.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE);
        }
    }

}