package com.jegerima.easyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        try {
            getSupportActionBar().setTitle("Resultados");
        }catch (Exception e) {
            e.printStackTrace();
        }

        Intent intent = getIntent();
        int n1 = intent.getIntExtra("n1", 0);
        int n2 = intent.getIntExtra("n2", 0);
        int sum = intent.getIntExtra("sum", 0);
        double prom = intent.getDoubleExtra("prom", 0.0);

        boolean n1menor = intent.getBooleanExtra("n1menor", false);
        boolean n1mayor = intent.getBooleanExtra("n1mayor", false);
        boolean n1igual = intent.getBooleanExtra("n1igual", false);

        if(n1igual){
            ((TextView)findViewById(R.id.lbl_mayor)).setText(Integer.toString(n1));
            ((TextView)findViewById(R.id.lbl_menor)).setText(Integer.toString(n1));
        }else if(n1menor){
            ((TextView)findViewById(R.id.lbl_menor)).setText(Integer.toString(n1));
            ((TextView)findViewById(R.id.lbl_mayor)).setText(Integer.toString(n2));
        }else {
            ((TextView)findViewById(R.id.lbl_menor)).setText(Integer.toString(n2));
            ((TextView)findViewById(R.id.lbl_mayor)).setText(Integer.toString(n1));
        }

        ((TextView)findViewById(R.id.lbl_suma)).setText(Integer.toString(sum));
        ((TextView)findViewById(R.id.lbl_promedio)).setText(Double.toString(prom));
    }
}
