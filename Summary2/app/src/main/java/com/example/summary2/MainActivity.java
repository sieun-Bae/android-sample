package com.example.summary2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.summary2.CommentItem;
import com.example.summary2.R;

import org.w3c.dom.Comment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView likeCntView;
    Button likeBtn;

    boolean likeState = false;
    int likeCnt = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //좋아요 버튼
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

        //ListView 추가
        ListView listView = (ListView) findViewById(R.id.listView);
        CommentAdapter adapter = new CommentAdapter();

        adapter.addItem(new CommentItem("bae101**", "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요."));
        adapter.addItem(new CommentItem("bae102**", "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요."));

        listView.setAdapter(adapter);
    }

    class CommentAdapter extends BaseAdapter {
        ArrayList<CommentItem> items = new ArrayList<CommentItem>();

        //사용자 정의 메소드
        public void addItem(CommentItem item) {
            items.add(item);
        }
        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            CommentItemView view = new CommentItemView(getApplicationContext());

            CommentItem item = items.get(position);
            view.setUserID(item.getUserID());
            view.setComment(item.getComment());

            return view;
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