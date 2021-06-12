package com.example.summary2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Comment;

public class MainActivity extends AppCompatActivity {

    TextView likeCntView;
    Button likeBtn;

    boolean likeState = false;
    int likeCnt = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        likeBtn = (Button) findViewById(R.id.likeBtn);
        likeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (likeState) {
                    decrLikeCnt();
                } else {
                    incrLikeCnt();
                }

                likeState = !likeState;
            }
        });

        likeCntView = (TextView) findViewById(R.id.likeCntView);

        ListView listView = (ListView) findViewById(R.id.listView);
        CommentAdapter adapter = new CommentAdapter();
        listView.setAdapter(adapter);
    }

    class CommentAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }
    }


    public void incrLikeCnt() {
        likeCnt += 1;
        likeCntView.setText(String.valueOf(likeCnt));

        likeBtn.setBackgroundResource(R.drawable.ic_thumb_up_selected);
    }

    public void decrLikeCnt() {
        likeCnt -= 1;
        likeCntView.setText(String.valueOf(likeCnt));

        likeBtn.setBackgroundResource(R.drawable.ic_thumb_up);
    }
}