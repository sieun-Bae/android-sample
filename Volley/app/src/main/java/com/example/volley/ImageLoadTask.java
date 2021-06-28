package com.example.volley;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.net.URL;
import java.util.HashMap;

public class ImageLoadTask extends AsyncTask<Void, Void, Bitmap> {

    private String urlStr;
    private ImageView imageView;

    //요청 URL과 Bitmap 객체를 매핑해두는 용도!
    private static HashMap<String, Bitmap> bitmapHash = new HashMap<String ,Bitmap>();

    //constructor
    public ImageLoadTask(String urlString, ImageView imageView) {
        this.urlStr = urlString;
        this.imageView = imageView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Bitmap doInBackground(Void... voids) {
        Bitmap bitmap = null;
        try {
            if (bitmapHash.containsKey(urlStr)) {
                Bitmap oldBitmap = bitmapHash.remove(urlStr); //이미 만든아이
                if (oldBitmap != null) {
                    oldBitmap.recycle();
                    oldBitmap = null;
                }
            }
            URL url = new URL(urlStr);
            bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());

            bitmapHash.put(urlStr, bitmap);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap; //to onPostExecute
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        imageView.setImageBitmap(bitmap);
        imageView.invalidate();
    }
}
