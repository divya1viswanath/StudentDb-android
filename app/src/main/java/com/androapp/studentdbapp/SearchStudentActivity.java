package com.androapp.studentdbapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SearchStudentActivity extends AppCompatActivity {

    EditText ed1,ed2,ed3,ed4;
    AppCompatButton b1,b2;
    String getAdno,getName,getRol,getcol;
    DatabaseHelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_student);
        dbhelper=new DatabaseHelper(this);
        dbhelper.getWritableDatabase();
        ed1=(EditText) findViewById(R.id.adno);
        ed2=(EditText) findViewById(R.id.name);
        ed3=(EditText) findViewById(R.id.roll);
        ed4=(EditText) findViewById(R.id.col);
        b1=(AppCompatButton) findViewById(R.id.ser);
        b2=(AppCompatButton)findViewById(R.id.back);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAdno=ed1.getText().toString();
                Cursor c= dbhelper.searchData(getAdno);
                if (c.getCount()==0)
                {
                    ed2.setText("");
                    ed3.setText("");
                    ed4.setText("");
                    Toast.makeText(getApplicationContext(), "Invaild Addmission Number", Toast.LENGTH_SHORT).show();
                }
                else {
                    while (c.moveToNext())
                    {
                        getName=c.getString(1);
                        getRol=c.getString(2);
                        getcol=c.getString(4);
                    }
                    ed2.setText(getName);
                    ed3.setText(getRol);
                    ed4.setText(getcol);
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}