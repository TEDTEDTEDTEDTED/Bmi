package com.tedtedtedtedted.bmi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }
    public void bmi(View view){
        Log.d("MainActivity","GGG");
        EditText edWeight =(EditText) findViewById(R.id.ed_weight);
        EditText edHeight =(EditText) findViewById(R.id.ed_height);
        String w = edWeight.getText().toString();
        String h = edHeight.getText().toString();
        float weight = Float.parseFloat(w);
        float height = Float.parseFloat(w);
        float bmi = weight/(height*height);
        Log.d("BMI",String.valueOf(bmi));
        Toast.makeText(this,String.valueOf(bmi),Toast.LENGTH_LONG).show();
        new AlertDialog.Builder(this)
                .setMessage(String.valueOf(bmi)+"")
                .setTitle("BMI運算")
                .setPositiveButton("OK",null)
                .setNeutralButton("Cancel",null)
                .show();
    }
}
