package com.example.volley;

import java.util.ArrayList;

public class MovieListResult {
    String boxofficeType;
    String showRange;
    //배열... dailyBoxOfficeList -> Gson 에 의한 파싱이 필요
    ArrayList<Movie> dailyBoxOfficeList = new ArrayList<Movie>();
}


