package com.example.progress;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    Handler handler = new Handler(); //post method 이용할 예정
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.postDelayed(new Runnable() {
                   public void run() {
                       ProgressThread thread = new ProgressThread();
                       thread.start();
                   }
                }, 5000);
                //ProgressThread thread = new ProgressThread();
                //thread.start();
            }
        });
    }

    class ProgressThread extends Thread {
        int value = 0;
        public void run() {
            while (true) {
                if (value > 100) {
                    break;
                }
                value += 1;
                handler.post(new Runnable() {

                    @Override
                    public void run() {
                        progressBar.setProgress(value);
                    }
                });

                try {
                    Thread.sleep(200);
                } catch(Exception e) {}
            }
        }
    }
}