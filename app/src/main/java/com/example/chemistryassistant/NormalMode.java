package com.example.chemistryassistant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class NormalMode extends AppCompatActivity {
    private TextView currentValue;
    private TextView resultTextView;
    private TextView operations;
    private TextView latestNumber;
    private boolean isNewNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.normal_mode_page);

        currentValue = findViewById(R.id.current);
        resultTextView = findViewById(R.id.ResultView);
        operations = findViewById(R.id.operationsView);
        latestNumber = findViewById(R.id.textView2);

        Button backOnPreviousPage = findViewById(R.id.BackPageNButton);
        backOnPreviousPage.setOnClickListener(v -> {
            Intent switchOnMainPage = new Intent(this, MainActivity.class);
            startActivity(switchOnMainPage);
        });
    }

    public void clickNumber(View view) {
        String number;
        if (isNewNumber) {
            currentValue.setText("");
            isNewNumber = false;
        }

        number = currentValue.getText().toString();


        if (view.getId() == R.id.button0)
            number = number + "0";
        else if (view.getId() == R.id.button1)
            number = number + "1";
        else if (view.getId() == R.id.button2)
            number = number + "2";
        else if (view.getId() == R.id.button3)
            number = number + "3";
        else if (view.getId() == R.id.button4)
            number = number + "4";
        else if (view.getId() == R.id.button5)
            number = number + "5";
        else if (view.getId() == R.id.button6)
            number = number + "6";
        else if (view.getId() == R.id.button7)
            number = number + "7";
        else if (view.getId() == R.id.button8)
            number = number + "8";
        else if (view.getId() == R.id.button9)
            number = number + "9";
        else if (view.getId() == R.id.buttonDecimal)
            if (!dotIsPresent(number)) {
                number = number + ".";
                if (number.length() <= 1) {
                    number = "0" + number;
                }

            }


        if (currentValue.getText().length() < 9) {

            currentValue.setText(number);
        } else {
            resultTextView.setText("Вы ввели максимальное количество символов");
        }
        if(currentValue.getText().length() >= 2){
            char a =  currentValue.getText().charAt(0);
            if(a == '0' && !dotIsPresent(number)){
                String newResult = currentValue.getText().toString().substring(1);
                currentValue.setText(newResult);
            }
        }

    }

    public void changeStatus(View view) {
        if (currentValue.getText().length() > 0) {
            currentValue.setText(String.valueOf(Double.parseDouble(currentValue.getText().toString()) * -1));
        }
    }

    public void mathematics(View view) {
        isNewNumber = true;
        latestNumber.setText(currentValue.getText());
        if (currentValue.getText().length() > 0) {

            if (view.getId() == R.id.buttonPlus) {
                operations.setText("+");
            } else if (view.getId() == R.id.buttonMinus) {
                operations.setText("-");
            } else if (view.getId() == R.id.buttonMultiply) {
                operations.setText("*");
            } else if (view.getId() == R.id.buttonDivide) {
                operations.setText("/");
            }
        }
    }

    public void showResult(View view) {
        double result = 0.0;
        isNewNumber = true;
        String currentNumber = currentValue.getText().toString();
        String prevNumber = latestNumber.getText().toString();
        if (view.getId() == R.id.buttonEqual) {
            if (operations.getText() == "+") {
                result = Double.parseDouble(currentNumber) + Double.parseDouble(prevNumber);
                result = Math.ceil(result * 1000000.0) / 1000000.0;
                resultTextView.setText(String.valueOf(result));
            } else if (operations.getText() == "-") {
                result = Double.parseDouble(prevNumber) - Double.parseDouble(currentNumber);
                result = Math.ceil(result * 1000000.0) / 1000000.0;
                resultTextView.setText(String.valueOf(result));
            } else if (operations.getText() == "*") {
                result = Double.parseDouble(currentNumber) * Double.parseDouble(prevNumber);
                result = Math.ceil(result * 1000000.0) / 1000000.0;
                resultTextView.setText(String.valueOf(result));
            } else if (operations.getText() == "/") {
                if (Double.parseDouble(currentNumber) != 0) {
                    result = Double.parseDouble(prevNumber) / Double.parseDouble(currentNumber);
                    result = Math.ceil(result * 1000000.0) / 1000000.0;
                    resultTextView.setText(String.valueOf(result));
                } else resultTextView.setText("Деление на ноль невозможно");
            }

        }

        String[] rounding = resultTextView.getText().toString().split("\\.");
        if (rounding[1].length() == 1) {
            resultTextView.setText(rounding[0]);
        }
    }

  public void clear(View view){
        currentValue.setText("0");
        operations.setText("");
        latestNumber.setText("0");
        resultTextView.setText("0");
  }
  public boolean dotIsPresent(String number) {
      return number.contains(".");
  }

  public void delete(View view) {
        if(currentValue.getText().toString().length() >= 1) {
            String number = currentValue.getText().toString();
            String lastChar = number.substring(0, number.length() - 1);
            currentValue.setText(lastChar);
        }
  }
}