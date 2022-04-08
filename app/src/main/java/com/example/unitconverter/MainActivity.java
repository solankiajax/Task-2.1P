package com.example.unitconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

        Spinner mySpinner;
        TextView decimalNumber;
        TextView textOne;
        TextView textTwo;
        TextView textThree;
        ImageButton buttonMetric;
        ImageButton buttonCelcius;
        ImageButton buttonKG;


        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        decimalNumber = (TextView) findViewById(R.id.decimalNumber);
        textOne = (TextView) findViewById(R.id.textOne);
        textTwo = (TextView) findViewById(R.id.textTwo);
        textThree = (TextView) findViewById(R.id.textThree);
        buttonMetric = (ImageButton) findViewById(R.id.buttonMetric);
        buttonCelcius = (ImageButton) findViewById(R.id.buttonCelcius);
        buttonKG = (ImageButton) findViewById(R.id.buttonKG);



        buttonMetric.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                        textOne.setText(" ");
                        textTwo.setText(" ");
                        textThree.setText(" ");
                        if(mySpinner.getSelectedItem().toString().equals("Metre")){
                                try{
                                        double d = Double.valueOf(decimalNumber.getText().toString()).doubleValue();
                                        textOne.setText(String.format("%.2f",d*100)+"  Centimetre");
                                        textTwo.setText(String.format("%.2f",d*3.281)+" Foot");
                                        textThree.setText(String.format("%.2f",d*39.37)+" inch");
                                }catch (Exception e){
                                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                }

                        }
                        else {
                                Toast.makeText(MainActivity.this, "Please select the correct conversion icon " , Toast.LENGTH_SHORT).show();
                        }
                }
        });

        buttonCelcius.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        textOne.setText("  ");
                        textThree.setText(" ");
                        textTwo.setText(" ");
                        if(mySpinner.getSelectedItem().toString().equals("Celsius")){
                                try{
                                        double d = Double.valueOf(decimalNumber.getText().toString()).doubleValue();
                                        double f = (d*1.8) + 32;
                                        double k = d+273.15;
                                        textOne.setText(String.format("%.2f",f)+"   Fahrenheit");
                                        textTwo.setText(String.format("%.2f",k)+"   Kelvin");
                                }catch (Exception E){
                                        Toast.makeText(MainActivity.this, E.getMessage(), Toast.LENGTH_SHORT).show();
                                }

                        }
                        else{
                                Toast.makeText(MainActivity.this, "Please select the correct conversion icon " , Toast.LENGTH_SHORT).show();
                        }
                }
        });

                buttonKG.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                                textOne.setText("  ");
                                textThree.setText(" ");
                                textTwo.setText(" ");
                                if(mySpinner.getSelectedItem().toString().equals("Kilograms")){
                                        try{
                                                double d = Double.valueOf(decimalNumber.getText().toString()).doubleValue();
                                                double g = d*1000;
                                                double p = d*2.205;
                                                double o = d*35.274;
                                                textOne.setText(String.format("%.2f",g)+"   Gram");
                                                textThree.setText(String.format("%.2f",p)+"   Pound(lb)");
                                                textTwo.setText(String.format("%.2f",o)+"   Ounce(Oz)");
                                        }catch (Exception E){
                                                Toast.makeText(MainActivity.this, E.getMessage(), Toast.LENGTH_SHORT).show();
                                        }

                                }
                                else{
                                        Toast.makeText(MainActivity.this, "Please select the correct conversion icon " , Toast.LENGTH_SHORT).show();
                                }
                        }
                });
        mySpinner = (Spinner) findViewById(R.id.spinnerMenu);
                ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this,
                        android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.units));
                myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mySpinner.setAdapter(myAdapter);


        }
}
