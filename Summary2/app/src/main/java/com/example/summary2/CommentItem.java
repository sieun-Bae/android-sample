package com.example.summary2;

public class CommentItem {
    String userID;
    int minuteWritten;
    int score;
    String comment;
    int recommend;

    //constructor
    public CommentItem(String userID, int minuteWritten, int score, String comment, int recommend) {
        this.userID = userID;
        this.minuteWritten = minuteWritten;
        this.score = score;
        this.comment = comment;
        this.recommend = recommend;
    }

    //getter and setter
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getMinuteWritten() {
        return minuteWritten;
    }

    public void setMinuteWritten(int minuteWritten) {
        this.minuteWritten = minuteWritten;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRecommend() {
        return recommend;
    }

    public void setRecommend(int recommend) {
        this.recommend = recommend;
    }

    @Override
    public String toString() {
        return "CommentItem{" +
                "userID='" + userID + '\'' +
                ", minuteWritten=" + minuteWritten +
                ", score=" + score +
                ", comment='" + comment + '\'' +
                ", recommend=" + recommend +
                '}';
    }
}
