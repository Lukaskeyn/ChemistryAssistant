package com.example.chemistryassistant;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class PeriodicTable extends AppCompatActivity {
    private Button backOnChemistryMode;
    private HashMap<String,Double> allElements = new HashMap<>();
    public  TextView molecularWeight;
    public TextView currentElement;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.periodic_table_page);

        backOnChemistryMode = findViewById(R.id.backOnChemistryPage);
        molecularWeight = findViewById(R.id.molecularWeightResult);
        currentElement = findViewById(R.id.currentElement);
        backOnChemistryMode.setOnClickListener(v -> {
            Intent switchToChemistryPage = new Intent(this, ChemistryMode.class);
            startActivity(switchToChemistryPage);
        });
        fillPeriodicTable();
    }
    public void fillPeriodicTable(){
        allElements.put("Hydrogen",1.00794);
        allElements.put("Lithium",6.941);
        allElements.put("Beryllium",9.0122);
        allElements.put("Borum",10.811);
        allElements.put("Carboneum",12.011);
        allElements.put("Nitrogenium",14.007);
    }
    public void clickElement(View view) {
        Double mWeight;
        String result = molecularWeight.getText().toString();
        String elementsLine = currentElement.getText().toString();
        String element;
        if (view.getId() == R.id.hydrogen) {
            mWeight = allElements.get("Hydrogen");
            element = "H";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        } else if (view.getId() == R.id.lithium) {
            mWeight = allElements.get("Lithium");
            element = "Li";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        } else if (view.getId() == R.id.beryllium) {
            mWeight = allElements.get("Beryllium");
            element = "Be";
            sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
     else if (view.getId() == R.id.borum) {
        mWeight = allElements.get("Borum");
            element = "B";
        sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
    }
 else if (view.getId() == R.id.carbon) {
        mWeight = allElements.get("Carboneum");
            element = "C";
        sumWeight(result, mWeight);
            showElementsLine(elementsLine,element);
        }
        else if (view.getId() == R.id.nitrogen) {
            mWeight = allElements.get("Nitrogenium");
            element = "N";
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

