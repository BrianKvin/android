package com.example.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button buttonNext;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        buttonNext = findViewById(R.id.ButtonNext);
        sharedPreferences = getPreferences(MODE_PRIVATE);

        String savedName = sharedPreferences.getString("userName", "");
        editText.setText(savedName);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredText = editText.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("userName", enteredText);
                editor.apply();

                Intent intent = new Intent(MainActivity.this, NameActivity.class);

                intent.putExtra("enteredText", enteredText);

                startActivityForResult(intent, 1); 
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == 0) {
                editText.getText().clear();
            } else if (resultCode == 1) {
                finish();
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        String enteredText = editText.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("userName", enteredText);
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();

        editText.getText().clear();
    }
}