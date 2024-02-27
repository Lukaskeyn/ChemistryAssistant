package com.example.chemistryassistant;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

public class PeriodicTable extends AppCompatActivity {
    private Button backOnChemistryMode;
    private Button toPage2;
    private TreeMap<String,Double> allElements = new TreeMap<>();
    public  TextView molecularWeight;
    public TextView currentElement;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.periodic_table_page);

        backOnChemistryMode = findViewById(R.id.backOnChemistryPage);
        toPage2 = findViewById(R.id.toPeriodicTable2);
        molecularWeight = findViewById(R.id.molecularWeightResult);
        currentElement = findViewById(R.id.currentElement);
        backOnChemistryMode.setOnClickListener(v -> {
            Intent switchToChemistryPage = new Intent(this, ChemistryMode.class);
            switchToChemistryPage.putExtra("molecular_weight",molecularWeight.getText().toString());
            startActivity(switchToChemistryPage);
        });
        toPage2.setOnClickListener(v -> {
            Intent switchToPage2 = new Intent(this, PeriodicTable2.class);
            switchToPage2.putExtra("molecular_weight",molecularWeight.getText().toString());
            switchToPage2.putExtra("current_element",currentElement.getText().toString());
            startActivity(switchToPage2);
        });
        molecularWeight.setText(getIntent().getStringExtra("molecular_weight"));
        currentElement.setText(getIntent().getStringExtra("current_element"));
        fillPeriodicTable();
    }
    public void fillPeriodicTable(){
        allElements.put("H",1.00794);
        allElements.put("Li",6.941);
        allElements.put("Be",9.0122);
        allElements.put("B",10.811);
        allElements.put("C",12.011);
        allElements.put("N",14.007);
        allElements.put("Na",22.99);
        allElements.put("Mg",24.305);
        allElements.put("Al",26.9815);
        allElements.put("Si",28.086);
        allElements.put("P",30.974);
        allElements.put("K",39.098);
        allElements.put("Ca",40.08);
        allElements.put("Sc",44.956);
        allElements.put("Ti",47.90);
        allElements.put("Cu",63.546);
        allElements.put("V",50.941);
        allElements.put("Zn",65.39);
        allElements.put("Ga",69.72);
        allElements.put("Ge",72.59);
        allElements.put("As",74.992);
        allElements.put("Rb",85.468);
        allElements.put("Sr",87.62);
        allElements.put("Y",88.906);
        allElements.put("Zr",91.22);
        allElements.put("Nb",92.906);
        allElements.put("Ag",107.868);
        allElements.put("Cd",112.41);
        allElements.put("In",114.82);
        allElements.put("Sn",118.71);
        allElements.put("Sb",121.75);


    }
    public void clickElement(View view) {
        Double mWeight;
        String result = molecularWeight.getText().toString();
        String elementsLine = currentElement.getText().toString();
        String element;
        if (view.getId() == R.id.hydrogen) {
            mWeight = allElements.get("H");
            element = "H";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        } else if (view.getId() == R.id.lithium) {
            mWeight = allElements.get("Li");
            element = "Li";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        } else if (view.getId() == R.id.beryllium) {
            mWeight = allElements.get("Be");
            element = "Be";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
     else if (view.getId() == R.id.borum) {
        mWeight = allElements.get("B");
            element = "B";
        sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
    }
 else if (view.getId() == R.id.carbon) {
        mWeight = allElements.get("C");
            element = "C";
        sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.nitrogen) {
            mWeight = allElements.get("N");
            element = "N";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.sodium) {
            mWeight = allElements.get("Na");
            element = "Na";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.magnesium) {
            mWeight = allElements.get("Mg");
            element = "Mg";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.aluminium) {
            mWeight = allElements.get("Al");
            element = "Al";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.silicon) {
            mWeight = allElements.get("Si");
            element = "Si";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.phosphorus) {
            mWeight = allElements.get("P");
            element = "P";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.potassium) {
            mWeight = allElements.get("K");
            element = "K";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.calcium) {
            mWeight = allElements.get("Ca");
            element = "Ca";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.scandium) {
            mWeight = allElements.get("Sc");
            element = "Sc";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.titanium) {
            mWeight = allElements.get("Ti");
            element = "Ti";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.vanadium) {
            mWeight = allElements.get("V");
            element = "V";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.copper) {
            mWeight = allElements.get("Cu");
            element = "Cu";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.zinc) {
            mWeight = allElements.get("Zn");
            element = "Zn";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.gallium) {
            mWeight = allElements.get("Ga");
            element = "Ga";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.germanium) {
            mWeight = allElements.get("Ge");
            element = "Ge";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.arsenic) {
            mWeight = allElements.get("As");
            element = "As";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.rubidium) {
            mWeight = allElements.get("Rb");
            element = "Rb";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.strontium) {
            mWeight = allElements.get("Sr");
            element = "Sr";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.yttrium) {
            mWeight = allElements.get("Y");
            element = "Y";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.zirconium) {
            mWeight = allElements.get("Zr");
            element = "Zr";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.niobium) {
            mWeight = allElements.get("Nb");
            element = "Nb";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.silver) {
            mWeight = allElements.get("Ag");
            element = "Ag";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.cadmium) {
            mWeight = allElements.get("Cd");
            element = "Cd";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.indium) {
            mWeight = allElements.get("In");
            element = "In";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.tin) {
            mWeight = allElements.get("Sn");
            element = "Sn";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.antimony) {
            mWeight = allElements.get("Sb");
            element = "Sb";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.cesium) {
            mWeight = allElements.get("Cs");
            element = "Cs";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.barium) {
            mWeight = allElements.get("Ba");
            element = "Ba";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.hafnium) {
            mWeight = allElements.get("Hf");
            element = "Hf";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.tantalium) {
            mWeight = allElements.get("Ta");
            element = "Ta";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.gold) {
            mWeight = allElements.get("Au");
            element = "Au";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.mercury) {
            mWeight = allElements.get("Hg");
            element = "Hg";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.thalium) {
            mWeight = allElements.get("Tl");
            element = "Tl";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.lead) {
            mWeight = allElements.get("Pb");
            element = "Pb";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.bismuth) {
            mWeight = allElements.get("Bi");
            element = "Bi";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.francium) {
            mWeight = allElements.get("Fr");
            element = "Fr";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.radium) {
            mWeight = allElements.get("Ra");
            element = "Ra";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.rutherfordium) {
            mWeight = allElements.get("Rf");
            element = "Rf";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.dubnium) {
            mWeight = allElements.get("Db");
            element = "Db";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
    }
   public void sumWeight(String result, Double mWeight){
       String currentWeight;
       currentWeight = String.valueOf(mWeight);
       if(result.length() > 1) {
           result = String.valueOf(Math.ceil((Double.parseDouble(currentWeight) + Double.parseDouble(result)) * 10000.0) / 10000.0);
       }
       else {
           result = currentWeight;
       }
       molecularWeight.setText(result);
   }
   public void showElementsLine(String elements, String element){

        if(elements.length() >= 1 && elements.length() <=19) {
         elements = elements + "+" + element; }
      else if(elements.length() >= 19) {
          String index[] = elements.split("[+]");
          if(index[0].length() == 1) {
              elements = currentElement.getText().toString().substring(2) + "+" + element;
          }
          else if(index[0].length() == 2) {
              elements = currentElement.getText().toString().substring(3) + "+" + element;
          }
         }

    else {
         elements = elements  + element;
       }
       currentElement.setText(elements);
   }
   public  void clear(View view){
        currentElement.setText("");
        molecularWeight.setText("");
   }

}

