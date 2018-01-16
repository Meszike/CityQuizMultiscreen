package com.example.popey.cityquizmultiscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by POPEY on 2018. 01. 15..
 */

public class Second_Question extends AppCompatActivity {
    //global variables
    ImageView questionImage;
    TextView question;
    CheckBox choice1, choice2, choice3, choice4;
    TextView solution = null;
    Button submitButton, next;
    public int total;
    public int QuestionNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_b);
//sent score as intent
        Bundle extras = getIntent().getExtras();
        total = extras.getInt("total");
        QuestionNumber = extras.getInt("QuestionNumber");

//which second question global variables
        questionImage = findViewById(R.id.questionImage);
        question = findViewById(R.id.question);
        choice1 = findViewById(R.id.choice_1);
        choice2 = findViewById(R.id.choice_2);
        choice3 = findViewById(R.id.choice_3);
        choice4 = findViewById(R.id.choice_4);
        solution = findViewById(R.id.solution);
        submitButton = findViewById(R.id.submit_button);
        next = findViewById(R.id.next);
        questionImage.setImageResource(R.drawable.question2);

    }

    //submitButton click
    public void submitButton(View view) {
        //if there is an answer
        if (choice1.isChecked() || choice2.isChecked() || choice3.isChecked() || choice4.isChecked()) {

            if (choice1.isChecked() && choice2.isChecked()) {
                //if answer is correct
                choice1.setTextColor(ContextCompat.getColor(Second_Question.this, R.color.colorGreen));
                choice2.setTextColor(ContextCompat.getColor(Second_Question.this, R.color.colorGreen));
                solution.setText(getString(R.string.correct));
                total += 1;

            } else {
                //if answer is not  correct
                choice3.setTextColor(ContextCompat.getColor(Second_Question.this, R.color.colorRed));
                choice4.setTextColor(ContextCompat.getColor(Second_Question.this, R.color.colorRed));
                solution.setText(getString(R.string.wrong_solutions) + " " + (getString(R.string.q_2_a)) + ", " + (getString(R.string.q_2_b)));
            }
            //change button
            submitButton.setVisibility(View.INVISIBLE);
            next.setVisibility(View.VISIBLE);
        } else {
            Toast ToastMessage = Toast.makeText(getApplicationContext(), (R.string.no_selection), Toast.LENGTH_SHORT);
            View toastView = ToastMessage.getView();
            toastView.setBackgroundColor(ContextCompat.getColor(Second_Question.this, R.color.colorRed));
            ToastMessage.show();
        }


    }

    //checkButton click
    public void next(View view) {

        QuestionNumber += 1;
        Intent nextQuestion = (new Intent(Second_Question.this, Third_Question.class));
        nextQuestion.putExtra("total", total);
        nextQuestion.putExtra("QuestionNumber", QuestionNumber);
        startActivity(nextQuestion);


    }


}
