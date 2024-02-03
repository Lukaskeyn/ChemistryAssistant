package com.example.chemistryassistant;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    ImageView normalModeButton, chemistryModeButton;
    TextView developerPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page);
        normalModeButton = findViewById(R.id.imageButtonNormalMode);
        chemistryModeButton = findViewById(R.id.imageButtonChemistryMode);
        developerPage = findViewById(R.id.author);
        normalModeButton.setOnClickListener(v -> {
            Intent switchOnNormalModePage = new Intent(this, NormalMode.class);
            startActivity(switchOnNormalModePage);
        });
        chemistryModeButton.setOnClickListener(v -> {
            Intent switchOnChemistryModePage = new Intent(this, ChemistryMode.class);
            startActivity(switchOnChemistryModePage);
        });
        developerPage.setOnClickListener(v ->  {
            goToDeveloperPage(developerPage);
        });
    }

    public void goToDeveloperPage(View view) {
        goToUrl("https://github.com/Lukaskeyn");
    }

    private void goToUrl(String url) {
        Uri uri = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(launchBrowser);
    }
}