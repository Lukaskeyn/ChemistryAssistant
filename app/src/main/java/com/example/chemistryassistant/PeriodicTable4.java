package com.example.chemistryassistant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.TreeMap;

public class PeriodicTable4 extends AppCompatActivity {
    private Button backOnPage3;
    private TreeMap<String,Double> allElements = new TreeMap<>();
    private TextView molecularWeight;
    private TextView currentElement;
    private Button toChemistryModeButton;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.periodic_table_part_4);

        backOnPage3 = findViewById(R.id.backOnPeriodicPage3);
        molecularWeight = findViewById(R.id.molecularWeight4);
        currentElement = findViewById(R.id.currentElement4);
        toChemistryModeButton = findViewById(R.id.toChemistryModeButton);
        backOnPage3.setOnClickListener(v -> {
            Intent switchToPage3 = new Intent(this, PeriodicTable3.class);
            switchToPage3.putExtra("molecular_weight",molecularWeight.getText().toString());
            switchToPage3.putExtra("current_element",currentElement.getText().toString());
            startActivity(switchToPage3);
        });
       toChemistryModeButton.setOnClickListener(v -> {
            Intent switchToPageChemistry = new Intent(this, ChemistryMode.class);
           switchToPageChemistry.putExtra("molecular_weight",molecularWeight.getText().toString());
           switchToPageChemistry.putExtra("current_element",currentElement.getText().toString());
            startActivity(switchToPageChemistry);
        });
        molecularWeight.setText(getIntent().getStringExtra("molecular_weight"));
        currentElement.setText(getIntent().getStringExtra("current_element"));
        fillPeriodicTable();
    }
    public void fillPeriodicTable(){
        allElements.put("W",183.85);
        allElements.put("Re",186.207);
        allElements.put("Os",190.2);
        allElements.put("Ir",192.22);
        allElements.put("Pt",195.08);
        allElements.put("Po",209.98);
        allElements.put("At",209.99);
        allElements.put("Rn",222.00);
        allElements.put("Sg",269.00);
        allElements.put("Bh",267.00);
        allElements.put("Th",232.038);
        allElements.put("Hs",269.0);
        allElements.put("Mt",278.00);
        allElements.put("Ds",281.00);
        allElements.put("Pa",231.04);
        allElements.put("U",238.03);
        allElements.put("Np",237.05);
        allElements.put("Pu",244.06);
        allElements.put("Am",243.06);
        allElements.put("Cm",247.07);
        allElements.put("Bk",247.07);
        allElements.put("Cf",251.08);
        allElements.put("Es",252.08);
        allElements.put("Fm",257.10);
        allElements.put("Md",258.10);
        allElements.put("No",259.10);
        allElements.put("Lr",260.10);
    }
    public void clickElement(View view) {
        Double mWeight;
        String result = molecularWeight.getText().toString();
        String elementsLine = currentElement.getText().toString();
        String element;
        if (view.getId() == R.id.wolframium) {
            mWeight = allElements.get("W");
            element = "W";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        } else if (view.getId() == R.id.rhenium) {
            mWeight = allElements.get("Re");
            element = "Re";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        } else if (view.getId() == R.id.osmium) {
            mWeight = allElements.get("Os");
            element = "Os";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.iridium) {
            mWeight = allElements.get("Ir");
            element = "Ir";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.platinum) {
            mWeight = allElements.get("Pt");
            element = "Pt";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.polonium) {
            mWeight = allElements.get("Po");
            element = "Po";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.astatium) {
            mWeight = allElements.get("At");
            element = "At";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.radon) {
            mWeight = allElements.get("Rn");
            element = "Rn";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.seaborgium) {
            mWeight = allElements.get("Sg");
            element = "Sg";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.bohrium) {
            mWeight = allElements.get("Bh");
            element = "Bh";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.hassium) {
            mWeight = allElements.get("Hs");
            element = "Hs";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.meitnerium) {
            mWeight = allElements.get("Mt");
            element = "Mt";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.darmshtatium) {
            mWeight = allElements.get("Ds");
            element = "Ds";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.thorium) {
            mWeight = allElements.get("Th");
            element = "Th";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.protactinium) {
            mWeight = allElements.get("Pa");
            element = "Pa";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.uranium) {
            mWeight = allElements.get("U");
            element = "U";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.neptunium) {
            mWeight = allElements.get("Np");
            element = "Np";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.plutonium) {
            mWeight = allElements.get("Pu");
            element = "Pu";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.americium) {
            mWeight = allElements.get("Am");
            element = "Am";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.curium) {
            mWeight = allElements.get("Cm");
            element = "Cm";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.berkelum) {
            mWeight = allElements.get("Bk");
            element = "Bk";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.californium) {
            mWeight = allElements.get("Cf");
            element = "Cf";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.einsteinium) {
            mWeight = allElements.get("Es");
            element = "Es";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.fermium) {
            mWeight = allElements.get("Fm");
            element = "Fm";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.mendelevium) {
            mWeight = allElements.get("Md");
            element = "Md";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.nobelium) {
            mWeight = allElements.get("No");
            element = "No";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.lawrencium) {
            mWeight = allElements.get("Lr");
            element = "Lr";
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
