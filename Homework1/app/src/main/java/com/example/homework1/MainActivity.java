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
//            TextView textView =findViewById(R.id.textView);
//            EditText editText =findViewById(R.id.editText);
//            String input = editText.getText().toString();
//            textView.setText(input);

//            ImageView imageView = findViewById(R.id.image);
//            imageView.setImageResource(R.drawable.badge02);

//            ProgressBar progressBar = findViewById(R.id.progressBar);
//            if (progressBar.getVisibility() == View.VISIBLE) {
//                progressBar.setVisibility(View.GONE);
//            } else {
//                progressBar.setVisibility(View.VISIBLE);
//            }
//            int progress = progressBar.getProgress() + 10;
//            progressBar.setProgress(progress);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("提示");
            builder.setMessage("确定？");
            builder.setCancelable(true);
            // 设置 ok 按钮
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {
                    // 在此处添加处理逻辑
                    EditText editText1 = findViewById(R.id.editText1);
                    String studentNumber = editText1.getText().toString();
                    EditText editText2 = findViewById(R.id.editText2);

                }
            });
            //设置 cancel按钮
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialog, int i)
                {
                    // 在此处添加处理逻辑
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show(); // 显示对话框
        }
    }
}