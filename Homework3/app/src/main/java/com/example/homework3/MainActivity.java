package com.example.homework3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<App> appArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appArrayList = new ArrayList<App>();
        initAppArrayList();
        RecyclerView recyclerView = findViewById(R.id.rv_list);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerAdapter adapter = new RecyclerAdapter(appArrayList);
        recyclerView.setAdapter(adapter);
    }

    private void initAppArrayList()
    {
        appArrayList.add(new App("笔记", R.drawable.ic_memo));
        appArrayList.add(new App("联系人", R.drawable.ic_contacts));
        appArrayList.add(new App("文档", R.drawable.ic_document));
        appArrayList.add(new App("天气", R.drawable.ic_weather));
        appArrayList.add(new App("地图", R.drawable.ic_map));
        appArrayList.add(new App("我", R.drawable.ic_about));
    }
}