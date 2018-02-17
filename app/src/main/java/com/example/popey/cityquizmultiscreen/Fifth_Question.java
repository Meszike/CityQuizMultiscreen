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

public class Fifth_Question extends AppCompatActivity {
    /**
     * Variables and elements
     */
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

        /**
         * Sent score as intent
         */
        Bundle extras = getIntent().getExtras();
        total = extras.getInt("total");
        QuestionNumber = extras.getInt("QuestionNumber");

        /**
         * which fifth question's global variables
         */
        questionImage = findViewById(R.id.questionImage);
        question = findViewById(R.id.question);
        solution = findViewById(R.id.solution);
        txtAnswer = findViewById(R.id.txtAnswer);
        checkButton = findViewById(R.id.submit_button);
        next = findViewById(R.id.next);
        questionImage.setImageResource(R.drawable.question5);
        question.setText(R.string.fifth_q);

    }
    /**
     * submitButton click
     */
    public void submitButton(View view) {
        /**
         * if answer is correct
         */
        String answer = txtAnswer.getText().toString().toLowerCase().trim();
        if (answer.equals("copenhagen")) {
            total += 1;
            solution.setText(getString(R.string.correct));

        } else {
            /**
             * if answer is not correct
             */
            solution.setText(getString(R.string.wrong_solution) + " " + (getString(R.string.good_answer2)));
        }
        /**
         * change button
         */
        checkButton.setVisibility(View.INVISIBLE);
        next.setVisibility(View.VISIBLE);
    }

    /**
     * nextButton click
     */
    public void next(View view) {
        QuestionNumber += 1;
        Intent nextQuestion = (new Intent(Fifth_Question.this, Sixth_Question.class));
        nextQuestion.putExtra("total", total);
        nextQuestion.putExtra("QuestionNumber", QuestionNumber);
        startActivity(nextQuestion);

    }


}
