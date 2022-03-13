package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button1); // 获取布局文件中控件的实例
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if (view.getId() == R.id.button1)
        {
            EditText editText1 = findViewById(R.id.editText1);
            String number = editText1.getText().toString();
            EditText editText2 = findViewById(R.id.editText2);
            String name = editText2.getText().toString();
            TextView textView1 = findViewById(R.id.textView1);
            textView1.setText(number + " " + name);
        }
    }
}