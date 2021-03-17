package com.Component1.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    Button btn_next , btn_previous;
    RadioGroup radioGroup;
    String[][] questionList;
    TextView txt_question;
    RadioButton rb1,rb2,rb3,rb4;
    RadioGroup rgquiz;
    int numberofQuestions = 0, score= 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

       String user_Name = getIntent().getStringExtra("User_Name");
        setTitle(getResources().getString(R.string.app_name)+" : "+user_Name);
       // Toast toast = Toast.makeText(QuizActivity.this,User_Name,Toast.LENGTH_LONG);
      //  toast.show();

        btn_next = (Button) findViewById(R.id.btn_quiz_activity_next);
        btn_previous=(Button) findViewById(R.id.btn_quiz_activity_previous);
        txt_question = (TextView) findViewById(R.id.txt_quiz_activity_question);
        rb1 = (RadioButton) findViewById(R.id.rb_quiz_activity_opt1);
        rb2 = (RadioButton) findViewById(R.id.rb_quiz_activity_opt2);
        rb3 = (RadioButton) findViewById(R.id.rb_quiz_activity_opt3);
        rb4 = (RadioButton) findViewById(R.id.rb_quiz_activity_opt4);
        rgquiz = (RadioGroup) findViewById(R.id.rg_quiz_activity);
        questionList = getQuestion();
        displayQuestions();

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getScore();
                if(numberofQuestions==4) {
                    Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                    intent.putExtra("User_Name",user_Name);
                    intent.putExtra("score",score);
                    startActivity(intent);
                    finish();
                }else{
                    numberofQuestions++;
                    displayQuestions();
                }
            }
        });
    }

    //To retrieve Question From the string.xml
    String[][] getQuestion(){
        String[][] questionList = new String[5][6];

        //Fetching data from question array in string.xml file
        String[] questions = getResources().getStringArray(R.array.question);

        for(int i = 0;i<5;i++){

            //splitting our question into array using delimeter
            String [] question = questions[i].split(",");
            for(int j= 0; j<6;j++){

                //populating question list
                questionList[i][j] = question[j];

            }
        }

                return questionList;
    }

    void displayQuestions(){
        txt_question.setText(questionList[numberofQuestions][0]);
        rb1.setText(questionList[numberofQuestions][1]);
        rb2.setText(questionList[numberofQuestions][2]);
        rb3.setText(questionList[numberofQuestions][3]);
        rb4.setText(questionList[numberofQuestions][4]);

        ((RadioButton)rgquiz.getChildAt(3)).setText(questionList[numberofQuestions][4]);
        rb1.setChecked(false);
        rb2.setChecked(false);
        rb3.setChecked(false);
        rb4.setChecked(false);
    }

    void getScore(){
        int answerid = rgquiz.getCheckedRadioButtonId();
        RadioButton answer = (RadioButton) findViewById(answerid);
        if(answer.getText()==questionList[numberofQuestions][5]){
            score++;
        }

    }
}