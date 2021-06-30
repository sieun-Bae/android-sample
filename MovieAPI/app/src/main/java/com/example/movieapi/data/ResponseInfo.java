package com.example.movieapi.data;

import java.util.ArrayList;

/* JSON 속성 이름이 변수명이 된다고 했습니다.
message: "movie readMovieList 성공",
code: 200,
resultType: "list",
result: [ ]
* */
public class ResponseInfo {
    public String message;
    public int code;
    public String resultType;
    //public String result; //나중에 파싱할겁니다.
}

