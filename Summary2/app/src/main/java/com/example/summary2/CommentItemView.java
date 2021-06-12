package com.example.summary2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import org.w3c.dom.Text;


/*
    String userID;
    int minuteWritten;
    int score;
    String comment;
    int recommend;
 */
public class CommentItemView extends LinearLayout {
    TextView userID;
    TextView userComment;

    public CommentItemView(Context context) {
        super(context);
        init(context);
    }

    public CommentItemView(Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        //inflation
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.comment_item_view, this, true);

        userID = (TextView) findViewById(R.id.userID);
        userComment = (TextView) findViewById(R.id.comment);
    }

    public void setUserID(String id) {
        userID.setText(id);
    }

    public void setComment(String comment) {
        userComment.setText(comment);
    }
}
