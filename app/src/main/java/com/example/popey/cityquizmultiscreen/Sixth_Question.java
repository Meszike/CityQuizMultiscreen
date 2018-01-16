package com.example.popey.cityquizmultiscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by POPEY on 2018. 01. 15..
 */

public class Sixth_Question extends AppCompatActivity {

    ImageView image1;
    TextView question;
    RadioGroup g1group;
    RadioButton q1_aButton, q1_bButton, q1_cButton, q1_dButton;
    TextView solution2 = null;
    public int total;
    public int QuestionNumber;
    Button submitButton, next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radio_b);


        Bundle extras = getIntent().getExtras();
        total = extras.getInt("total");
        QuestionNumber = extras.getInt("QuestionNumber");

        //first question global variables
        image1 = findViewById(R.id.questionImage);
        question = findViewById(R.id.question);
        g1group = findViewById(R.id.answers_1);
        q1_aButton = findViewById(R.id.answer_1_a);
        q1_bButton = findViewById(R.id.answer_1_b);
        q1_cButton = findViewById(R.id.answer_1_c);
        q1_dButton = findViewById(R.id.answer_1_d);
        solution2 = findViewById(R.id.solution);
        submitButton = findViewById(R.id.submit_button);
        next = findViewById(R.id.next);
        image1.setImageResource(R.drawable.question6);
        question.setText(R.string.sixth_q);
        q1_aButton.setText(R.string.q_6_a);
        q1_bButton.setText(R.string.q_6_b);
        q1_cButton.setText(R.string.q_6_c);
        q1_dButton.setText(R.string.q_6_d);

    }


    public void submitButton(View view) {
        if (q1_aButton.isChecked() || q1_bButton.isChecked() || q1_cButton.isChecked() || q1_dButton.isChecked()) {
            if (q1_cButton.isChecked()) {
                //if answer is correct
                q1_cButton.setTextColor(ContextCompat.getColor(Sixth_Question.this, R.color.colorGreen));
                solution2.setText(getString(R.string.correct));
                total += 1;

            } else {
                //if answer is not  correct
                q1_aButton.setTextColor(ContextCompat.getColor(Sixth_Question.this, R.color.colorRed));
                q1_bButton.setTextColor(ContextCompat.getColor(Sixth_Question.this, R.color.colorRed));
                q1_dButton.setTextColor(ContextCompat.getColor(Sixth_Question.this, R.color.colorRed));
                solution2.setText(getString(R.string.wrong_solution) + " " + (getString(R.string.q_6_c)));
            }
            submitButton.setVisibility(View.INVISIBLE);
            next.setVisibility(View.VISIBLE);
        } else {
            Toast ToastMessage = Toast.makeText(getApplicationContext(), (R.string.no_selection), Toast.LENGTH_SHORT);
            View toastView = ToastMessage.getView();
            toastView.setBackgroundColor(ContextCompat.getColor(Sixth_Question.this, R.color.colorRed));
            ToastMessage.show();
        }
    }

    //checkButton click
    public void next(View view) {
        QuestionNumber += 1;
        Intent nextQuestion = (new Intent(Sixth_Question.this, Seventh_Question.class));
        nextQuestion.putExtra("total", total);
        nextQuestion.putExtra("QuestionNumber", QuestionNumber);
        startActivity(nextQuestion);
    }

}
