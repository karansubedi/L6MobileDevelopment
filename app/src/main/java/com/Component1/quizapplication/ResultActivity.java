package com.Component1.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView txt_name ,txt_score;
    Button btn_finish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        String username = getIntent().getStringExtra("User_Name");

        int score = getIntent().getIntExtra("score",0);
        txt_name = (TextView) findViewById(R.id.tv_result_activity_name);
        txt_score = (TextView) findViewById(R.id.tv_result_activity_score);
        btn_finish = (Button) findViewById(R.id.btn_result_activity_finish);

        txt_name.setText(username);
        txt_score.setText(Integer.toString(score));
        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               System.exit(0);
            }
        });
    }
}