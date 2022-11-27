package com.erenbelli.calculatorapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    String oncekiSayi = "";
    String op = "+";
    boolean newOp = true;
    EditText textValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textValue = (EditText) findViewById(R.id.textValue);
    }


    public void numberEvent(View view){
        if(newOp)
            textValue.setText("");
        newOp = false;
        String number = textValue.getText().toString();
        switch (view.getId()){
            case R.id.btn1:
                number += "1";
                break;
            case R.id.btn2:
                number += "2";
                break;
            case R.id.btn3:
                number += "3";
                break;
            case R.id.btn4:
                number += "4";
                break;
            case R.id.btn5:
                number += "5";
                break;
            case R.id.btn7:
                number += "7";
                break;
            case R.id.btn6:
                number += "6";
                break;

            case R.id.btn8:
                number += "8";
                break;
            case R.id.btn9:
                number += "9";
                break;
            case R.id.btn0:
                number += "0";
                break;
            case R.id.btnNegative:
                number = "-"+number;
                break;
            case R.id.btnDot:
                number = "."+number;
                break;

        }
        textValue.setText(number);
    }

    public void operatorIslem(View view){
            newOp = true;
            oncekiSayi = textValue.getText().toString();
            switch (view.getId()){
                case R.id.btnDivide: op = "/"; break;
                case R.id.btnPlus: op = "+"; break;
                case R.id.btnMinus: op = "-"; break;
                case R.id.btnMultiply: op = "*"; break;
            }
    }

    public void equalOp(View view){
        String newNumber = textValue.getText().toString();
        double result = 0.0;
        switch (op){
            case"+":
                result = Double.parseDouble(oncekiSayi) + Double.parseDouble(newNumber);
                break;
            case"-":
                result = Double.parseDouble(oncekiSayi) - Double.parseDouble(newNumber);
                break;
            case"*":
                result = Double.parseDouble(oncekiSayi) * Double.parseDouble(newNumber);
                break;
            case"/":
                result = Double.parseDouble(oncekiSayi) / Double.parseDouble(newNumber);
                break;
        }
        textValue.setText(result+"");
    }

    public void acEvent(View view){
        textValue.setText("");
        newOp = true;
    }


    public void percentEvent(View view){
        double no = Double.parseDouble(textValue.getText().toString()) / 100;
        textValue.setText(no+"");
        newOp = true;
    }



}