package com.example.chemistryassistant;


import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
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
    private EditText molecularWeight,density,massFraction,concentrationX,concentration;
    private  TextView volumeXView,formulaView;
     private Spinner flaskVolumeValue,volumeXUM,umMolecularWeight,umDensity,massFractionUM,flaskVolumeUM,concentrationUM,concentrationXUM,function;



    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chemistry_mode_page);




        back = findViewById(R.id.backOnStartPage);
        toPeriodic = findViewById(R.id.toPeriodicTableButton);
        molecularWeight = findViewById(R.id.molecularWeightValue);
        density = findViewById(R.id.densityValue);
        concentrationX = findViewById(R.id.concentrationValueX);
        flaskVolumeValue = findViewById(R.id.um_flaskVolumeValue);
        massFraction = findViewById(R.id.massFractionValue);
        volumeXView = findViewById(R.id.volumeX);
        concentration = findViewById(R.id.concentrationValue);
        formulaView = findViewById(R.id.formulas);
        if (molecularWeight.getText().toString().length() < 1) {
            molecularWeight.setText(getIntent().getStringExtra("molecular_weight"));
        }
        back.setOnClickListener(v -> {
            Intent switchOnMainPage = new Intent(this, MainActivity.class);
            startActivity(switchOnMainPage);

        });
        toPeriodic.setOnClickListener(v -> {
            Intent switchOnPeriodicTable = new Intent(this, PeriodicTable.class);
            switchOnPeriodicTable.putExtra("molecular_weight", molecularWeight.getText().toString());

            startActivity(switchOnPeriodicTable);

        });
        massFraction.setFilters(new InputFilter[]{new InputFilterMinMax("0.0", "100.0")});

        umMolecularWeight = findViewById(R.id.em_mWeight);
        ArrayAdapter<CharSequence> mwAdapter = ArrayAdapter.createFromResource(this, R.array.mWeight, android.R.layout.simple_spinner_item);
        spinners(umMolecularWeight, mwAdapter);
        umMolecularWeight.setPrompt("Units of measurement");

         umDensity = findViewById(R.id.um_density);
        ArrayAdapter<CharSequence> densityAdapter = ArrayAdapter.createFromResource(this, R.array.density, android.R.layout.simple_spinner_item);
        spinners(umDensity, densityAdapter);
        umDensity.setPrompt("Units of measurement");

         massFractionUM = findViewById(R.id.um_mass_fraction);
        ArrayAdapter<CharSequence> massFractionAdapter = ArrayAdapter.createFromResource(this, R.array.u_m_volume_mass, android.R.layout.simple_spinner_item);
        spinners(massFractionUM, massFractionAdapter);
        massFractionUM.setPrompt("Units of measurement");


        ArrayAdapter<CharSequence> flaskVolumeAdapter = ArrayAdapter.createFromResource(this, R.array.volumeOfFlaskValue, android.R.layout.simple_spinner_item);
        spinners(flaskVolumeValue, flaskVolumeAdapter);
        flaskVolumeValue.setPrompt("Volume of flask(Vf)");

         flaskVolumeUM = findViewById(R.id.um_flaskVolume);
        ArrayAdapter<CharSequence> flaskVolumeUmAdapter = ArrayAdapter.createFromResource(this, R.array.volumeOfFlask, android.R.layout.simple_spinner_item);
        spinners(flaskVolumeUM, flaskVolumeUmAdapter);
        flaskVolumeUM.setPrompt("Units of measurement");


        concentrationUM = findViewById(R.id.um_concentration);
        ArrayAdapter<CharSequence> concentrationAdapter = ArrayAdapter.createFromResource(this, R.array.u_m_concentration, android.R.layout.simple_spinner_item);
        spinners(concentrationUM, concentrationAdapter);
        concentrationUM.setPrompt("Units of measurement");

         concentrationXUM = findViewById(R.id.um_concentrationX);
        ArrayAdapter<CharSequence> concentrationXAdapter = ArrayAdapter.createFromResource(this, R.array.u_m_concentration, android.R.layout.simple_spinner_item);
        spinners(concentrationXUM, concentrationXAdapter);
        concentrationXUM.setPrompt("Units of measurement");

        volumeXUM = findViewById(R.id.um_volumeX);
        ArrayAdapter<CharSequence> volumeXUMAdapter = ArrayAdapter.createFromResource(this, R.array.volumeX, android.R.layout.simple_spinner_item);
        spinners(volumeXUM, volumeXUMAdapter);
        volumeXUM.setPrompt("Units of measurement");


         function =  findViewById(R.id.function);
        ArrayAdapter<CharSequence> formulasAdapter = ArrayAdapter.createFromResource(this, R.array.function, android.R.layout.simple_spinner_item);
        spinners(function, formulasAdapter);
        function.setPrompt("Function");
    }





    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


       if(parent.getId() == function.getId()) {
           if(id == 0) {
               formulaView.setText(R.string.formula_dilution);
           }
           else if(id == 1) {
               formulaView.setText(R.string.formula_preparationMol);
           }
       }
       else if(parent.getId() == concentrationUM.getId()){
           concentrationXUM.setSelection(position);
       }
       else if(parent.getId() == volumeXUM.getId()) {
           Double result;
           String textResult = "";
           if(id == 0 && !stringIsEmpty(volumeXView.getText().toString())) {
               result = Double.parseDouble(volumeXView.getText().toString()) / 1000;
               textResult =String.valueOf(result);
           }
           else if(id == 1 && !stringIsEmpty(volumeXView.getText().toString())) {
               result = Double.parseDouble(volumeXView.getText().toString()) * 1000;
               textResult =String.valueOf(result);
           }

           volumeXView.setText(textResult);
       }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public  void clear(View view){
        density.setText("");
        molecularWeight.setText("");
        massFraction.setText("");
        concentrationX.setText("");
        volumeXView.setText("");
        concentration.setText("");
    }
    public void spinners(Spinner spinner, ArrayAdapter<CharSequence> adapter) {
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
       spinner.setOnItemSelectedListener(this);
    }
    public void calculate(View view){
        String mW = molecularWeight.getText().toString();
        String w = massFraction.getText().toString();
        String c = concentration.getText().toString();
        String vF = flaskVolumeValue.getSelectedItem().toString();
        String cX = concentrationX.getText().toString();
        String p = density.getText().toString();
        Double vX;
    if(view.getId() == R.id.calculateButton && function.getSelectedItemId() == 0) {
      if(!stringIsEmpty(c) && !stringIsEmpty(cX) ) {
          if(Double.parseDouble(c) <= Double.parseDouble(cX)){
              showInfo("concentration must be more then Cx");
          }
          else {
          vX = (Double.parseDouble(cX) * Double.parseDouble(vF)) / Double.parseDouble(c);
          volumeXView.setText(String.valueOf(vX));}

      }
      else{
 showInfo("Please, fill all required fields");
      }
    }
    else if(view.getId() == R.id.calculateButton && function.getSelectedItemId() == 1) {
        if(!stringIsEmpty(c) && !stringIsEmpty(w) && !stringIsEmpty(mW) && !stringIsEmpty(p) ) {
                vX = ((Double.parseDouble(c) * Double.parseDouble(mW))) / (Double.parseDouble(p) * (Double.parseDouble(w)/100));
                vX = (Double.parseDouble(vF) * vX)/ 1000;
                volumeXView.setText(String.valueOf(vX));
        }

        }
        else{
            showInfo("Please, fill all required fields");
        }

    }
    public void showInfo(String text){
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

   public boolean stringIsEmpty(String s){
        boolean empty;
       if (s.length() < 1) empty = true;
       else empty = false;
        return empty;
   }
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("concentration", concentration.getText().toString());
        savedInstanceState.putString("concentrationX", concentrationX.getText().toString());
        savedInstanceState.putString("massFraction", massFraction.getText().toString());
        savedInstanceState.putInt("flaskVolume", flaskVolumeValue.getSelectedItemPosition());
        savedInstanceState.putString("density", density.getText().toString());
        savedInstanceState.putString("volumeX", volumeXView.getText().toString());
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState != null) {
            concentration.setText(savedInstanceState.getString("concentration"));
            concentrationX.setText(savedInstanceState.getString("concentrationX"));
            massFraction.setText(savedInstanceState.getString("massFraction"));
            flaskVolumeValue.setSelection(savedInstanceState.getInt("flaskVolume"));
            density.setText(savedInstanceState.getString("density"));
            volumeXView.setText(savedInstanceState.getString("volumeX"));
        }
    }

}