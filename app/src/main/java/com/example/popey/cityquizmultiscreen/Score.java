package com.example.popey.cityquizmultiscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by POPEY on 2018. 01. 15..
 */

public class Score extends AppCompatActivity {
    public int total = 0;
    public int QuestionNumber;
    TextView scoreView, sumView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score);
        Bundle extras = getIntent().getExtras();

        /**
         * Display score on the screen.
         */
        scoreView = findViewById(R.id.right);
        total = extras.getInt("total");
        scoreView.setText(String.valueOf(total));
        sumView = findViewById(R.id.sum);
        QuestionNumber = extras.getInt("QuestionNumber");
        sumView.setText(String.valueOf(QuestionNumber));
    }

       /**
       * Restart the app.
       */
    public void restartButton(View view) {
        finish();
        Intent intent = new Intent(Score.this, MainActivity.class);
        startActivity(intent);

    }


}
