package com.example.filmquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.filmquizz.pojos.Question;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tvQuestion;
    private TextView tvScrore;
    private Button btnTrue;
    private Button btnFalse;
    private Button btnRestart;
    private List<Question> questions = new ArrayList<>();
    private int indexQuestion = 0;
    private int score = 0;
    private Question question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvQuestion = findViewById(R.id.tvQuestion);
        tvScrore = findViewById(R.id.tvScrore);
        btnTrue = findViewById(R.id.buttonTrue);
        btnFalse = findViewById(R.id.buttonFalse);
        btnRestart = findViewById(R.id.buttonRestart);

        questions.add(new Question(getString(R.string.question_ai), true));
        questions.add(new Question(getString(R.string.question_taxi_driver), true));
        questions.add(new Question(getString(R.string.question_2001), false));
        questions.add(new Question(getString(R.string.question_reservoir_dogs), true));
        questions.add(new Question(getString(R.string.question_citizen_kane), false));

        question = questions.get(indexQuestion);
        tvQuestion.setText(question.getText());
        tvScrore.setText("Votre score est de : "+score);


        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testQuestion(true);
            }
        });

        btnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testQuestion(false);
            }
        });

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score = 0;
                indexQuestion = 0;
                tvScrore.setText("Votre score est de : "+score);
                tvQuestion.setText(question.getText());
                btnRestart.setVisibility(View.INVISIBLE);
            }
        });

    }

    public void testQuestion(boolean test){
        if (question.isAnswer() == test && indexQuestion <= questions.size()){
            score++;
            tvScrore.setText("Votre score est de : "+score);
        }
        indexQuestion++;
        if(indexQuestion < questions.size()){
            question = questions.get(indexQuestion);
            tvQuestion.setText(question.getText());
        }
        else{
            tvQuestion.setText("Le jeu est terminer");
            btnRestart.setVisibility(View.VISIBLE);
        }
    }
}