package com.example.framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    ImageView imageView2; //메모리에 할당하여 다른 메소드에서 접근 가능하도록 한다.

    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.imageView); //return view
        imageView2 = (ImageView)findViewById(R.id.imageView2);
    }

    public void onButtonClicked(View v) {

    }
    public void onButton1Clicked(View v) {
        index += 1;
        if (index > 1) {
            index = 0;
        }

        if (index == 0) {
            imageView.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
        } else if (index == 1) {
            imageView.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE);
        }
    }
}