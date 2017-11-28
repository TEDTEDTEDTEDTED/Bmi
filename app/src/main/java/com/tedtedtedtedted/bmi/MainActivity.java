package com.tedtedtedtedted.bmi;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edWeight;
    private EditText edHeight;
    private Button bhelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findviews();
        bhelp.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                new AlertDialog.Builder(MainActivity.this)
                        .setMessage("身高體重指數（又稱身體質量指數，英文為Body Mass Index，簡稱BMI）是計算值，主要用於統計用途。")
                        .setTitle("BMI說明")
                        .setPositiveButton("OK",null)
                        .setNeutralButton("Cancel",null)
                        .show();


            }
        });

    }
    public void findviews(){
        bhelp = (Button) findViewById(R.id.b_help);
        edWeight = (EditText) findViewById(R.id.ed_weight);
        edHeight = (EditText) findViewById(R.id.ed_height);
    }
    public void bmi(View view){

        String w = edWeight.getText().toString();
        String h = edHeight.getText().toString();
        float weight = Float.parseFloat(w);
        float height = Float.parseFloat(w);
        float bmi = weight/(height*height);
        Bundle bag = new Bundle();
        bag.putFloat(getString(R.string.bmi_extra),bmi);
        bag.putString("TEST_EXTRA","bagtesting");
        Intent intent = new Intent(this,ResultActivity.class);
        intent.putExtra("BMI_EXTRA",bmi);
        startActivity(intent);
        if(height>3){
            new AlertDialog.Builder(this)
                    .setMessage(bmi+"身高單位應為公尺")
                    .setPositiveButton("OK",null)
                    .show();
        }
        if(bmi<20){
            new AlertDialog.Builder(this)
                    .setMessage(bmi+"請多吃點")
                    .show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"onStart",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"onStop",Toast.LENGTH_LONG).show();



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"onDestroy",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"onPause",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"onResume",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"onRestart",Toast.LENGTH_LONG).show();

    }
}
