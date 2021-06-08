package com.example.basicwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //radio button 에서 뭘 선택했는지 알고싶다.
        RadioButton radioButton = (RadioButton) findViewById(R.id.radioButton);
        boolean checked = radioButton.isChecked();

    }
}