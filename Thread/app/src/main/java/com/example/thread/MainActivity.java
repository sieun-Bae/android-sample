package com.example.thread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    //int value = 0;
    ValueHandler handler = new ValueHandler();
    Handler handler2 = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //BackgroundThread thread = new BackgroundThread();
                //thread.start();

                new Thread(new Runnable() {
                    int value = 0;
                    boolean running = false;
                    public void run() {
                        running = true;
                        //textView.setText("현재 값: " + value);
                        while (running) {
                            value += 1;

                            handler2.post(new Runnable() {
                               public void run() {
                                   textView.setText("현재 값: "+value);
                               }
                            });

                            try {
                                Thread.sleep(1000); //1초
                            } catch(Exception e) { }
                        }
                    }
                }).start();
            }
        });

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // textView.setText("현재 값: " + value);
            }
        });
    }

    class BackgroundThread extends Thread {
        int value = 0;
        boolean running = false;
        public void run() {
            running = true;
            //textView.setText("현재 값: " + value);
            while (running) {
                value += 1;
                //메시지 set
                Message message = handler.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putInt("value", value);
                message.setData(bundle);
                //메시지객체 send
                handler.sendMessage(message);

                try {
                    Thread.sleep(1000); //1초
                } catch(Exception e) { }
            }
        }
    }
    class ValueHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            Bundle bundle = msg.getData();
            int value = bundle.getInt("value");
            textView.setText("현재 값: "+ value);
        }
    }
}
