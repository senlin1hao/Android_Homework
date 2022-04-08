package com.example.experiment1;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
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

        Button button = findViewById(R.id.saveButton);
        button.setOnClickListener(this);

        button = findViewById(R.id.readButton);
        button.setOnClickListener(this);

        button = findViewById(R.id.clearButton);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if (view.getId() == R.id.saveButton)
        {
            SharedPreferences pref = getSharedPreferences("user_info", MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();
            EditText editText;
            String string;

            editText = findViewById(R.id.usernameEditText);
            string = editText.getText().toString();
            editor.putString("username", string);

            editText = findViewById(R.id.passwordEditText);
            string = editText.getText().toString();
            editor.putString("password", string);

            editText = findViewById(R.id.phoneEditText);
            string = editText.getText().toString();
            editor.putString("phone", string);

            editText = findViewById(R.id.emailEditText);
            string = editText.getText().toString();
            editor.putString("email", string);

            Spinner spinner = findViewById(R.id.sexSpinner);
            int i;
            i = spinner.getSelectedItemPosition();
            editor.putInt("sex", i);

            editor.apply();
        }

        if (view.getId() == R.id.readButton)
        {
            SharedPreferences pref = getSharedPreferences("user_info", MODE_PRIVATE);
            EditText editText;
            String string;

            string = pref.getString("username", "");
            editText = findViewById(R.id.usernameEditText);
            editText.setText(string);

            string = pref.getString("password", "");
            editText = findViewById(R.id.passwordEditText);
            editText.setText(string);

            string = pref.getString("phone", "");
            editText = findViewById(R.id.phoneEditText);
            editText.setText(string);

            string = pref.getString("email", "");
            editText = findViewById(R.id.emailEditText);
            editText.setText(string);

            int i;
            i = pref.getInt("sex", 0);
            Spinner spinner = findViewById(R.id.sexSpinner);
            spinner.setSelection(i);
        }

        if (view.getId() == R.id.clearButton)
        {
            EditText editText;

            editText = findViewById(R.id.usernameEditText);
            editText.setText("");

            editText = findViewById(R.id.passwordEditText);
            editText.setText("");

            editText = findViewById(R.id.phoneEditText);
            editText.setText("");

            editText = findViewById(R.id.emailEditText);
            editText.setText("");

            Spinner spinner = findViewById(R.id.sexSpinner);
            spinner.setSelection(0);
        }
    }
}