package com.Component1.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Userdetails extends AppCompatActivity {

    EditText name;
    Button buttonok ,buttoncancel;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdetails);

        name = findViewById(R.id.txt_activity_userdetails_name);
        buttonok = (Button) findViewById(R.id.btn_activity_userdetails_ok);
        buttoncancel = (Button) findViewById(R.id.btn_activity_userdetails_cancel);

        buttoncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

        buttonok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!validateName()){
                    return;
                }
                else{
                    Intent intent = new Intent(Userdetails.this,QuizActivity.class);
                    startActivity(intent);
                    String nameval = name.getText().toString();
                    intent.putExtra("User_Name",nameval);
                    finish();
                }
            }
        });

    }

    private Boolean validateName(){
        String val = name.getText().toString();

        if(val.isEmpty()){
            name.setError("Field Cannot be Empty");
            return false;
        }
        else{
            name.setError(null);
            return true;
        }
    }
}