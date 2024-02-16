package com.example.chemistryassistant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.TreeMap;

public class PeriodicTable2 extends AppCompatActivity {
    private Button backOnPage1;
    private TreeMap<String,Double> allElements = new TreeMap<>();
    public TextView molecularWeight;
    public TextView currentElement;
    private Button toPage3;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.periodic_table_part_2);

        backOnPage1 = findViewById(R.id.backOnPeriodicPage1);
        toPage3 = findViewById(R.id.toPeriodicTable3);
        molecularWeight = findViewById(R.id.molecularWeight2);
        currentElement = findViewById(R.id.currentElement2);
        backOnPage1.setOnClickListener(v -> {
            Intent switchToPage1 = new Intent(this, PeriodicTable.class);
            switchToPage1.putExtra("molecular_weight",molecularWeight.getText().toString());
            switchToPage1.putExtra("current_element",currentElement.getText().toString());
            startActivity(switchToPage1);
        });
        toPage3.setOnClickListener(v -> {
            Intent switchToPage3 = new Intent(this, PeriodicTable3.class);
            switchToPage3.putExtra("molecular_weight",molecularWeight.getText().toString());
            switchToPage3.putExtra("current_element",currentElement.getText().toString());
            startActivity(switchToPage3);
        });
        molecularWeight.setText(getIntent().getStringExtra("molecular_weight"));
        currentElement.setText(getIntent().getStringExtra("current_element"));
     fillPeriodicTable();
    }
    public void fillPeriodicTable(){
        allElements.put("He",4.002602);
        allElements.put("O",15.999);
        allElements.put("F",18.998);
        allElements.put("Ne",20.179);
        allElements.put("S",32.066);
        allElements.put("Cl",35.453);
        allElements.put("Ar",39.948);
        allElements.put("Mn",53.938);
        allElements.put("Cr",51.996);
        allElements.put("Fe",55.847);
        allElements.put("Co",58.933);
        allElements.put("Ni",58.70);
        allElements.put("Se",78.96);
        allElements.put("Br",79.904);
        allElements.put("Kr",83.80);
        allElements.put("Mo",95.94);
        allElements.put("Tc",97.91);
        allElements.put("Ru",101.07);
        allElements.put("Rh",102.906);
        allElements.put("Pd",106.4);
        allElements.put("Te",127.60);
        allElements.put("I",126.9045);
        allElements.put("Xe",131.29);
    }
    public void clickElement(View view) {
        Double mWeight;
        String result = molecularWeight.getText().toString();
        String elementsLine = currentElement.getText().toString();
        String element;
        if (view.getId() == R.id.helium) {
            mWeight = allElements.get("He");
            element = "He";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        } else if (view.getId() == R.id.oxygen) {
            mWeight = allElements.get("O");
            element = "O";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        } else if (view.getId() == R.id.fluorine) {
            mWeight = allElements.get("F");
            element = "F";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.neon) {
            mWeight = allElements.get("Ne");
            element = "Ne";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.sulfur) {
            mWeight = allElements.get("S");
            element = "S";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.chlorine) {
            mWeight = allElements.get("Cl");
            element = "Cl";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.argon) {
            mWeight = allElements.get("Ar");
            element = "Ar";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.manganese) {
            mWeight = allElements.get("Mn");
            element = "Mn";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.chromium) {
            mWeight = allElements.get("Cr");
            element = "Cr";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.ferrum) {
            mWeight = allElements.get("Fe");
            element = "Fe";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.cobalt) {
            mWeight = allElements.get("Co");
            element = "Co";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.nickel) {
            mWeight = allElements.get("Ni");
            element = "Ni";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.selenium) {
            mWeight = allElements.get("Se");
            element = "Se";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.bromum) {
            mWeight = allElements.get("Br");
            element = "Br";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.krypton) {
            mWeight = allElements.get("Kr");
            element = "Kr";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.molibdaenum) {
            mWeight = allElements.get("Mo");
            element = "Mo";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.technetium) {
            mWeight = allElements.get("Tc");
            element = "Tc";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.ruthenium) {
            mWeight = allElements.get("Ru");
            element = "Ru";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.rhodium) {
            mWeight = allElements.get("Rh");
            element = "Rh";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.palladium) {
            mWeight = allElements.get("Pd");
            element = "Pd";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.tellurium) {
            mWeight = allElements.get("Te");
            element = "Te";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.iodum) {
            mWeight = allElements.get("I");
            element = "I";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.xenon) {
            mWeight = allElements.get("Xe");
            element = "Xe";
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
        if(element.length() <2) {
            element = element + " ";
        }

        if(elements.length() >= 1 && elements.length() <=19) {
            elements = elements + "+" + element; }
        else if(elements.length() > 19) {
            elements = currentElement.getText().toString().substring(3) + "+" + element;

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
