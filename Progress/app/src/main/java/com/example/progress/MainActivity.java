package com.example.progress;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    Handler handler = new Handler(); //post method 이용할 예정
    CompletionThread completionThread;
    String msg = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressTask task = new ProgressTask();
                task.execute("시작"); //doInBackground로 전달됨, 특별한 용도는 없음

                /*
                handler.postDelayed(new Runnable() {
                   public void run() {
                       ProgressThread thread = new ProgressThread();
                       thread.start();
                   }
                }, 5000);*/
                //ProgressThread thread = new ProgressThread();
                //thread.start();
            }
        });

        completionThread = new CompletionThread();
        completionThread.start();
    }

    class ProgressTask extends AsyncTask<String, Integer, Integer> {
        int value = 0;
        @Override
        protected Integer doInBackground(String... strings) { //스레드 안에 넣을 코드
            while (true) {
                if (value > 100) {
                    break;
                }
                value += 1;
                publishProgress(value); //onProgressUpdate 호출

                try {
                    Thread.sleep(200);
                } catch(Exception e) {}
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0].intValue());
        }

        @Override
        protected void onPostExecute(Integer integer) { //doInBackground완료 후 return값 이용
            super.onPostExecute(integer);
            Toast.makeText(getApplicationContext(), "완료됨", Toast.LENGTH_LONG).show();
        }
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
            completionThread.completionHandler.post(new Runnable() {
                public void run() {
                    msg = "OK"; //ok를 새로운 completion thread로 보냅니다.
                    Log.d("MainActivity", "메시지: "+msg);
                }
            });

        }
    }
    class CompletionThread extends Thread {
        public Handler completionHandler = new Handler();

        public void run() {
            Looper.prepare();
            Looper.loop(); //스레드는 대기상태
        }
    }
}