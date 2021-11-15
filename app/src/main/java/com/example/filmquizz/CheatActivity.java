package com.example.filmquizz;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.filmquizz.pojos.Question;

public class CheatActivity extends AppCompatActivity {

    private TextView tvReponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        tvReponse = findViewById(R.id.tvReponse);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        // recup l'intent qui a appelé cette activité
        Intent intent = getIntent();

        //recup question
        Question question = (Question)intent.getSerializableExtra(MainActivity.KEY_QUESTION);
        tvReponse.setText(String.format("%s : %s",question.getText(),question.isAnswer()));


    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}