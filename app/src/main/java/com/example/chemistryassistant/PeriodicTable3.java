package com.example.chemistryassistant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.TreeMap;

public class PeriodicTable3 extends AppCompatActivity {
    private Button backOnPage2;
    private TreeMap<String,Double> allElements = new TreeMap<>();
    private TextView molecularWeight;
    private TextView currentElement;
    private Button toPage4;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.periodic_table_part_3);

        backOnPage2 = findViewById(R.id.backOnPeriodicPage2);
        molecularWeight = findViewById(R.id.molecularWeight3);
        currentElement = findViewById(R.id.currentElement3);
        toPage4 = findViewById(R.id.toPeriodicTable4);
        backOnPage2.setOnClickListener(v -> {
            Intent switchToPage2 = new Intent(this, PeriodicTable2.class);
            switchToPage2.putExtra("molecular_weight",molecularWeight.getText().toString());
            switchToPage2.putExtra("current_element",currentElement.getText().toString());
            startActivity(switchToPage2);
        });
        toPage4.setOnClickListener(v -> {
            Intent switchToPage4 = new Intent(this, PeriodicTable4.class);
            switchToPage4.putExtra("molecular_weight",molecularWeight.getText().toString());
            switchToPage4.putExtra("current_element",currentElement.getText().toString());
            startActivity(switchToPage4);
        });
        molecularWeight.setText(getIntent().getStringExtra("molecular_weight"));
        currentElement.setText(getIntent().getStringExtra("current_element"));
        fillPeriodicTable();
    }
    public void fillPeriodicTable(){
        allElements.put("Cs",132.905);
        allElements.put("Ba",137.33);
        allElements.put("Hf",178.49);
        allElements.put("Ta",180.9479);
        allElements.put("Au",196.967);
        allElements.put("Hg",200.59);
        allElements.put("Tl",204.38);
        allElements.put("Pb",207.19);
        allElements.put("Bi",208.980);
        allElements.put("Fr",223.0197);
        allElements.put("Ra",226.025);
        allElements.put("Rf",261.1087);
        allElements.put("Db",262.00);
        allElements.put("Ce",140.12);
        allElements.put("Pr",140.908);
        allElements.put("Nd",144.24);
        allElements.put("Pm",144.91);
        allElements.put("Sm",150.36);
        allElements.put("Eu",151.96);
        allElements.put("Gd",157.25);
        allElements.put("Tb",158.926);
        allElements.put("Dy",162.50);
        allElements.put("Ho",164.930);
        allElements.put("Er",167.26);
        allElements.put("Tm",168.934);
        allElements.put("Yb",173.04);
        allElements.put("Lu",174.967);
        allElements.put("La",138.9055);
        allElements.put("Ac",227.0278);
    }
    public void clickElement(View view) {
        Double mWeight;
        String result = molecularWeight.getText().toString();
        String elementsLine = currentElement.getText().toString();
        String element;
        if (view.getId() == R.id.cesium) {
            mWeight = allElements.get("Cs");
            element = "Cs";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        } else if (view.getId() == R.id.barium) {
            mWeight = allElements.get("Ba");
            element = "Ba";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        } else if (view.getId() == R.id.lanthan) {
            mWeight = allElements.get("La");
            element = "La";
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
        else if (view.getId() == R.id.actinium) {
            mWeight = allElements.get("Ac");
            element = "Ac";
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
        else if (view.getId() == R.id.cerium) {
            mWeight = allElements.get("Ce");
            element = "Ce";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.praseodinium) {
            mWeight = allElements.get("Pr");
            element = "Pr";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.neodymium) {
            mWeight = allElements.get("Nd");
            element = "Nd";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.promethium) {
            mWeight = allElements.get("Pm");
            element = "Pm";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.erbium) {
            mWeight = allElements.get("Er");
            element = "Er";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.samarium) {
            mWeight = allElements.get("Sm");
            element = "Sm";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.europium) {
            mWeight = allElements.get("Eu");
            element = "Eu";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.gadolinium) {
            mWeight = allElements.get("Gd");
            element = "Gd";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.terbium) {
            mWeight = allElements.get("Tb");
            element = "Tb";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.dysprosium) {
            mWeight = allElements.get("Dy");
            element = "Dy";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.holmium) {
            mWeight = allElements.get("Ho");
            element = "Ho";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.thulium) {
            mWeight = allElements.get("Tm");
            element = "Tm";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.ytterbium) {
            mWeight = allElements.get("Yb");
            element = "Yb";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.lutetium) {
            mWeight = allElements.get("Lu");
            element = "Lu";
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
