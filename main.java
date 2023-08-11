package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView questionTextView;
    private Button option1Button, option2Button, option3Button, option4Button;

    private String[] questions = {
            "What is the capital of France?",
            "Which planet is known as the Red Planet?",
            // Add more questions here
    };

    private String[][] options = {
            {"Paris", "London", "Berlin", "Madrid"},
            {"Mars", "Jupiter", "Venus", "Saturn"},
            // Add more options for each question here
    };

    private int[] correctAnswers = {0, 0, /* Add correct answers for each question here */};
    private int currentQuestion = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTextView = findViewById(R.id.questionTextView);
        option1Button = findViewById(R.id.option1Button);
        option2Button = findViewById(R.id.option2Button);
        option3Button = findViewById(R.id.option3Button);
        option4Button = findViewById(R.id.option4Button);

        updateQuestion();

        option1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(0);
            }
        });

        option2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(1);
            }
        });

        option3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(2);
            }
        });

        option4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(3);
            }
        });
    }

    private void updateQuestion() {
        questionTextView.setText(questions[currentQuestion]);
        option1Button.setText(options[currentQuestion][0]);
        option2Button.setText(options[currentQuestion][1]);
        option3Button.setText(options[currentQuestion][2]);
        option4Button.setText(options[currentQuestion][3]);
    }

    private void checkAnswer(int selectedOption) {
        if (selectedOption == correctAnswers[currentQuestion]) {
            score++;
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Incorrect.", Toast.LENGTH_SHORT).show();
        }

        currentQuestion++;
        if (currentQuestion < questions.length) {
            updateQuestion();
        } else {
            showFinalScore();
        }
    }

    private void showFinalScore() {
        questionTextView.setText("Quiz completed! Your score: " + score + " out of " + questions.length);
        option1Button.setVisibility(View.INVISIBLE);
        option2Button.setVisibility(View.INVISIBLE);
        option3Button.setVisibility(View.INVISIBLE);
        option4Button.setVisibility(View.INVISIBLE);
    }
}
