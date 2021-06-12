package com.example.summary2;

public class CommentItem {
    String userID;
    String comment;

    //constructor
    public CommentItem(String userID, String comment) {
        this.userID = userID;
        this.comment = comment;
    }
    //getter and setter
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    //toString
    @Override
    public String toString() {
        return "CommentItem{" +
                "userID='" + userID + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
