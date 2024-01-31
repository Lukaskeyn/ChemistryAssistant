package com.example.chemistryassistant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NormalMode extends AppCompatActivity {
    private TextView resultTextView;
    private Button backOnPreviousPage;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.normal_mode_page);

        resultTextView = findViewById(R.id.ResultView);

        backOnPreviousPage = findViewById(R.id.BackPageNButton);
        backOnPreviousPage.setOnClickListener(v -> {
            Intent switchOnMainPage = new Intent(this, MainActivity.class);
            startActivity(switchOnMainPage);
        } );
    }
    public void clickNumber(View view) {
        String number = resultTextView.getText().toString();
        if (view.getId() == R.id.button0)
            number = number + "0";
        else if (view.getId() == R.id.button1)
            number = number + "1";
        else if (view.getId() == R.id.button2)
            number = number + "2";
        else if (view.getId() == R.id.button3)
            number = number + "3";
        else if (view.getId() == R.id.button4)
            number = number + "4";
        else if (view.getId() == R.id.button5)
            number = number + "5";
        else if (view.getId() == R.id.button6)
            number = number + "6";
        else if (view.getId() == R.id.button7)
            number = number + "7";
        else  if (view.getId() == R.id.button8)
            number = number + "8";
        else if (view.getId() == R.id.button9)
            number = number + "9";
        else number = "Что-то пошло не так";

        resultTextView.setText(number);
    }

}