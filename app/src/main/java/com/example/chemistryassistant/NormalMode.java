package com.example.chemistryassistant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class NormalMode extends AppCompatActivity {
    private TextView resultTextView;
    private TextView operations;
    private TextView latestNumber;
    private Button backOnPreviousPage;
    boolean mathFlag = false;
    boolean equalPush = false;

    private int result = 0;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.normal_mode_page);

        resultTextView = findViewById(R.id.ResultView);
        operations = findViewById(R.id.operationsView);
        latestNumber = findViewById(R.id.textView2);

        backOnPreviousPage = findViewById(R.id.BackPageNButton);
        backOnPreviousPage.setOnClickListener(v -> {
            Intent switchOnMainPage = new Intent(this, MainActivity.class);
            startActivity(switchOnMainPage);
        } );
    }
    public void clickNumber(View view) {
        String number;
        if (equalPush) {
            resultTextView.setText("");
            equalPush = false;
        }
        if (mathFlag) {
            resultTextView.setText("");
            mathFlag = false;
        }
            if (!mathFlag && !equalPush) {
                number = resultTextView.getText().toString();
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


                resultTextView.setText(number);
            }
        }


  public void mathematics(View view) {
      if (resultTextView.getText().length() > 0) {
          mathFlag = true;
          if (view.getId() == R.id.buttonPlus) {
              operations.setText("+");
              latestNumber.setText(resultTextView.getText());
              result = Integer.parseInt(latestNumber.getText().toString());
          }
          else if (view.getId() == R.id.buttonMinus) {
              operations.setText("-");
              latestNumber.setText(resultTextView.getText());
              result = Integer.parseInt(latestNumber.getText().toString());
          }
          else if (view.getId() == R.id.buttonMultiply) {
              operations.setText("*");
              latestNumber.setText(resultTextView.getText());
              result = Integer.parseInt(latestNumber.getText().toString()) ;
          }
          else if (view.getId() == R.id.buttonDivide) {
              operations.setText("/");
              latestNumber.setText(resultTextView.getText());
              result = Integer.parseInt(latestNumber.getText().toString()) ;
          }

      }
  }
  public void showResult(View view) {
        if(view.getId() == R.id.buttonEqual){
            if(operations.getText() == "+") {
                result = Integer.parseInt(resultTextView.getText().toString()) + result;
            }
            else if (operations.getText() == "-") {
                    result =   result - Integer.parseInt(resultTextView.getText().toString());
             }
            else if (operations.getText() == "*") {
                result =   result * Integer.parseInt(resultTextView.getText().toString());
            }
            else if (operations.getText() == "/") {
                if(Integer.parseInt(resultTextView.getText().toString()) != 0) {
                    result = result / Integer.parseInt(resultTextView.getText().toString());
                }
                else resultTextView.setText("Деление на ноль невозможно");
            }


                resultTextView.setText(String.valueOf(result));
                latestNumber.setText(resultTextView.getText());
                result = 0;
                equalPush = true;
            }


  }
  public void clear(View view){
        resultTextView.setText("");
        operations.setText("");
        latestNumber.setText("");
  }

}