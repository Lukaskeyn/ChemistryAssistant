package com.example.chemistryassistant;


import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ChemistryMode extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {

    private Button back, toPeriodic;
    private EditText molecularWeight,density,massFraction,concentrationX,concentration;
    private  TextView volumeXView,formulaView;
     private Spinner flaskVolumeValue,volumeXUM,umMolecularWeight,umDensity,massFractionUM,flaskVolumeUM,concentrationUM,concentrationXUM,function;
  private  int check;






    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chemistry_mode_page);

        check = 0;
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


        umMolecularWeight = findViewById(R.id.em_mWeight);
        ArrayAdapter<CharSequence> mwAdapter = ArrayAdapter.createFromResource(this, R.array.mWeight, android.R.layout.simple_spinner_item);
        spinners(umMolecularWeight, mwAdapter);
        umMolecularWeight.setPrompt("Units of measurement");
        molecularWeight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (molecularWeight.getText().toString().length() == 9) {
                    showInfo("The line is max size");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



         umDensity = findViewById(R.id.um_density);
        ArrayAdapter<CharSequence> densityAdapter = ArrayAdapter.createFromResource(this, R.array.density, android.R.layout.simple_spinner_item);
        spinners(umDensity, densityAdapter);
        umDensity.setPrompt("Units of measurement");
        density.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (density.getText().toString().length() == 9) {
                    showInfo("The line is max size");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

         massFractionUM = findViewById(R.id.um_mass_fraction);
        ArrayAdapter<CharSequence> massFractionAdapter = ArrayAdapter.createFromResource(this, R.array.u_m_volume_mass, android.R.layout.simple_spinner_item);
        spinners(massFractionUM, massFractionAdapter);
        massFractionUM.setPrompt("Units of measurement");
        massFraction.setFilters(new InputFilter[]{new InputFilterMinMax("0", "100.0"), new InputFilter.LengthFilter(7)});
        massFraction.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (massFraction.getText().toString().length() == 7) {
                    showInfo("The line is max size");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



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
        concentration.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (concentration.getText().toString().length() == 9) {
                    showInfo("The line is max size");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

         concentrationXUM = findViewById(R.id.um_concentrationX);
        ArrayAdapter<CharSequence> concentrationXAdapter = ArrayAdapter.createFromResource(this, R.array.u_m_concentration, android.R.layout.simple_spinner_item);
        spinners(concentrationXUM, concentrationXAdapter);
        concentrationXUM.setPrompt("Units of measurement");
        concentrationX.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (concentrationX.getText().toString().length() == 9) {
                    showInfo("The line is max size");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

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
               if(++check > 1 && check < 3) {
                   alertDialogBuilder(function);
               }
           }
           else if(id == 1) {
               formulaView.setText(R.string.formula_preparationMol);
               if(check < 2) {
                   alertDialogBuilder(function);
               }
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
        if(!stringIsEmpty(c)) {
            concentration.setBackgroundResource(R.drawable.editextborder);
        }
       if(!stringIsEmpty(cX)) {
            concentrationX.setBackgroundResource(R.drawable.editextborder);
        }
         if(!stringIsEmpty(mW)) {
            molecularWeight.setBackgroundResource(R.drawable.editextborder);
        }
         if(!stringIsEmpty(w)) {
            massFraction.setBackgroundResource(R.drawable.editextborder);
        }
         if(!stringIsEmpty(p)) {
            density.setBackgroundResource(R.drawable.editextborder);
        }
        if(concentrationUM.getSelectedItemId() == 0) {
            concentrationUM.setBackgroundResource(R.drawable.stylespinner);
        }
    if(view.getId() == R.id.calculateButton && function.getSelectedItemId() == 0) {

      if(!stringIsEmpty(c) && !stringIsEmpty(cX) ) {
          if(Double.parseDouble(c) <= Double.parseDouble(cX)){
              showInfo("concentration must be more then Cx");
          }
          else {
          vX = (Double.parseDouble(cX) * Double.parseDouble(vF)) / Double.parseDouble(c);
          volumeXView.setText(String.valueOf(vX));}

      }
      else  {
          if(stringIsEmpty(c)){
              concentration.setError("error");
              showInfo("Please, fill concentration field");
              concentration.setBackgroundResource(R.drawable.borderedittexterror);
          }
            else if(stringIsEmpty(cX)){
              concentrationX.setError("error");
              showInfo("Please, fill Cx field");
              concentrationX.setBackgroundResource(R.drawable.borderedittexterror);
          }
      }
    }
    else if(view.getId() == R.id.calculateButton && function.getSelectedItemId() == 1) {
        if(concentrationXUM.getSelectedItemId() != 0) {
            showInfo("Please, set concentration u.m.  to mol/l");
            concentrationXUM.setBackgroundResource(R.drawable.stylespinnererror);
        }

        if (!stringIsEmpty(cX) && !stringIsEmpty(w) && !stringIsEmpty(mW) && !stringIsEmpty(p) && concentrationXUM.getSelectedItemId() == 0) {
            vX = ((Double.parseDouble(cX) * Double.parseDouble(mW))) / (Double.parseDouble(p) * (Double.parseDouble(w) / 100));
            vX = (Double.parseDouble(vF) * vX) / 1000;
            volumeXView.setText(String.valueOf(vX));
        } else {
            if(stringIsEmpty(cX)){
                concentrationX.setError("error");
                showInfo("Please, fill Cx field");
                concentrationX.setBackgroundResource(R.drawable.borderedittexterror);
            }
            else if(stringIsEmpty(p)){
                density.setError("error");
                showInfo("Please, fill density field");
                density.setBackgroundResource(R.drawable.borderedittexterror);
            }
               else if(stringIsEmpty(mW)){
                    molecularWeight.setError("error");
                    showInfo("Please, fill molecular weight field");
                    molecularWeight.setBackgroundResource(R.drawable.borderedittexterror);
                }
            else if(stringIsEmpty(w)){
                massFraction.setError("error");
                showInfo("Please, fill mass fraction field");
                massFraction.setBackgroundResource(R.drawable.borderedittexterror);
            }
        }


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
  public void alertDialogBuilder(Spinner function) {
      if (function.getSelectedItemId() == 0) {
          AlertDialog.Builder dialog = new AlertDialog.Builder(this);
          dialog.setTitle("Dilution of solution");
          dialog.setMessage("\tThis function allows dilution of the solution of concentration \"c\" to concentration \"Cx\".\n\tFill in the following parameters:\n\"Vf\" - volume of the flask.\n\"c\" -  initial concentration of the solution.\n\"Cx\" -  concentration of the new solution.");
          dialog.setCancelable(true);
          dialog.setIcon(R.drawable.greenflask);
          dialog.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                  dialog.cancel();
              }
          });
          AlertDialog help = dialog.create();
          help.show();
      } else if (function.getSelectedItemId() == 1) {
          AlertDialog.Builder dialog = new AlertDialog.Builder(this);
          dialog.setTitle("Preparation of a molar concentration solution(mol/l)");
          dialog.setMessage("\tThis function allows you to prepare a solution of the required molar concentration.\n" +
                  "        \tFill in the following parameters:\n" +
                  "        \"Vf\" - the volume of the flask.\n" +
                  "        \"Cx\" - concentration of the new solution(mol/l).\n" +
                  "        \"p\" - density of the solution.\n" +
                  "        \"M\" - molecular weight of the substance.\n" +
                  "        \"w\" - mass fraction of the substance.");
          dialog.setCancelable(true);
          dialog.setIcon(R.drawable.blueflask);
          dialog.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                  dialog.cancel();
              }
          });
          AlertDialog help = dialog.create();
          help.show();
      }
  }
}