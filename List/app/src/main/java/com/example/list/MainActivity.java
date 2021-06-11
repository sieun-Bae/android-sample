package com.example.list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SingerAdapter adapter;
    EditText editText;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText = (EditText) findViewById(R.id.editTextTextPersonName);
        editText2 = (EditText) findViewById(R.id.editTextTextPersonName2);

        ListView listView = (ListView) findViewById(R.id.listView);

        adapter = new SingerAdapter();
        adapter.addItem(new SingerItem("엄정화", "010-1000-1000", R.drawable.image1));
        adapter.addItem(new SingerItem("이효리", "010-2000-2000",R.drawable.image2));
        adapter.addItem(new SingerItem("제시", "010-3000-3000",R.drawable.image3));
        adapter.addItem(new SingerItem("화사", "010-4000-4000",R.drawable.image4));

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SingerItem item = (SingerItem) adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "선택: "+item.getName(), Toast.LENGTH_LONG).show();
            }
        });

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                String mobile = editText2.getText().toString();

                adapter.addItem(new SingerItem(name, mobile, R.drawable.ic_launcher_background));
                adapter.notifyDataSetChanged();
            }
        });
    }

    class SingerAdapter extends BaseAdapter { //customizing adapter to make form of item, to make list

        ArrayList<SingerItem> items = new ArrayList<SingerItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(SingerItem item) {
            items.add(item);
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
            SingerItemView view = null;
            if (convertView == null) {
                view = new SingerItemView(getApplicationContext());
            } else {
                view = (SingerItemView) convertView;
            }

            //position?
            SingerItem item = items.get(position);
            view.setName(item.getName());
            view.setMobile(item.getMobile());
            view.setImage(item.getResId());
            return view;
        }
    }
}


