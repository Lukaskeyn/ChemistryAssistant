package com.example.chemistryassistant;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class ChemistryMode extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {

    private Button back, toPeriodic;
    private EditText molecularWeight;
    private EditText density;
    private EditText massFraction;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chemistry_mode_page);

        back = findViewById(R.id.backOnStartPage);
        toPeriodic = findViewById(R.id.toPeriodicTableButton);
        molecularWeight = findViewById(R.id.molecularWeightValue);
        density = findViewById(R.id.densityValue);
        Spinner flaskVolumeValue = findViewById(R.id.um_flaskVolumeValue);
        massFraction = findViewById(R.id.massFractionValue);
            if(molecularWeight.getText().toString().length() < 1) {
                molecularWeight.setText(getIntent().getStringExtra("molecular_weight"));
            }
        back.setOnClickListener(v -> {
            Intent switchOnMainPage = new Intent(this, MainActivity.class);
            startActivity(switchOnMainPage);
        });
        toPeriodic.setOnClickListener(v -> {
            Intent switchOnPeriodicTable = new Intent(this, PeriodicTable.class);
            switchOnPeriodicTable.putExtra("molecular_weight",molecularWeight.getText().toString());
            startActivity(switchOnPeriodicTable);
        });


        Spinner umMolecularWeight = findViewById(R.id.em_mWeight);
        ArrayAdapter<CharSequence> mwAdapter = ArrayAdapter.createFromResource(this, R.array.mWeight, android.R.layout.simple_spinner_item);
        spinners(umMolecularWeight,mwAdapter);

        Spinner umDensity = findViewById(R.id.um_density);
        ArrayAdapter<CharSequence> densityAdapter = ArrayAdapter.createFromResource(this, R.array.density, android.R.layout.simple_spinner_item);
        spinners(umDensity,densityAdapter);

        Spinner massFraction = findViewById(R.id.um_mass_fraction);
        ArrayAdapter<CharSequence> massFractionAdapter = ArrayAdapter.createFromResource(this, R.array.u_m_volume_mass, android.R.layout.simple_spinner_item);
        spinners(massFraction,massFractionAdapter);


        ArrayAdapter<CharSequence> flaskVolumeAdapter = ArrayAdapter.createFromResource(this, R.array.volumeOfFlaskValue, android.R.layout.simple_spinner_item);
        spinners(flaskVolumeValue,flaskVolumeAdapter);

        Spinner flaskVolumeUM = findViewById(R.id.um_flaskVolume);
        ArrayAdapter<CharSequence> flaskVolumeUmAdapter = ArrayAdapter.createFromResource(this, R.array.volumeOfFlask, android.R.layout.simple_spinner_item);
        spinners(flaskVolumeUM,flaskVolumeUmAdapter);

        Spinner concentrationUM = findViewById(R.id.um_concentration);
        ArrayAdapter<CharSequence> concentrationAdapter = ArrayAdapter.createFromResource(this, R.array.u_m_concentration, android.R.layout.simple_spinner_item);
        spinners(concentrationUM,concentrationAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public  void clear(View view){
        density.setText("");
        molecularWeight.setText("");
        massFraction.setText("");
    }
    public void spinners(Spinner spinner, ArrayAdapter<CharSequence> adapter) {
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
       spinner.setOnItemSelectedListener(this);
    }
}