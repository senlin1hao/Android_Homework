package com.example.homework2;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SignatureActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signature);

        String data = getIntent().getStringExtra("signature_extra_data"); //取出 intent 传递过来的数据
        EditText signatureEText = findViewById(R.id.signature_et);
        signatureEText.setText(data);

        Button button = findViewById(R.id.save_signature_btn);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent();
                intent.putExtra("signature_data_return", signatureEText.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}