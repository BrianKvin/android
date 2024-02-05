package com.example.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class NameActivity extends AppCompatActivity {

    private TextView newGreetings;
    private Button neverCallMeThatButton;
    private Button thankYouButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        newGreetings = findViewById(R.id.newGreetings);
        neverCallMeThatButton = findViewById(R.id.NeverCallMeThat);
        thankYouButton = findViewById(R.id.ThankYou);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("enteredText")) {
            String userName = intent.getStringExtra("enteredText");

            newGreetings.setText(getString(R.string.welcome_message, userName));
        }

        neverCallMeThatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(0);
                finish();
            }
        });

        thankYouButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(1);
                finish();
            }
        });
    }
}
