package com.example.homework2;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class AddressActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        String data = getIntent().getStringExtra("address_extra_data");
        EditText addressEText = findViewById(R.id.address_et);
        addressEText.setText(data);

        Button button = findViewById(R.id.address_btn);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent();
                intent.putExtra("address_data_return", addressEText.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}