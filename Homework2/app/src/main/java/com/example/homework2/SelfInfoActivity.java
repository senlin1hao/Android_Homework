package com.example.homework2;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SelfInfoActivity extends AppCompatActivity implements View.OnClickListener
{
    private TextView signatureText; //个性签名TextView
    private TextView addressText;   //通信地址TextView

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_info);
        LinearLayout signatureLL = findViewById(R.id.signature_ll);
        signatureLL.setOnClickListener(this);
        signatureText = findViewById(R.id.signature_txt);
        LinearLayout addressLL = findViewById(R.id.address_ll);
        addressLL.setOnClickListener(this);
        addressText = findViewById(R.id.address_txt);
    }

    private ActivityResultLauncher<Intent> startSignatureActivity = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>()
    {
        @Override
        public void onActivityResult(ActivityResult result)
        {
            //此处是跳转的 result 回调方法
            if ((result.getData() != null) && (result.getResultCode() == RESULT_OK))
            {
                String returnedData = result.getData().getStringExtra("signature_data_return");
                signatureText.setText(returnedData);
            }
            else
            {
                Toast.makeText(getApplicationContext(), "更新失败！", Toast.LENGTH_LONG).show();
            }
        }
    });

    private ActivityResultLauncher<Intent> startAddressActivity = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>()
    {
        @Override
        public void onActivityResult(ActivityResult result)
        {
            if ((result.getData() != null) && (result.getResultCode() == RESULT_OK))
            {
                String returnedData = result.getData().getStringExtra("address_data_return");
                addressText.setText(returnedData);
            }
            else
            {
                Toast.makeText(getApplicationContext(), "更新失败！", Toast.LENGTH_LONG).show();
            }
        }
    });

    @Override
    public void onClick(View view)
    {
        int id = view.getId();
        switch (id)
        {
            case R.id.signature_ll:
            {
                String data = signatureText.getText().toString();
                Intent intent = new Intent(this, SignatureActivity.class);
                intent.putExtra("signature_extra_data", data);    //向下一个 Activity 传递数据
                startSignatureActivity.launch(intent);
                break;
            }
            case R.id.address_ll:
            {
                String data = addressText.getText().toString();
                Intent intent = new Intent(this, AddressActivity.class);
                intent.putExtra("address_extra_data", data);
                startAddressActivity.launch(intent);
                break;
            }
            case R.id.portrait_ll:
            {
                break;
            }
        }
    }
}