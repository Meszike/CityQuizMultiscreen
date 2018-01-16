package com.example.popey.cityquizmultiscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by POPEY on 2018. 01. 15..
 */


public class Third_Question extends AppCompatActivity {

    ImageView questionImage;
    TextView question, solution;
    EditText txtAnswer;
    Button checkButton, next;
    public int total;
    public int QuestionNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text);

        Bundle extras = getIntent().getExtras();
        total = extras.getInt("total");
        QuestionNumber = extras.getInt("QuestionNumber");
        questionImage = findViewById(R.id.questionImage);
        question = findViewById(R.id.question);
        solution = findViewById(R.id.solution);
        txtAnswer = findViewById(R.id.txtAnswer);
        checkButton = findViewById(R.id.submit_button);
        next = findViewById(R.id.next);
        questionImage.setImageResource(R.drawable.question3);
    }

    public void submitButton(View view) {
        String answer = txtAnswer.getText().toString().toLowerCase().trim();
        if (answer.equals("london")) {
            total += 1;
            solution.setText(getString(R.string.correct));

        } else {
            solution.setText(getString(R.string.wrong_solution) + " " + (getString(R.string.good_answer1)));
        }
        checkButton.setVisibility(View.INVISIBLE);
        next.setVisibility(View.VISIBLE);

    }

    //checkButton click
    public void next(View view) {
        QuestionNumber += 1;
        Intent nextQuestion = (new Intent(Third_Question.this, Fourth_Question.class));
        nextQuestion.putExtra("total", total);
        nextQuestion.putExtra("QuestionNumber", QuestionNumber);
        startActivity(nextQuestion);


    }

}
