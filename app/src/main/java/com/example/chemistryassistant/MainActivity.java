package com.example.chemistryassistant;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageView normalModeButton, chemistryModeButton;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page);
        normalModeButton = findViewById(R.id.imageButtonNormalMode);
        chemistryModeButton = findViewById(R.id.imageButtonChemistryMode);
        normalModeButton.setOnClickListener(v -> {
            Intent switchOnNormalModePage = new Intent(this, NormalMode.class);
            startActivity(switchOnNormalModePage);
        });
        chemistryModeButton.setOnClickListener(v -> {
            Intent switchOnChemistryModePage = new Intent(this, ChemistryMode.class);
            startActivity(switchOnChemistryModePage);
        });

    }

}