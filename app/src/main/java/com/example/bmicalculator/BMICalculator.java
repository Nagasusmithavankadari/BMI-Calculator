package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BMICalculator extends AppCompatActivity {
    private EditText txtheight,txtweight;
    private TextView txtresult;
    private Button calculate;
    private Double bmi=0.0;
    private double valueheight=0,valueweight=0;
    private String resulttxt;
    LinearLayout mainLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_m_i_calculator);
        txtweight=(EditText)findViewById(R.id.weight);
        txtheight=(EditText)findViewById(R.id.height);
        txtresult=(TextView)findViewById(R.id.res);
        calculate=(Button)findViewById(R.id.calculate);
        mainLayout=(LinearLayout)findViewById(R.id.myLinearLayout);
        InputMethodManager imm=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mainLayout.getWindowToken(),0);
        calculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Calculate();
            }
        });
    }
    public void Calculate()
    {
        //Converting Text of height and weight to Double
        valueweight=Double.parseDouble(txtweight.getText().toString());
        valueheight=Double.parseDouble(txtheight.getText().toString());
        Double valueinheightmetres;
        //converting the height in cm to metre
        valueinheightmetres=valueheight/100;
        //Calculating the bmi value
        bmi= (valueweight/(valueinheightmetres*valueinheightmetres));
        resulttxt="Your BMI Value is"+" "+bmi;
        txtresult.setText(resulttxt);
    }
}