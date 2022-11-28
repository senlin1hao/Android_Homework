package com.example.experiment2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    MyDBHelper myDBHelper = new MyDBHelper(MainActivity.this, "user_db", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner usernameSpinner = findViewById(R.id.usernameSpinner);
        EditText usernameEditText = findViewById(R.id.usernameEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);
        EditText phoneEditText = findViewById(R.id.phoneEditText);
        EditText emailEditText = findViewById(R.id.emailEditText);
        RadioGroup sexRadioGroup = findViewById(R.id.sexRadioGroup);

        setSpinner(usernameSpinner);

        usernameSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                SQLiteDatabase db = myDBHelper.getReadableDatabase();
                String sql = "SELECT * FROM user WHERE username = ?";
                Cursor cursor = db.rawQuery(sql, new String[]{usernameSpinner.getSelectedItem().toString()});
                if (cursor.getCount() == 0)
                {
                    return;
                }
                while (cursor.moveToNext())
                {
                    usernameEditText.setText(cursor.getString(0));
                    passwordEditText.setText(cursor.getString(1));
                    phoneEditText.setText(cursor.getString(2));
                    emailEditText.setText(cursor.getString(3));
                    if (cursor.getString(4).equals("男"))
                    {
                        RadioButton checked = sexRadioGroup.findViewById(R.id.sexMale);
                        checked.setChecked(true);
                    }
                    else
                    {
                        RadioButton checked = sexRadioGroup.findViewById(R.id.sexFemale);
                        checked.setChecked(true);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {
            }
        });

        Button insertButton = findViewById(R.id.insertButton);
        insertButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                SQLiteDatabase db = myDBHelper.getWritableDatabase();
                String username = usernameEditText.getText().toString();
                String sql1 = "INSERT INTO user(username, password, phone, email, sex) VALUES (?, ?, ?, ?, ?)";
                String sql2 = "SELECT username FROM user WHERE username = ?";
                Cursor cursor = db.rawQuery(sql2, new String[]{username});
                if (cursor.getCount() != 0)
                {
                    Toast.makeText(getApplicationContext(), "用户名重复，添加失败！", Toast.LENGTH_LONG).show();
                    return;
                }
                String password = passwordEditText.getText().toString();
                String phone = phoneEditText.getText().toString();
                String email = emailEditText.getText().toString();
                RadioButton sexRadioButton = findViewById(sexRadioGroup.getCheckedRadioButtonId());
                String sex = sexRadioButton.getText().toString();
                db.execSQL(sql1, new Object[]{username, password, phone, email, sex});
                setSpinner(usernameSpinner);
                Toast.makeText(getApplicationContext(), "添加成功！", Toast.LENGTH_LONG).show();
            }
        });

        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                SQLiteDatabase db = myDBHelper.getWritableDatabase();
                String sql = "UPDATE user SET username = ?, password = ?, phone = ?, email = ?, sex = ? WHERE username = ?";
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String phone = phoneEditText.getText().toString();
                String email = emailEditText.getText().toString();
                RadioButton sexRadioButton = findViewById(sexRadioGroup.getCheckedRadioButtonId());
                String sex = sexRadioButton.getText().toString();
                db.execSQL(sql, new Object[]{username, password, phone, email, sex});
            }
        });

        Button deleteButton = findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                SQLiteDatabase db = myDBHelper.getWritableDatabase();
                String sql = "DELETE FROM user WHERE username = ?";
                String username = usernameEditText.getText().toString();
                db.execSQL(sql, new Object[]{username});
                setSpinner(usernameSpinner);
                Toast.makeText(getApplicationContext(), "删除成功！", Toast.LENGTH_LONG).show();
            }
        });

        Button clearButton = findViewById(R.id.clearButton);
        clearButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                usernameEditText.setText("");
                passwordEditText.setText("");
                phoneEditText.setText("");
                emailEditText.setText("");
                RadioButton sexRadioButton = sexRadioGroup.findViewById(R.id.sexMale);
                sexRadioButton.setChecked(true);
            }
        });
    }

    private void setSpinner(Spinner spinner)
    {
        List<String> list = new ArrayList<String>();
        SQLiteDatabase db = myDBHelper.getReadableDatabase();
        String sql = "SELECT username FROM user";
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.getCount() == 0)
        {
            list.add("当前无用户信息");
        }
        else
        {
            while (cursor.moveToNext())
            {
                int index = cursor.getColumnIndex("username");
                String a = cursor.getString(index);
                list.add(a);
            }
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this, R.layout.item_select, list);
        spinner.setAdapter(arrayAdapter);
    }
}