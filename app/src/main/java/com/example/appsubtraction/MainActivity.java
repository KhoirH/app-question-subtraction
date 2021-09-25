package com.example.appsubtraction;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int randText1;
    int randText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createQuestion();
    }

    private void createQuestion() {
        TextView tv = findViewById(R.id.soalTest);

        randText1 = (int) (10 + Math.random()* 90);
        randText2 = (int) (10 + (Math.random() * (randText1 - 10)));

        tv.setText("" + randText1 + " - " + randText2);
    }

    public void answerQuestion(View v) {
        EditText answerComponent = findViewById(R.id.answer);
        TextView messageComponent = findViewById(R.id.message);

        messageComponent.setVisibility(View.VISIBLE);
        int answer;
        try {
            answer = Integer.parseInt(answerComponent.getText().toString());
        } catch (Exception e) {
            answerComponent.setText("0");
            answer = 0;
        }

        if (answer == (randText1 - randText2)) {
            messageComponent.setText("Selamat jawaban anda benar");
        } else {
            messageComponent.setText("Jawaban anda Salah seharusnya hasil dari " + randText1 + " - " + randText2 + " adalah " + (randText1 - randText2));
        }
    }
    public void changesQuestion(View v) {
        EditText answerComponent = findViewById(R.id.answer);
        TextView messageComponent = findViewById(R.id.message);
        answerComponent.setText("");
        messageComponent.setVisibility(View.GONE);
        createQuestion();
    }
}