package com.example.experiment1;

import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] gender_list = new String[]{"男", "女"};
        Spinner sp_gender = (Spinner) findViewById(R.id.sexSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.item_select, gender_list);
        sp_gender.setAdapter(adapter);
    }
}