package com.example.client;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClientThread thread = new ClientThread();
                thread.start();
            }
        });
    }
    class ClientThread extends Thread {
        public void run() {
            String host = "localhost"; //ip 자기자신
            int port = 5001; //동일해야겠죠?
            try {
                Socket socket = new Socket(host, port);
                ObjectOutputStream outstream = new ObjectOutputStream(socket.getOutputStream());
                outstream.writeObject("안녕!");
                outstream.flush();
                Log.d("ClientThread", "서버로 보냄.");

                ObjectInputStream instream = new ObjectInputStream(socket.getInputStream());
                final Object input = (String) instream.readObject();
                Log.d("ClientThread", "받은 데이터: "+input);

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("받은 데이터: "+input); //그대로 넣으면 에러가 날겁니다. 핸들러를 통해 접근!
                    }
                });

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}