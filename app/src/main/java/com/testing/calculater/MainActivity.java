package com.testing.calculater;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText weight;
    EditText hight;
    Button bmi;
    TextView display,details;
    RadioGroup radioGroup;
    RadioButton cm,ft;
    EditText in,ftee;
    double total;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weight=(EditText) findViewById(R.id.weightID);
        hight=(EditText) findViewById(R.id.hightID);
        bmi=(Button) findViewById(R.id.BmiID);
        display=(TextView) findViewById(R.id.dispalyID);
        details=(TextView) findViewById(R.id.detailsID);
        radioGroup=(RadioGroup) findViewById(R.id.radiGroupID);
        in=(EditText) findViewById(R.id.inID);
        ftee=(EditText) findViewById(R.id.ftID);




        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                cm=(RadioButton) findViewById(R.id.cmID);
                ft=(RadioButton) findViewById(R.id.fteID);


                if(cm.isChecked()){
                    weight.setVisibility(View.VISIBLE);
                    hight.setVisibility(View.VISIBLE);
                }
                else if(ft.isChecked()) {
                    weight.setVisibility(View.VISIBLE);
                   in.setVisibility(View.VISIBLE);
                   ftee.setVisibility(View.VISIBLE);
                }




            }
        });




        bmi.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {

                if(cm.isChecked()){
                    String wei=weight.getText().toString();
                    String hig=hight.getText().toString();


                    Double num=Double.parseDouble(wei);
                    Double num2=Double.parseDouble(hig);
                    Double hight=num2/100;
                    Double num3=hight*hight;

                    total=num/num3;
                    Double n= Double.valueOf(String.format("%.2f",total));


                    String out=Double.toString(n);




                    display.setText("BMI Value: "+out);
                    display.setVisibility(View.VISIBLE);

                    result();

                }else if(ft.isChecked()){
                    String wei=weight.getText().toString();
                    String feet=ftee.getText().toString();
                    String inch=in.getText().toString();


                    Double n1=Double.parseDouble(wei);
                    Double fe=Double.parseDouble(feet);
                    Double inc=Double.parseDouble(inch);


                    Double allinch=(fe*12)+inc;
                    Double newInch=(allinch*2.54)/100;


                    Double totalInch=newInch*newInch;



                    total=n1/totalInch;
                    Double n= Double.valueOf(String.format("%.2f",total));

                    String out=Double.toString(n);

                    display.setText("BMI Value: "+out);
                    display.setVisibility(View.VISIBLE);

                    result();


                }








            }
        });


    }
    public void result(){
        if(total < 18.5){
            String a="Underweight";
            details.setText(a);
            details.setVisibility(View.VISIBLE);
            //details.setTextColor(android.R.color.holo_orange_light);
            details.setTextColor(Color.parseColor("#02f650"));

        }else if(total>=18.5 && total<25){
            String a="Healthy Weight Range";
            details.setText(a);
            details.setVisibility(View.VISIBLE);
            // details.setTextColor(android.R.color.holo_green_light);
            details.setTextColor(Color.parseColor("#66aa66"));

        }else if(total>=25 && total<25){
            String a="Overweight";
            details.setText(a);
            details.setVisibility(View.VISIBLE);
            //details.setTextColor(android.R.color.holo_orange_light);
            details.setTextColor(Color.parseColor("#ff1f1f"));

        }else {
            String a="Obese";
            details.setText(a);
            details.setVisibility(View.VISIBLE);
            //details.setTextColor(android.R.color.holo_red_dark);
            details.setTextColor(Color.parseColor("#aa201e"));
        }


    }
}