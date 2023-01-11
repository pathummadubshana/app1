package com.testing.calculater;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText weight;
    EditText hight;
    Button bmi;
    TextView display,details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weight=(EditText) findViewById(R.id.weightID);
        hight=(EditText) findViewById(R.id.hightID);
        bmi=(Button) findViewById(R.id.BmiID);
        display=(TextView) findViewById(R.id.dispalyID);
        details=(TextView) findViewById(R.id.detailsID);



        bmi.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                String wei=weight.getText().toString();
                String hig=hight.getText().toString();
              Double total;

               Double num=Double.parseDouble(wei);
                Double num2=Double.parseDouble(hig);
                Double hight=num2/100;
                Double num3=hight*hight;

                total=num/num3;

                String out=Double.toString(total);



                display.setText(out);
                display.setVisibility(View.VISIBLE);

                if(total < 18.5){
                    String a="Underweight";
                    details.setText(a);
                    details.setVisibility(View.VISIBLE);
                    //details.setTextColor(android.R.color.holo_orange_light);

                }else if(total>=18.5 && total<25){
                    String a="Healthy Weight Range";
                    details.setText(a);
                    details.setVisibility(View.VISIBLE);
                   // details.setTextColor(android.R.color.holo_green_light);

                }else if(total>=25 && total<25){
                    String a="Overweight";
                    details.setText(a);
                    details.setVisibility(View.VISIBLE);
                    //details.setTextColor(android.R.color.holo_orange_light);

                }else {
                    String a="Obese";
                    details.setText(a);
                    details.setVisibility(View.VISIBLE);
                    //details.setTextColor(android.R.color.holo_red_dark);
                }

            }
        });
    }
}