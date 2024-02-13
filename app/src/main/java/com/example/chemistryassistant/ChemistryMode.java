package com.example.chemistryassistant;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

public class ChemistryMode extends AppCompatActivity {

    private Button back, toPeriodic;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chemistry_mode_page);

        back = findViewById(R.id.backOnStartPage);
        toPeriodic = findViewById(R.id.toPeriodicTableButton);
        back.setOnClickListener(v -> {
            Intent switchOnMainPage = new Intent(this, MainActivity.class);
            startActivity(switchOnMainPage);
        });
        toPeriodic.setOnClickListener(v -> {
            Intent switchOnPeriodicTable = new Intent(this, PeriodicTable.class);
            startActivity(switchOnPeriodicTable);
        });

    }
}