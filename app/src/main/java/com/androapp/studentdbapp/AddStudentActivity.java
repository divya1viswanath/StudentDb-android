package com.androapp.studentdbapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudentActivity extends AppCompatActivity {

    EditText ed1,ed2,ed3,ed4;
    AppCompatButton b1,b2;
    String getName,getAdno,getRoll,getCol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        ed1=(EditText)findViewById(R.id.name);
        ed2=(EditText) findViewById(R.id.adno);
        ed3=(EditText) findViewById(R.id.roll);
        ed4=(EditText) findViewById(R.id.col);
        b1=(AppCompatButton) findViewById(R.id.sub);
        b2=(AppCompatButton) findViewById(R.id.menu);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getName=ed1.getText().toString();
                getAdno=ed2.getText().toString();
                getRoll=ed3.getText().toString();
                getCol=ed4.getText().toString();
                Toast.makeText(getApplicationContext(),getName, Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), getAdno, Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), getRoll, Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), getCol, Toast.LENGTH_SHORT).show();
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